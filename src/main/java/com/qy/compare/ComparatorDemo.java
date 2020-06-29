package com.qy.compare;

import com.qy.bean.Student;

import java.util.Comparator;

/**
 * Comparator 被认为是“外比较器”，我们如果需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)，
 * 那么我们就可以建立一个“该类的比较器”来进行排序，这个“比较器”只需要实现Comparator接口覆盖compare(T o1, T o2)方法即可，
 * 然后通过这个比较器对类进行比较且排序
 */
public class ComparatorDemo implements Comparator<Student> {

    /**
     * 1、o1大于o2，返回正整数
     * 2、o1等于o2，返回0
     * 3、o1小于o3，返回负整数
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
