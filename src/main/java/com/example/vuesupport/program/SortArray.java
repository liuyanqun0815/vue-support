package com.example.vuesupport.program;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Random;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/29
 */
public class SortArray {

    public static int[] fastSort(int[] array,int p,int q){
        if (q<p){
            return array;
        }
        int i = fastSortMerge(array,p,q);
        fastSort(array,p,i-1);
        fastSort(array,i+1,q);
        return array;
    }

    public static int fastSortMerge(int[] array,int p,int q){
        int i =p;
        int temp = array[q];
        for (int j = p; j < q; j++) {
            if (array[j]<temp){
                if (j!=i){
                    int t = array[j];
                    array[j]= array[i];
                    array[i] = t;
                }
                i++;
            }
        }
        int t = array[i];
        array[i] = temp;
        array[q] = t;
        return i;
    }

    public static int[] fastSort2(int[] array,int p,int q){
        if (p>=q){
            return array;
        }
        int num = partion(array,p,q);
        fastSort2(array,p,num-1);
        fastSort2(array,num+1,q);
        return array;
    }

    private static int partion(int[] array, int p, int q) {
        int temp = array[q];
        int end = q;
        while (p<q){
            while (p<q && array[q]>=temp){
                q--;
            }
            while (p<q && array[p]<temp){
                p++;
            }
            if (p<q){
                int t = array[p];
                array[p] = array[q];
                array[q] =t;
            }
        }
        int t = array[q+1];
        array[q+1] = temp;
        array[end] = t;
        return q+1;
    }

    public static int [] digui(int[] array,int left ,int right){
        int medium ;
        if (left<right) {
            medium = (left+right)/2;
            digui(array, left, medium);
            digui(array, medium + 1, right);
            mergerDidui(array, left, medium + 1, right);
        }
        return array;
    }

    private static void mergerDidui(int[] array, int left, int medium, int right) {
        //合并两个数组
        int k=0;
        int i = left;
        int j = medium;
        int[] temp = new int[right+1-left];
        while (i<medium && j<=right){
            if (array[i]>array[j]){
                temp[k++] = array[j++];
            }else {
                temp[k++] = array[i++];
            }
        }
            while (i< medium) {
                temp[k++] = array[i++];
            }
            while (j<=right){
                temp[k++] = array[j++];
        }
        for (int n = 0; n < temp.length; n++) {
            array[left++] = temp[n];
        }

    }

    public static int findKthLargest(int[] nums, int k) {
        int n = findKPartion(nums, 0, nums.length-1,k);
        int count =nums.length-1-k;
        int first = 0;
        if (count>n) {
            first = findPkSort(nums, n+1, nums.length - 1, count);
        }else {
            first = findPkSort(nums, 0, n, count);
        }

        return nums[first];

    }
    public static int findPkSort(int[] nums,int left ,int right,int k){
        int count =k;
        int medium = left;
        while (count != medium) {
            if (count  > medium) {
                left = medium;
                medium = findKPartion(nums, medium+1, right,count);
            } else {
                right = medium;
                medium = findKPartion(nums, left, medium,count);
            }
        }
        return nums[medium];
    }
    public static int findKPartion(int[] nums,int left, int right,int count){
        int i =left;
        int j = right-1;
        int temp = nums[right];
        while (i<j){
            while (i<j && nums[j]>temp){
                j--;
            }
            while (i<j && nums[i]<temp){
                i++;
            }
            if (i<j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        int t = nums[i+1];
        nums[i+1] = temp;
        nums[right] = t;
        if (left<count && count< right){
            return count;
        }
        return i+1;
    }
    static int getRanInArr(int p,int q){
        Random random = new Random();
        int i = random.nextInt(q-p+1);
        int s = i + p;
        return s;
    }
    public static int[] kuaisupaixu(int[] array,int p,int q){
        int tempIndex = getRanInArr(p,q);
        int temp = array[tempIndex];
        int start = p;
        int end = q;
        while (start<end){
            while (start<end && array[end]>temp ){
                end--;
            }
            while (start<end && array[start]<temp ){
                start ++;
            }
            if (start<end && start!=tempIndex && end!=tempIndex){
                int t = array[end];
                array[end] = array[start];
                array[start] = t;
            }
        }
        int n = array[end];
        array[end] = temp;
        array[tempIndex] = n;
        if (p<q){
            kuaisupaixu(array,p,end);
            kuaisupaixu(array,end+1,q);
        }
        return array;

    }
    public static void main(String[] args) {

        int[] array = {3,7,8,5,6,10,4};
//        int[] array1 = {3,4,5,6,8,10,7};
//        int[] array2 = {3,7,5,6,10,4};

//        int[] ints = fastSort(array, 0, array.length - 1);
//        int[] ints1 = fastSort2(array, 0, array.length - 1);
//        System.out.println(JSON.toJSONString(ints));
//        System.out.println(JSON.toJSONString(ints1));
//        int[] digui = digui(array, 0, array.length - 1);

//        System.out.println(JSON.toJSONString(digui));
//        int num = findKthLargest(array,6);
//        System.out.println(num);
        System.out.println(JSON.toJSONString(kuaisupaixu(array,0,array.length-1)));
//        for (int i = 0; i < 20; i++) {
//            int ranInArr = getRanInArr(2, 5);
//            System.out.println(ranInArr);
//        }

    }
}
