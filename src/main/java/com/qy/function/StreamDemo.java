package com.qy.function;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private Integer id;
    private String userName;
    private int age;
}

/**
 * 请按照给出数据，找出同时满足以下条件的用户，
 *
 * 偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 * 只输出一个用户名字
 */
public class StreamDemo {

    public static void main(String[] args) {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream()
                .filter(s -> {return s.getId() % 2 == 0;})
                .filter(s -> {return s.getAge() > 24;})
                .map(s -> {return s.getUserName().toUpperCase();})
                .sorted((o1,o2) -> {return o2.compareTo(o1);})
                .limit(1)
                .forEach(System.out::println);

//        //函数式接口
//        Function<String,Integer> function = s -> {return s.length();};
//        //断定型接口
//        Predicate<String> predicate = s -> {return s.isEmpty();};
//        //消费型接口
//        Consumer<String> consumer = s -> {System.out.println(s);};
//        //供给型接口
//        Supplier<String> supplier = () -> {return new String("a");};

    }
}
