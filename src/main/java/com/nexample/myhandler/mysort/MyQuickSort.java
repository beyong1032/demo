package com.nexample.myhandler.mysort;

import java.util.Arrays;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/8/8 13:50
 */
public class MyQuickSort {

    public static void main(String[] args) {
        
        int [] a={51,53,55,57,59,41,43,45,47,49,61,63,65,67,69,31,33,35,37,39,71,73,75,79};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    
    public static void sort(int []a,int low,int high){
        int start=low;
        int end=high;
        int key=a[low];
        while(start<end){
            while(start<end&&a[end]>=key){
                end--;
            }
            if(a[end]<=key){
                int tmp=a[end];
                a[end]=a[start];
                a[start]=tmp;
            }
            while(start<end&&a[start]<=key){
                start++;
            }
            if(a[start]>=key){
                int tmp=a[start];
                a[start]=a[end];
                a[end]=tmp;
            }
        }
        if(start>low){
            sort(a,low,start-1);
        }
        if(end<high){
            sort(a,end+1,high); 
        }
    }
}
