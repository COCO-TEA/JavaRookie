package com.qy.compare;

import java.util.Comparator;

/**
 * Comparable 被认为是“ 内比较器 ” ，也是自然排序，实现该接口的类，
 * 会有自身比较的功能，则依赖compareTo方法的实现
 */
public class ComparableDemo implements Comparable<ComparableDemo>  {

    private int x;

    /**
     * 1、比较者大于被比较者，那么返回正整数
     * 2、比较者等于被比较者，那么返回0
     * 3、比较者小于被比较者，那么返回负整数
     * @param o
     * @return
     */
    @Override
    public int compareTo(ComparableDemo o) {
        return x - o.x;
    }
}
