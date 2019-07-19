public class Test {
    public static int minNumberInRotateArray(int[] array){
        int length = array.length;
        boolean flag = false;
        int value = 0;
        if(length == 0){
            return value;
        }

        for(int i=length-1; i>0; i--){
            if(array[i] <= array[i-1]){
                value = array[i];
                flag = true;
                break;
            }
        }

        if(flag==false){
            value = array[0];
        }
        return value;
    }

    public static void main(String[] args) {
        int[] array = {7,8,9,10,1,5,6};
        System.out.println(minNumberInRotateArray(array));
    }
}
