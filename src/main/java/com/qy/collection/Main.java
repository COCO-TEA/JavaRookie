package com.qy.collection;

import com.qy.Student;
import com.qy.compare.ComparatorDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws Exception {
//        List<Integer> list = new ArrayList<Integer>();
//
//        list = new LinkedList();
//        list.get(1);

//        HashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
//        objectObjectLinkedHashMap.put(1,1);
//        Set<Map.Entry<Object, Object>> entries = objectObjectLinkedHashMap.entrySet();
//        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
//        iterator.hasNext();



//        Student s1 = new Student("xishi",29);
//        Student s2 = new Student("wangzhaojun",30);
//        Student s3 = new Student("diaocan",28);
//        Student s4 = new Student("yangyuhuan",31);
//        Student s5 = new Student("linqingxia",31);
//
//        Comparator<Student> comparator = new ComparatorDemo();
//        Map<Student,Integer> map = new TreeMap(comparator.reversed());
//        map.put(s1,1);
//        map.put(s2,1);
//        map.put(s3,1);
//        map.put(s4,1);
//        map.put(s5,1);
//
//
//        for(Map.Entry<Student,Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//        }

//        Map map = new HashMap();
//        Map map = new ConcurrentHashMap();

        //Class.forName 会执行对象的静态变量、静态方法块
        try {
            Class<?> aClass = Class.forName("com.qy.Student");
            aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //loadClass 只将对象加载入JVM中，不进行(验证-准备-解析)阶段
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.qy.Student");
        aClass.newInstance();
        System.out.println(aClass.newInstance().toString());
    }
}
