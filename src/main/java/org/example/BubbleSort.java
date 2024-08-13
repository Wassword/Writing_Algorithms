package org.example;



public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int N = arr.length;
        for( int i = 0; i < N - 1; i++) // Outer loop controls number of passes through the array
        for(int j = 0; j < N - i - 1; j++)// Iterates through the unsorted portion of the array


            // Swap if the element found is greater than the next element
            if (arr[j] > arr[j+1]) {
                //Swap array [j+1] and Array[j]
                int temp = arr[j];
                arr[j]= arr[j+1];
                arr[j+1] = temp;
            }
    }
    public static void main(String[] args) {
        int[] array ={7,6,3,0,9,2,1,5};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
