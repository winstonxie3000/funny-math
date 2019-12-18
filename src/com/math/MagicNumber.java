package com.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicNumber {
    public static void main(String[] args) {

        long largeNumber, smallNumber, difference, cnt = 0;

        List numbers = generateRandomList(4);

        while (cnt < 10) {
            cnt++;
            largeNumber = orderList(numbers, false);
            smallNumber = orderList(numbers);
            difference = largeNumber - smallNumber;
            System.out.println(cnt + ": " + largeNumber + " - " + smallNumber + " = " + difference);
            numbers = convertToList(difference);
        }
    }

    private static List<Integer> convertToList(long number) {

        List<Integer> numList = new ArrayList<>();
        String numStr = String.valueOf(number);
        for (char numChar : numStr.toCharArray()) {
            numList.add(Integer.parseInt(String.valueOf(numChar)));
        }
        return numList;
    }


    private static List<Integer> generateRandomList(int n) {
        return generateRandomList(n, false);
    }

    private static List<Integer> generateRandomList(int n, boolean distinct) {
        List<Integer> numbers = new ArrayList();
        while (numbers.size() < n) {
            int num = new Random().nextInt(10);
            if (num == 0) {
                continue;
            }
            if (distinct) {
                boolean exist = false;
                for (int j = 0; j < numbers.size() && !exist; j++) {
                    if (numbers.get(j) == num) {
                        exist = true;
                    }
                }
                if (!exist) {
                    numbers.add(num);
                }
            } else {
                numbers.add(num);
            }
        }
        return numbers;
    }

    private static long orderList(List<Integer> list, boolean orderByAsc) {

        int temp;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (orderByAsc) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(list.size()-1-i));
            }
        }
        return Long.parseLong(sb.toString());
    }


    private static long orderList(List<Integer> list) {
        return orderList(list, true);
    }

}