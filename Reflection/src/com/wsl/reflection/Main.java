package com.wsl.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author 2che
 */
public class Main {

    public static void main(String[] args) throws Exception{
        // test01()
        // test02()
        test03();



    }


    /**
     * 获取Class对象的三种方法
     * 1. 实例 Object.getClass()
     * 2. Class.forName()
     * 3. int.class
     */
    public static void test01(){
        System.out.println(int.class);
    }

    /**
     * 可以通过Class对象构造一个对象的实例
     * getConstructor() 无参数构造方法
     */
    public static void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.wsl.reflection.Person");
        Person person = (Person) aClass.getConstructor().newInstance();
        person.setName("图奇");
        System.out.println(person.toString());
    }

    public static void test03() throws ClassNotFoundException {
        String name = "com.wsl.reflection.Person";
        Class clazz = Class.forName(name);
        // 获取超类Class
        Class superclass = clazz.getSuperclass();

        // 获取访问权限
        String modifiers = Modifier.toString(clazz.getModifiers());

        if (modifiers.length() > 0) {
            System.out.print( modifiers + ":");
        }
        System.out.print( "clazz :" + name);
        if (superclass != null) {
            System.out.println("superclass :" + superclass);
        }
        System.out.println("\n{\n");
        printConstructor(clazz);

    }

    public static void printConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.println("    ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print( name + "(");
            }
            Parameter[] parameters = constructor.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                if (i > 0 ){
                    System.out.print(",");
                }
                System.out.print(parameters[i].getName() + ":");
            }
            System.out.print(");");
            System.out.println();
        }

    }
}
