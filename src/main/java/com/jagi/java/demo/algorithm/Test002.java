package com.jagi.java.demo.algorithm;

/**
 * 【矩形覆盖】
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Test002 {
    // 斐波那契数列的变种
    public int getMethods(int n){
        return n<3?n:getMethods(n-1)+getMethods(n-2);
    }
}
