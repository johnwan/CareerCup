package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortString {

	private static void reorder(String s, String order){
		class StrComparator implements Comparator<Character>{
			String dic;
			public StrComparator(String dic){
				this.dic = dic;
			}
			@Override
			public int compare(Character c1, Character c2) {
				if((dic.indexOf(c1) == -1 && dic.indexOf(c2) != -1) || dic.indexOf(c1) > dic.indexOf(c2))
					return 1;
				else if( (dic.indexOf(c1) != -1 && dic.indexOf(c2) == -1) || dic.indexOf(c1) < dic.indexOf(c2))
					return -1;
				return 0;
			}
		}
		StrComparator sComp = new StrComparator(order); 
		ArrayList<Character> res = new ArrayList<Character>();
		for(Character c: s.toCharArray()){
			res.add(c);
		}
		Collections.sort(res, sComp);
		for(Character c: res){
			System.out.print(c+" ");
		}
	}
	public static void main(String[] args){
		String s1 = "banana";
		String s2 = "na";
		reorder(s1,s2);
	}
}
