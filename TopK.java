package com.example.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {
	private static int partition(int[] num, int start, int end){
		int index = start;
		int pivot = num[end];
		for(int i = start; i<end; i++){
			if(num[i] > pivot){
				int temp = num[i];
				num[i] = num[index];
				num[index] = temp;
				index++;
			}
		}
		num[end] = num[index];
		num[index] = pivot;
		
		return index;
	}
	private static void topK(int[] num, int start, int end, int k){
		if(start<end){
			int index = partition(num, start, end);
			if(index == k - 1) return;
			else if(index > k - 1){
				topK(num,start,index-1,k);
			}else{
				topK(num,index+1,end,k);
			}
		}
	}
	
	private static void topKheap(int[] num,int k){
		class MyComparator implements Comparator<Integer>{
			public MyComparator(){
				
			}
			@Override
			public int compare(Integer n1, Integer n2) {
				if (n2>n1) return 1;
				else if(n2<n1) return -1;
				else return 0;
			}
		}
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k,new MyComparator());
		for(int i = 0; i < k; i++){
			heap.add(num[i]);
		}
		for(int i = k; i < num.length;i++){
			if(num[i] < heap.peek()){
				heap.poll();
				heap.add(num[i]);
			}
		}
		while(!heap.isEmpty()){
			System.out.print(heap.poll()+" ");
		}
	}
	
	
	
	public static void main(String[] args){
		int[] num = {7,2,4,5,3,6,1,8,0,9};
		int k = 1;
		topKheap(num,k);
		System.out.println();
		topK(num,0,num.length-1,k);
		for(int n: num){
			System.out.print(n+" ");
		}
	}
}
