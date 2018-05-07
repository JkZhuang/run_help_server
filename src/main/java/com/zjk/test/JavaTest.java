package com.zjk.test;

import java.util.Arrays;

public class JavaTest {

	public static void main(String[] args) {
		int[] array = new int[]{3, 1, 5};
		Arrays.sort(array);

		for (int i : array) {
			System.out.println(i);
		}
	}

}
