package quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class D02_Jiphap<T>{
	/*
	 * 1. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 합집합을 Set으로 반환하는 메서드
	 * 		[1, 2, 3] + [2, 3, 4, 5] => [1, 2, 3, 4, 5]
	 * 2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set으로 반환하는 메서드
	 * 		[1, 2, 3] 교 [2, 3, 4, 5] => [2, 3]
	 * 3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set으로 반환하는 메서드
	 *		[1, 2, 3] - [2, 3, 4, 5] => [1]
	 *		[2, 3, 4, 5] - [1, 2, 3] => [4, 5]
	 */
	// 두 Set을 전달받으면 합집합을 만들어 리턴하는 메서드
//	static Collection union(Collection a, Collection b) {
//		a.addAll(b);
//		return a;
//	}
	Set<T> union(Collection <? extends T> a, Collection <? extends T> b) {
		HashSet<T> union = new HashSet<>();
		union.addAll(a);
		union.addAll(b);
		return union;
	}
	
	Set<T> inter(Collection<T> a, Collection<T> b) {
		HashSet<T> inter = new HashSet<>();
		
		inter.addAll(a);
		inter.retainAll(b); // b와 일치하는 것만 남긴다 (교집합)
//		for (int i : a) {
//			if(b.contains(i)) {
//				inter.add(i);				
//			}
//		}
//		
		return inter;
	}
	
	Set<T> diff(Collection<T> a, Collection<T> b) {
		HashSet<T> diff = new HashSet<>();
		diff.addAll(a);
		diff.removeAll(b);
		return diff;
	}
	
	public static void main(String[] args) {
		
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		list1.add(2);
		list1.add(2);
		list1.add(4);
		list1.add(6);
		
		D02_Jiphap<Integer> quiz = new D02_Jiphap<Integer>();
		
		System.out.println(quiz.union(set1,set2));
		System.out.println(quiz.union(set1,list1));
		System.out.println(quiz.inter(set1,set2));
		System.out.println(quiz.inter(set1,list1));
		System.out.println(quiz.diff(set1,set2));
		System.out.println(quiz.diff(set1,list1));
		
//		int[] nums = {1, 2, 3};
//		int[] otherNums = {2, 3, 4, 5};
//		
//		
//		Jiphap s1 = new Jiphap();
//		
//		s1.combination(s1.getList(nums), s1.getList(otherNums));
//		s1.intersection(s1.getList(nums), s1.getList(otherNums));
//		s1.relative(s1.getList(nums), s1.getList(otherNums));
//		s1.relative(s1.getList(otherNums), s1.getList(nums));
//		System.out.println();
		
		
//		String[] colors = {"R", "G", "B", "K"};
//		String[] colors2 = {"C", "M", "Y", "K"};
//		s1.combination(colors, colors2);
//		s1.intersection(colors, colors2);
//		s1.relative(colors, colors2);
//		s1.relative(colors2, colors);
	}
}

class Jiphap {
//	combination
//	intersection
//	relative
	
	public ArrayList<Integer> getList(int[] num) {
		ArrayList list = new ArrayList();
		for(int i = 0 ; i < num.length ; i++) {
			list.add(num[i]);			
		}
		return list;
	}

	public void combination(ArrayList<Integer> nums, ArrayList<Integer> otherNums) {
		HashSet<Integer> combination = new HashSet<>();
		combination.addAll(nums);			
		combination.addAll(otherNums);
		System.out.println(combination);
	}

	public void intersection(ArrayList<Integer> nums, ArrayList<Integer> otherNums) {
		HashSet<Integer> intersection = new HashSet<>();
		for(Integer number : nums) {
			for(Integer othernumber : otherNums) {
				if(number == othernumber) {
					intersection.add(number);
				}
			}
		}
		System.out.println(intersection);
	}
	
	public void relative(ArrayList<Integer> nums, ArrayList<Integer> otherNums) {
		HashSet<Integer> relative = new HashSet<>();
		relative.addAll(nums);			
		HashSet<Integer> intersection = new HashSet<>();
		for(Integer number : nums) {
			for(Integer othernumber : otherNums) {
				if(number == othernumber) {
					intersection.add(number);
				}
			}
		}
		relative.removeAll(intersection);
		System.out.println(relative);
	}



	public void combination(String[] str, String[] str1) {
		HashSet<String> combination = new HashSet<>();
		for(int i = 0 ; i < str.length ; i++) {
			combination.add(str[i]);			
		}
		for(int i = 0 ; i < str1.length ; i++) {
			combination.add(str1[i]);			
		}
		System.out.println(combination);
	}

	public void intersection(String[] str, String[] str1) {
		HashSet<String> strs = new HashSet<>();
		HashSet<String> otherstrs = new HashSet<>();
		HashSet<String> intersection = new HashSet<>();
		for(int i = 0 ; i < str.length ; i++) {
			strs.add(str[i]);			
		}
		for(int i = 0 ; i < str1.length ; i++) {
			otherstrs.add(str1[i]);			
		}
		
		for(String otherstr : otherstrs) {
			for(String st : strs) {
				if(otherstr == st) {
					intersection.add(otherstr);
				}
			}
		}
		System.out.println(intersection);
	}
	
	public void relative(String[] str, String[] str1) {
		HashSet<String> strs = new HashSet<>();
		HashSet<String> otherStrs = new HashSet<>();
		HashSet<String> relative = new HashSet<>();
		HashSet<String> r_intersection = new HashSet<>();
		for(int i = 0 ; i < str.length ; i++) {
			relative.add(str[i]);			
		}
		for(int i = 0 ; i < str.length ; i++) {
			strs.add(str[i]);			
		}
		for(int i = 0 ; i < str1.length ; i++) {
			otherStrs.add(str1[i]);			
		}
		
		for(String otherStr : otherStrs) {
			for(String st : strs) {
				if(otherStr == st) {
					r_intersection.add(otherStr);
				}
			}
		}
		relative.removeAll(r_intersection);
		System.out.println(relative);
	}



}
