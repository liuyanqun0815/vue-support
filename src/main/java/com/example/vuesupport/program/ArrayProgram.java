package com.example.vuesupport.program;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/27
 */
public class ArrayProgram {

    public int removeDuplicates(int[] nums) {
        List<Integer> deletInt = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (first == nums[j]) {
                    deletInt.add(j);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (deletInt.contains(i)) {

            }

        }
        return 1;
    }

    public int removeDuplicates2(int[] nums) {

       if (nums.length>0){
           return 0;
       }

       int index =0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

}
