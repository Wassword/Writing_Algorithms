package org.example;
import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    public static List<Integer> search(String S, String pat) {
        String concat = S + "$" + pat; //$ separates S and pat

// calculates the length of the concatenated string concat and stores it in the variable l
        int l = concat.length();

//creates an array Z of integers with a length of l
        int[] Z = new int[l];
        calculateZ(concat, Z);


        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < l; i++) {
        if (Z[i] == pat.length()) {
            result.add(i - pat.length() -1 + 1);
        }
        }
        return result;
        }
        public static void calculateZ(String str, int[] Z) {
        int n = str.length();
            //These variables are used to keep track of the left and right boundaries of the current Z-box
            int L = 0, R = 0, K;
            for (int i = 0; i < n; i++) {
                if (i > R) {
                    L =R = i;
                    while (R < n && str.charAt(R) == str.charAt(R - L)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                } else {
                    K = i - L;
                    if (Z[K] < R - i + 1) {
                        Z[i] = Z[K];
                    }else {
                        L = i;
                        while (R < n && str.charAt(R) == str.charAt(R - L)) {
                            R++;
                        }
                        Z[i] = R - L;
                        R--;
                    }


                }

            }
        }
        public static void main(String[] args) {
            String S = "batmanandrobinarebat";
            String pat = "bat";
            List<Integer> result = search(S, pat);
            if (result.isEmpty()){
                System.out.println(-1);
            }else {
                for (int idx = 0; idx < result.size(); idx++) {
                    System.out.println(result.get(idx));
                }

                }
            }
        }



