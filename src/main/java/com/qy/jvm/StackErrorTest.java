package com.qy.jvm;

/**
 * 演示栈中的异常:StackOverflowError
 * @author shkstart
 * @create 2020 下午 9:08
 *
 *  默认情况下：count : 11420
 *  设置栈的大小： -Xss256k : count : 2465
 *
 *
 *  Exception in thread "main" java.lang.StackOverflowError
 *
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }

}
