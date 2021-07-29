package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class twoPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = parse(input[0]);
        int m = parse(input[1]);

        int[] arr = new int[n + 1];
        String[] num = br.readLine().split(" ");
        for (int i = 1; i < n; i++) {
            arr[i] = parse(num[i - 1]);
        }

        int start = 0, end = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= m) {
                sum = sum - arr[start++];
            } else if (end == n) {
                break;
            } else {
                sum = sum + arr[end++];
            }

            if (sum == m)
                count++;
        }
        System.out.println(count);
    }

    private static int parse(String str) {
        return Integer.parseInt(str);
    }
}
