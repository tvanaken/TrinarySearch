package edu.unca.csci333;

// Taylor Van Aken
// 8/26/2022
// Homework 1

/**
 * Allows for the searching of an integer within an array using a recursive ternary search method
 * rather than a binary search method.
 * @author Taylor Van Aken
 */
public class trinarySearch {

	public static void main(String[] args) {

		int[] nums = {1,2,2,2,2,2,2,3,3,5,6,7,7,7,7,8,9,10};
		System.out.println(trinarySearch(nums, 3, 0, nums.length-1));
		System.out.println(trinarySearch(nums, 2, 0, nums.length-1));
		System.out.println(trinarySearch(nums, 4, 0, nums.length-1));
		System.out.println(trinarySearch(nums, 1, 0, nums.length-1));
		System.out.println(trinarySearch(nums, 10, 0, nums.length-1));
	}

	/**
	 * Recursive method implementing ternary search where it will split the array into three sections
	 * if the bounds are large enough. Otherwise, will do a small sequential search for term.
	 * @param arr integer array being searched
	 * @param term integer being searched for
	 * @param start lower index of array section being searched
	 * @param end upper index of array section being searched
	 * @return index of term, or -1 if not present
	 */
	public static int trinarySearch(int[] arr, int term, int start, int end) {

		if (end - start < 5) {
			for (int i = start; i < end + 1; i++) {
				if (arr[i] == term) {
					
					return i;
				}
			}
			
			return -1;
		}
		
		int midl = start + (end - start) / 3;
		int midr = end - (end - start) / 3;
		
		if (midl >= arr.length) {
			
			midl -= 1;
		}
		
		if (arr[midl] == term) {
			if (arr[midl-1] == term) {
				
				return trinarySearch(arr, term, start, midl - 1);
			}
			
			return midl;
		}
		
		if (arr[midr] == term) {
			if (arr[midr-1] == term) {
				
				return trinarySearch(arr, term, midl + 1, midr - 1);
			}
			
			return midr;
		}
		
		if (arr[midl] > term) {

			return trinarySearch(arr, term, start, midl - 1);
		} else if (arr[midr] < term) {
			
			return trinarySearch(arr, term, midr + 1, end);
		} else {
			
			return trinarySearch(arr, term, midl + 1, midr - 1);
		}
	}
}
