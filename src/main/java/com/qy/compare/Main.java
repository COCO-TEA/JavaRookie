package com.qy.compare;

import com.qy.Student;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        Student s1 = new Student("xishi",29);
        Student s2 = new Student("wangzhaojun",30);
        Student s3 = new Student("diaocan",28);
        Student s4 = new Student("yangyuhuan",31);
        Student s5 = new Student("linqingxia",31);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        Comparator<Student> comparator = new ComparatorDemo();

        list.sort(comparator);
        list.forEach(student -> System.out.println(student));

        Student[] a = list.toArray(new Student[0]);
        Arrays.sort(a, Collections.reverseOrder());

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        ;

    }

}
