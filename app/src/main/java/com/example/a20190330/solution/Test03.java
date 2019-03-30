package com.example.a20190330.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test03 {


//    public static void main(String[] args) {
//        int members = 5;
//        int cycle = 3;
//        if (members == 2) {
//            System.out.println(2);
//        }
//        if (members == 3) {
//            System.out.println(1);
//        } else if (members > 3) {
//        int survivor1 = showJoseph(members, cycle);
//        System.out.println(survivor1);
//        }
//
//    }


    private static int showJoseph(int total, int cycle) {
        boolean[] arr = new boolean[total];
        Arrays.fill(arr, true);
        //true表示还活着的
        int kill = 0;
        int index = 0;
        int result = 0;
        while (kill < total) {
            for (int i = 0; i < cycle; i++) {
                while (!arr[index]) {
                    index = (index + 1) % total;
                }
                if (i == cycle - 1) {
                    arr[index] = false;
                    kill++;
                    index++;
                }
                if (kill == total - 1) {
                    result = (index + 1);
                }
                index = (index + 1) % total;
            }
        }
        return result;
    }


}