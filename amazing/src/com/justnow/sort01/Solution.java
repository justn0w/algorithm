package com.justnow.sort01;

/**
 *公司现有几万名员工，将所有员工的年龄按照从小到大排列
 */
public class Solution {
    public int[] ages;
    public int length;

    public Solution(int[] ages, int length){
        this.ages = ages;
        this.length = length;
    }

    /**
     * 统计年龄相同的个数，并存入数组中
     */
    public void sortAges(){
        int oldestAge = 99;
        int[] timesOfAge = new int[100];

        for (int i = 0; i < oldestAge; i++) {
            timesOfAge[i] = 0;
        }

        if(ages == null || length <=0){
            return ;
        }

        /*
        统计年龄相同的个数，并存入数组中,假如年龄为20岁的员工有100人，那么timesOfAge[20]值为100
         */
        for(int i = 0; i < length; ++i){
            int age = ages[i];
            if(age < 0 || age > oldestAge)
                System.out.println("输入的内容有误");
            ++timesOfAge[age];
        }

        int index = 0;
        /*
        先从0岁开始，读取0岁的个数，然后将0岁依次写入到ages中；接下来是1岁，读取1岁的个数，然后将1岁依次写入到ages中；以此类推。
         */
        for(int i = 0; i <= oldestAge; ++i){
            for(int j = 0; j < timesOfAge[i]; ++j){
                ages[index] = i;
                ++index;
            }
        }
    }

}
