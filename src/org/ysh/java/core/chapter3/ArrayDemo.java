package org.ysh.java.core.chapter3;

import java.util.Arrays;

/**
 * Java中数组
 * @author yshin1992
 *
 */
public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化数组的方式 1
		int[] arr = new int[10];
		//初始化数组方式 2
		int[] arr2 = {1,2,3,4,5,6};
		
		System.out.println(Arrays.toString(arr2));
		//匿名数组
//		new int[]{1,2,3,4,5};
		//数组拷贝
		int[] copyArr = Arrays.copyOf(arr2, arr2.length);
		//数组遍历
//		for(int i = 0 ; i < copyArr.length ; i ++ )
//		{
//			System.out.println(copyArr[i]);
//		}
		//增强型for循环
//		for(int tmp : copyArr)
//		{
//			System.out.println(tmp);
//		}
		
		for(int i = 0; i < copyArr.length ; i ++  )
		{
			copyArr[i] = (int) (Math.random()*1000);
		}
		
		//数组排序
		Arrays.sort(copyArr);
		for(int tmp : copyArr)
		{
			System.out.println(tmp);
		}
		
		//数组搜索指定值
		int searchIndex = Arrays.binarySearch(copyArr, 3);
		System.out.println(searchIndex);
		
		
		//数组充填
		Arrays.fill(arr, -1);
		
		//System类的一个数组拷贝
		System.arraycopy(copyArr, 0, arr, 0, copyArr.length);
		
		//测试 目标数组空间不足的情况下，调用arraycopy
		//结果会报数组越界异常：java.lang.ArrayIndexOutOfBoundsException
//		int[] tempArr = new int[1];
//		System.arraycopy(copyArr, 0, tempArr, 0, copyArr.length);
		
		//数组打印
		System.out.println(Arrays.toString(arr));
		
		//不规则数组
		//1
		//1 1
		//1 2 1
		int[][] unreg = new int[3][];
		unreg[0] = new int[]{1};
		unreg[1] = new int[]{1,1};
		unreg[2] = new int[]{1,2,1};
		for(int[] tmpArr : unreg)
		{
			for(int tmp : tmpArr)
			{
				System.out.print(tmp+"\t");
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(unreg));
		System.out.println(Arrays.deepToString(unreg));
		
		int[][][] unreg2 = new int[3][][];
		unreg2[0] = new int[][]{{1,2},{33,43}};
		unreg2[1] = new int[][]{{2,4},{41,3}};
		unreg2[2] = new int[][]{{23,14},{413,39}};
		System.out.println(Arrays.toString(unreg2));
		System.out.println(Arrays.deepToString(unreg2));
	}

}
