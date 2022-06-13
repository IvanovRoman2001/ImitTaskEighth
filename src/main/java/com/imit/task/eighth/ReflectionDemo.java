package com.imit.task.eighth;

import com.imit.task.eighth.differentClasses.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public class ReflectionDemo {
    public static int getCountClassHuman(List<Object> list) {
        int count = 0;
        for (Object cl: list) {
            if (cl instanceof Human) count++;
        }
        return count;
    }

    public static List<String> getListNameOfPublicMethods(Object obj) {
        List<String> listOfNamePublicMethods = new ArrayList<>();
        for (Method method: obj.getClass().getDeclaredMethods()) {
            int mods = method.getModifiers();
            if (!Modifier.isPrivate(mods)) listOfNamePublicMethods.add(method.getName());
        }
        return listOfNamePublicMethods;
    }

    public static List<String> getListOfNameAllSuperClass(Object obj) {
        List<String> listOfNameAllSuperClass = new ArrayList<>();
        Class<?> cl = obj.getClass().getSuperclass();
        while (cl != null) {
            listOfNameAllSuperClass.add(cl.getSimpleName());
            cl = cl.getSuperclass();
        }
        return listOfNameAllSuperClass;
    }

    public static int getCountOfInterfaceExecutable(List<Object> list) {
        int count = 0;
        for (Object obj: list) {
            if (obj instanceof Executable) {
                count++;
                ((Executable) obj).execute();
            }
        }
//            for (Class<?> cl: obj.getClass().getInterfaces()) {
//                if (cl.getSimpleName().equals("Executable")) {
//                    count++;
//                    try {
//                        obj.getClass().getMethod("execute").invoke(obj);
//                    } catch (NoSuchMethodException exception) {
//                        exception.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException exception) {
//                        exception.printStackTrace();
//                    }
//                    break;
//                }
//            }
//        }
        return count;
    }

    public static List<String> getListOfGetAndSet(Object obj) {
        List<String> listOfGetAndSet = new ArrayList<>();
        for (Method method: obj.getClass().getDeclaredMethods()) {
            int mods = method.getModifiers();

            if(Modifier.isPublic(mods) &&
                    !Modifier.isStatic(mods) &&
                    method.getName().startsWith("get") &&
                    method.getReturnType() != void.class &&
                    method.getParameterCount() == 0) {
                listOfGetAndSet.add(method.getName());
            }

            if(Modifier.isPublic(mods) &&
                    !Modifier.isStatic(mods) &&
                    method.getName().startsWith("set") &&
                    method.getReturnType() == void.class &&
                    method.getParameterCount() == 1) {
                listOfGetAndSet.add(method.getName());
            }
        }
        return listOfGetAndSet;
    }
}
