package com.justnow.offer;

public class Solution {
    public static void main(String[] args) {
        int[] array = {3,4,5,6,1,2};
        Solution solution = new Solution();
        int minValue = solution.solution(array);
        System.out.println(minValue);
    }

    public int solution(int array[]){
        int low=0;
        int high = array.length - 1;
        int mid=-1;
        while(array[low] >= array[high]){
            if(high-low == 1){
                mid = high;
                break;
            }
            mid = (low + high)/ 2;
            if(array[mid]>=array[low]) {
                low = mid;
            }else if(array[mid] <= array[high]){
                high = mid;
            }
        }
        return array[mid];
    }
}
