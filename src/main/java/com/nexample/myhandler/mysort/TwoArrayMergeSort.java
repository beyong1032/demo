package com.nexample.myhandler.mysort;

import java.util.Arrays;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/8/8 14:24
 */
public class TwoArrayMergeSort {

    public static void main(String[] args) {
        int[] a={1,3,5,7,9,11,13,15,17};
        int[] b={1,3,5,7,9,11,13,15,17};
        int[] c=mergeSort(a,b);
        System.out.println(Arrays.toString(c));
        
    }
    
    public static int[] mergeSort(int[] a,int[] b){
        if(a==null||a.length==0){
            return b;
        }
        if(b==null||b.length==0){
            return a;
        }
        int[] c=new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i<a.length&&j<b.length){
            if(a[i]<b[j]){
                c[k++]=a[i++];
            }else{
                c[k++]=b[j++];
            }
        }
        while(i<a.length){
            c[k++]=a[i++];
        }
        while(j<b.length){
            c[k++]=b[j++];
        }
        return c;
    }
}
