package com.andresual.dev.otentikasi;

/**
 * Created by andresual on 10/9/2017.
 */

public class Singleton {
    private static Singleton INSTANCE = null;

    private Singleton() {
        String print;
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return (INSTANCE);
    }
}
