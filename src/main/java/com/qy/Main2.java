package com.qy;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Set linkedHashSet = new LinkedHashSet();
//        Set linkedHashSet = new HashSet();
        linkedHashSet.add(10);
        linkedHashSet.add(11);
        linkedHashSet.add(5);

        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
