package com.example.a20190330.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test04 {

    public static void main(String[] args) {
        List<Long> list1 = new ArrayList<>();
        List<Integer> inputList = Arrays.asList(2, 5, 13, 19, 23);
        list1.add(Long.valueOf(1));
        for (Long N = Long.valueOf(1); N < 1000000; N++) {
            List<Integer> integerList = check(N);
            for (int i = 0; i < integerList.size(); i++) {
                int count = 0;
                if (inputList.contains(integerList.get(i))) {
                    count++;
                }
                if (count == integerList.size()) {
                    list1.add(N);
                }
            }
        }
        System.out.println(list1);
    }

    public static List<Integer> check(long aLong) {
        List<Integer> list = new ArrayList<>();
        int a = (int) Math.sqrt(aLong) + 1;
        int i = 2;
        while (aLong != 1 && i <= a) {
            if (aLong % i == 0) {
                aLong /= i;
                list.add(i);
                i = 2;
            } else {
                i++;
            }
        }
        if (i > a) {
            list.add(i);
        }
        return list;
    }
}
