package com.example.vuesupport.program;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/7/1
 */
public class ErfenSort {


    public static int  sortDeng(int[] array,int temp){
        int low = 0;
        int hight = array.length-1;
        while (low<= hight){
            int medium = low + ((hight-low)>>1);
            if (array[medium]>temp){
                hight = medium-1;
            }else if (array[medium]<temp){
                low = medium+1;
            }else {
                if (medium == array.length-1 || array[medium+1] != temp){
                    return medium;
                }else {
                    hight= medium-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] array = {1,5,6,6,6,12,33};
        int i = sortDeng(array, 6);

        System.out.println(i);
    }

}
