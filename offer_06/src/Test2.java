public class Test2 {
    /**
     * 该方法牛客网在线编译没有通过，使用内存过大的原因
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array){
        int length = array.length;
        int low = 0;
        int high = length -1;
        int mid;
        if(length == 0){
            return 0;
        }
        while((high-low)!=1){
            mid = (low+high)/2;
            if(array[mid] > array[low]){
                low = mid;
            }
            if(array[mid]<array[high]){
                high = mid;
            }
        }
        return array[high];
    }

    public static void main(String[] args) {
        int[] array = {7,8,9,10,11,5,6};
        System.out.println(minNumberInRotateArray(array));
    }
}
