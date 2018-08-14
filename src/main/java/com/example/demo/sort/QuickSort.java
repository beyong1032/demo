package com.example.demo.sort;

import org.apache.activemq.transport.auto.AutoTransportUtils;

import java.util.Arrays;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/7/30 13:29
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a={11,53,22,6,87,60,1,99,13,10,3};
        System.out.println(Arrays.toString(a));
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    
    public static void sort(int[] a,int start,int end){
        int i=start;
        int j=end;
        int key=a[i];
        while(i<j){
            while(i<j&&a[j]>=key){
                j--;
            }
            if(a[j]<=key){
                int tmp=a[j];
                a[j]=a[i];
                a[i]=tmp;
            }
            while(i<j&&a[i]<=key){
                i++;
            }
            if(a[i]>=key){
                int tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
            }
        }
        if(i>start){
            sort(a,start,i-1);
        }
        if(j<end){
            sort(a,j+1,end);
        }
    }
}
