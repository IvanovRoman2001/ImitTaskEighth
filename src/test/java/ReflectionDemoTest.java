import com.imit.task.eighth.ReflectionDemo;
import com.imit.task.eighth.differentClasses.Human;
import com.imit.task.eighth.differentClasses.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReflectionDemoTest {
    @Test
    public void getCountClassHumanTest() {
        List<Object> list = new ArrayList<>();
        Collections.addAll(list, new Human("Ivanov", "Roman", "Ilych"),
                                 new Student("Chapala", "Max", "Alekseevich", "МПБ-003"),
                                 new Human("dasha", "colecnicina", "sergeevna"));
        assertEquals(3, ReflectionDemo.getCountClassHuman(list));
    }

    @Test
    public void getListNameOfPublicMethodsTest() {
        List<String> expected = new ArrayList<>();
        Human human = new Human("Ivanov", "Roman", "Ilych");
        Collections.addAll(expected, "getFirstName", "setFirstName", "getSurname", "setSurname", "getLastName",
                "setLastName", "execute");
        assertEquals(new HashSet<>(expected), new HashSet<>(ReflectionDemo.getListNameOfPublicMethods(human)));
    }

    @Test
    public void getListOfNameAllSuperClassTest() {
        List<String> expected = new ArrayList<>();
        Student student = new Student("Ivanov", "Roman", "Ilych", "МПБ-003");
        Collections.addAll(expected, "Human", "Object");
        assertEquals(new HashSet<>(expected), new HashSet<>(ReflectionDemo.getListOfNameAllSuperClass(student)));
    }

    @Test
    public void getCountOfInterfaceExecutableTest() {
        List<Object> list = new ArrayList<>();
        Collections.addAll(list, new Human("Ivanov", "Roman", "Ilych"),
                new Student("Chapala", "Max", "Alekseevich", "МПБ-003"),
                new Human("dasha", "colecnicina", "sergeevna"));

        assertEquals(3, ReflectionDemo.getCountOfInterfaceExecutable(list));
    }

    @Test
    public void getListOfGetAndSetTest() {
        List<String> expected = new ArrayList<>();
        Human human = new Human("Ivanov", "Roman", "Ilych");
        Collections.addAll(expected, "getFirstName", "setFirstName", "getSurname", "setSurname", "getLastName",
                "setLastName");
        assertEquals(new HashSet<>(expected), new HashSet<>(ReflectionDemo.getListOfGetAndSet(human)));
    }
}
