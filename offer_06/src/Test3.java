public class Test3 {
    /**
     * 考虑特例的情况如{1,0,1,1,1}和{1,1,1,0,1}
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array){
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int low = 0;
        int high = length - 1;
        int mid = low;

        while(array[low] >= array[high]){
            if(high -low ==1){
                mid = high;
                break;
            }
            mid = (high + low) / 2;
            if(array[low] == array[high] && array[mid] == array[high]){
                return findMin(array, length);
            }
            if(array[low] < array[mid]){
                low = mid;
            }
            if(array[mid] < array[high]){
                high = mid;
            }

        }
        return array[mid];
    }
    public static int findMin(int[] array, int length){
        int min=array[0];
        for(int i=1; i< length; i++){
            if(min>=array[i]){
                min = array[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] array = {7,8,9,10,11,5,6};
        int[] array1 = {1,0,1,1,1};
        int[] array2 = {1,1,1,0,1};
        System.out.println(minNumberInRotateArray(array));
        System.out.println("测试用例1：" + minNumberInRotateArray(array1));
        System.out.println("测试用例2：" + minNumberInRotateArray(array2));
    }
}
