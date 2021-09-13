package Practical4;

import java.util.Arrays;
import java.lang.System;

public class sorts {
	
	private static int CUTOFF = 15;
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void selectionSort(int[] arr) {
		int minValue;
		
		for (int i = 0; i < arr.length - 1; i++) {
            minValue = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minValue]) {
                    minValue = j;
                }
            }
            swap(arr, i, minValue);
        }
	}
	
	public static void insertionSort(int[] arr) {
		insertionSort(arr, 0, arr.length-1);
	}
	
	private static void insertionSort(int[] arr, int lo, int hi) {
		int minValue;
		
		for(int i = lo; i < hi; i++) {
			minValue = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > minValue) {
				 arr[j + 1] = arr[j--];
			}
			arr[j + 1] = minValue;
		}
	}
	
	private static void mergeSort(int[] arr) {
		int n = arr.length;
		int split = n / 2;
		
		if(n < 2) {
			return;
		}
		
		int[] left = new int[split];
		int[] right = new int[n - split];
		
		int j = 0;
		for(int i = 0; i < n; i++) {
			if(i < split) {
				left[i] = arr[i];
			} else {
				right[j] = arr[i];
				j++;
			}
		}
		
		mergeSort(left);
		mergeSort(right);
		
		merge(arr, left, right);
	}
	
	private static void merge(int[] arr, int[] a, int[] b) {
		int i = 0, left = 0, right = 0;
		
		while(left < a.length && right < b.length) {
			if(a[left] < b[right]) {
				arr[i++] = a[left++];
			} else if(b[right] < a[left]) {
				arr[i++] = b[right++];
			}
		}
		
		while(left < a.length) {
			arr[i++] = a[left++]; 
		} while(right < b.length) {
			arr[i++] = b[right++];
		}
	}
		
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int piv = partition(arr, start, end);
			quickSort(arr, end, piv - 1);
			quickSort(arr, piv + 1, end);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = (start-1);
		
		for(int j = start; j < end; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i + 1, end);
		return i + 1;
	}
	
	public static void sillySort(int[] arr) {
		// BogoSort selected as silly sort
		
		// keeps track of amount of shuffles made
		int shuffles = 1;
		
		while (!isSorted(arr)) {
            shuffle(arr);
            shuffles++;
        }
		
		System.out.println("It took " + shuffles + " shuffles to sort!");
	}
	
	private static boolean isSorted(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	private static void shuffle(int[] arr) {
		int indexAtRandom;
		
		for (int i = 1; i < arr.length; i++) {
            indexAtRandom = (int) (Math.random() * (i + 1));
            swap(arr, i, indexAtRandom);
        }
	}
	
	public static void main(String[] args) {
		long start, end, timeResult;
		int nums[] = {7, -5, 3, 2, 1, 0, 45, 143, -213, 99, 2131};
		System.out.println("Original  Array:");
		System.out.println(Arrays.toString(nums));
		
		
		int nums2[] = {7, -5, 3, 2, 1, 0, 45, 143, -213, 99, 2131};
		System.out.println("\nSelectionSort:");
		start = System.nanoTime();
		selectionSort(nums2);
		end = System.nanoTime();
		timeResult = end - start;
		System.out.println(Arrays.toString(nums2));
		System.out.println("Time taken nanoseconds: "+timeResult);
		
		int nums3[] = {7, -5, 3, 2, 1, 0, 45, 143, -213, 99, 2131};
		System.out.println("\nInsertionSort:");
		start = System.nanoTime();
		insertionSort(nums3);
		end = System.nanoTime();
		timeResult = end - start;
		System.out.println(Arrays.toString(nums3));
		System.out.println("Time taken nanoseconds: "+timeResult);
		
		int nums4[] = {7, -5, 3, 2, 1, 0, 45, 143, -213, 99, 2131};
		System.out.println("\nMergeSort:");
		start = System.nanoTime();
		mergeSort(nums4);
		end = System.nanoTime();
		timeResult = end - start;
		System.out.println(Arrays.toString(nums4));
		System.out.println("Time taken nanoseconds: "+timeResult);
		
		int nums5[] = {7, -5, 3, 2, 1, 0, 45, 143, -213, 99, 2131};
		System.out.println("\nBogoSort:");
		start = System.nanoTime();
		sillySort(nums5);
		end = System.nanoTime();
		timeResult = end - start;
		System.out.println(Arrays.toString(nums5));
		System.out.println("Time taken nanoseconds: "+timeResult);
		
		int nums6[] = {7, -5, 3, 2, 1, 0, 45, 143, -213, 99, 2131};
		System.out.println("\nQuickSort:");
		start = System.nanoTime();
		quickSort(nums6);
		end = System.nanoTime();
		timeResult = end - start;
		System.out.println(Arrays.toString(nums6));
		System.out.println("Time taken nanoseconds: "+timeResult);
		
	}
}
