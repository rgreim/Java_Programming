package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String a = "";
    private static String b = "";

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("First String: ");
        try {
            a = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Second String: ");
        try {
            b = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Distance: ");
        System.out.println(lvd(a.length(), b.length()));
    }

    private static int lvd(int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;
        return min(lvd(i - 1, j) + 1,
                lvd(i, j - 1) + 1,
                lvd(i - 1, j - 1) + ((a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1));
    }

    private static int min(int i, int j, int k) {
        return (i < Math.min(j, k) ? i : Math.min(j, k));
    }
}
