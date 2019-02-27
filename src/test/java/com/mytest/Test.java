package com.mytest;


public class Test {

	public static void main(String[] args) {
		// fun();
		Double v2 = Double.valueOf(null);
		System.out.println(v2);
	}
	
	public static void fun() {
		// int[][] arr = { { 1, 3, 4 }, { 1, 5, 1 }, { 1, 2, 1 } };
		int[][] arr = { { 20, 21, 22, 23 }, { 16, 17, 18, 19 }, { 12, 13, 14, 15 }, { 8, 11, 10, 9 } };
		//标记是否有鞍点值
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			int col = 0;
			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i][j] > arr[i][col]) {
					col = j;
				}
			}
			for (int k = 0; k < arr.length; k++) {
				if (k != i && arr[i][col] >= arr[k][col]) {
					break;
				}
				if (k == arr.length - 1) {
					System.out.println(arr[i][col] + "是鞍点值，行列下标为：" + i + "," + col);
					flag = true;
				}
			}
			if (!flag && i == arr.length - 1) {
				System.out.println("该数组没有鞍点值...");
			}
		}
	}
	
	
	
}
