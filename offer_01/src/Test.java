

/*
题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

从数组的右上角开始查找，
    如果右上角的数字大于目标，说明该列都大于这个目标，所以可以排除该列，转向其相邻左边的一列；
    如果右上角的数字小于目标，说明该行都小于目标，所以可以排除该行，转向其相邻的下一行；
    如果相等，则返回查找成功
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 7;
        int[][] array = {{1,2,8,9},{4,7,10,13}};
        System.out.println(solution.Find(target, array));
    }
}
