package org.example;

import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        int number = 12;
        int total1 = 0;
//        for (int i = 1; i <= number; i++) {
//            total1 += i;
//        }
//        System.out.println("total1 = " + total1);
//    }

    int total2 = number * (number + 1) / 2;
        System.out.println( "total2 = " + total2);
    }
}
