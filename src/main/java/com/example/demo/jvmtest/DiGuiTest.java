package com.example.demo.jvmtest;

import java.util.Arrays;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/6/27 10:07
 */
public class DiGuiTest {
    
    int a[]={15,8,7,32,28,11,1,54,99,67,66};
    
    public static int getage( int n){
        if(n<2){
            return 10;
        }else{
            return getage(n-1)+2;
        }
    }
    
    public int[] getsort(int[] a){
        int len=a.length;
        int insertnum;
        for(int i=1;i<len;i++){
            insertnum=a[i];
            int j=i-1;
            while(j>=0&&a[j]>insertnum){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=insertnum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(DiGuiTest.getage(8));
        DiGuiTest diGuiTest=new DiGuiTest();
        System.out.println(Arrays.toString(diGuiTest.a));
        System.out.println(Arrays.toString(diGuiTest.getsort(diGuiTest.a)));
    }
}
