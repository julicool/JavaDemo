package com.jagi.java.demo.algorithm;

import java.util.ArrayList;

/**
 * 【旋转最小数字】
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 */
public class Test001 {
    // 思路1，既然非递减那么一般情况下是左边的数<=右边的数，只有在首尾相间时才会，左边的数>右边的数(一般不可能相等)
    public static int getMinNumber(int[] array) {
        int arraySize = array.length;
        for (int i = 0; i < (arraySize - 1); i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    // 思路2，二分查找。如果一段数组中，中间数<最右数，说明目标在左半边。如果中间数>最右数，说明目标在右半边。
    // 如果中间数=最右数，那么数组片段范围缩小一下再比较
    public static int getMinNumber2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] > array[right]) {
                left = mid+1; // 避免只有两个数的情况（两个数时mid一定会取左边的数，然后就一直循环了）
            } else {
                right--;
            }
        }
        return array[left];

    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 1, 1, 1, 1, 1, 1};
        System.out.println(Test001.getMinNumber2(array));
        System.out.println(Test001.getMinNumber(array));



    }

}
