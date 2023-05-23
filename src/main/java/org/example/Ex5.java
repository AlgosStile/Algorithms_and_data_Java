package org.example;

import java.util.Date;

import static org.example.Ex4.fib;

public class Ex5 {
    public static void main(String[] args) {
        for (int i = 10; i < 100; i += 10) {

            Date start1 = new Date();
            fib(100);
            Date stop1 = new Date();

            Date start2 = new Date();
            fib(100);
            Date stop2 = new Date();
            System.out.println("++++++" + i);
            System.out.println(stop1.getTime() - start1.getTime());
            System.out.println(stop2.getTime() - start2.getTime());

        }
    }

    public static void fib(int num) {
        int first = 1;
        int second = 1;

        for (int i = 2; i < num; i++) {
            int third = first + second;
            first = second;
            second = third;

        }
        System.out.println(second);
    }

}
