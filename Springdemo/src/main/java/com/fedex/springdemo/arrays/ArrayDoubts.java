package com.fedex.springdemo.arrays;

public class ArrayDoubts {
	
	static int[] arr = {1,3,4,5,7,2,6,8,1,8,5,79,10};
	
	public static void main(String[] args) {
//		int[] arr = {4,1,3,5,2,8,7,10,65,78,98};
//		
//		int count;
//		
//		for(int i =0; i<arr.length; i++) {
//			count=0;
//			for(int j =0; j<arr.length; j++) {
//				if(arr[i]<arr[j]) {
//					count ++;
//				}
//			}
//			
//			if(count==1) {
//				System.out.println(arr[i]);
//				break;
//			}
//		}
//		
		//reverseArray();
		
		sortArray(arr);
	}
	
	public static void reverseArray() {
		int[] arr = {1,2,3,4,5,6,7,8};
		System.out.println();
		System.out.print("{");
		for (int i : arr) {
			System.out.print(i+", ");
		}
		System.out.print("}");
		int n =arr.length;
		
		for(int i=0; i<=(n/2)-1; i++) {
			
			int temp =arr[n-1-i];
			arr[n-1-i]=arr[i];
			arr[i]=temp;
		}
		System.out.println();
		System.out.print("{");
		for (int i : arr) {
			System.out.print(i+", ");
		}
		System.out.print("}");
	}
	
	public static void sortArray(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=0; j<arr.length; j++) {
				if(arr[i]<arr[j]) {
					int temp =arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println();
		System.out.print("{");
		for (int i : arr) {
			System.out.print(i+", ");
		}
		System.out.print("}");
	}

}
