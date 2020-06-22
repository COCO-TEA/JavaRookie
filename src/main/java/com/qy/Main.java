package com.qy;

import com.sun.jndi.toolkit.url.UrlUtil;
import sun.misc.Launcher;

import java.net.URL;

public class Main {

    private static int i = 10;

    private static final int j ;

    static {
        j = 11;
    }

    public Main() {
        this.i = 20;
    }

    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urLs) {
            System.out.println(url);
        }
    }

}
