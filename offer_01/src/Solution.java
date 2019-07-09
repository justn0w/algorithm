public class Solution {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int columns = array[0].length;
        boolean flag = false;
        int i = 0;
        int j;
        j = columns - 1;
        while(i<=(rows-1) && j>=0){
            if(array[i][j] == target){
                return true;
            }
            if(array[i][j] > target){
                j--;
                continue;
            }
            if(array[i][j] < target){
                i++;
                continue;
            }
        }
        return false;
    }
}
