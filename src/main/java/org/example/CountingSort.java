package org.example;

public class CountingSort {
    public static String countingSort(String arr) {
        int n = arr.length();

        // Count array to store the count of individual character
        int[] count = new int[26];
        // An output array to store sorted characters
        char[] output = new char[n];

        // Initialize count array
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }

        // Store count of each character in the count array
        for (int i = 0; i < n; i++) {
            count[arr.charAt(i) - 'a']++;
        }

        // Update count array to contain actual positions of characters
        for (int i = 1; i < 26; i++) { // Start from 1 to avoid ArrayIndexOutOfBoundsException
            count[i] += count[i - 1];
        }

        // Build the output character array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr.charAt(i) - 'a'] - 1] = arr.charAt(i);
            count[arr.charAt(i) - 'a']--;
        }

        // Convert the output array to a string and return it
        return new String(output);
    }

    public static void main(String[] args) {
        String arr = "geekforgeeks";
        String sortedString = countingSort(arr);
        System.out.println(sortedString);
    }
}
