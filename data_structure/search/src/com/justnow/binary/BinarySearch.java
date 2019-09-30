package com.justnow.binary;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,20,31,40,60,70};
        int index;
        int key=40;
        index = search(array, key);
        System.out.println(key+"的位置是: " + index);
    }

    public static int search(int[] array, int key){
        int low = 0;
        int high = array.length-1;
        int mid;
        while (low <= high){
            mid = (low+high)/2;
            if(array[mid] == key){
                return mid;
            }else if(array[mid] > key){
                high = mid-1;
            }else
                low = mid+1;
        }
        return -1;
    }
}
