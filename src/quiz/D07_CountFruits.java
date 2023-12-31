package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D07_CountFruits {
	// 다음 과일들로 가득 찬 크기 1000개의 랜덤 배열을 생성한 후
	// 각 과일이 몇 번 등장했는지 세어보세요
	
	final public static String[] fruits = {
		"Apple", "Banana", "Orange", "Watermelon", "Strawberry", "Grape", "Melon", "Peach", "Cherry"
	};
	
	public static void main(String[] args) {
		String[] randomFruits = new String[1000];
		
		int fruitCount = fruits.length;
		int len = randomFruits.length;
		
		for(int i = 0; i < len; ++i) {
			randomFruits[i] = fruits[(int)(Math.random()*fruitCount)];
		}
		
		System.out.println(Arrays.toString(randomFruits));
		
		Map<String, Integer> countMap = new HashMap<>();
		
		for(String ranFruit : randomFruits) {
			if(!countMap.containsKey(ranFruit)) {
				// 처음 나온 과일은 개수 1로 시작
				countMap.put(ranFruit, 1);				
			} else {
				// 이미 추가했던 과일은 개수를 가져와서 1더한 후 다시 저장
				countMap.put(ranFruit, countMap.get(ranFruit)+1);
			}
		}
		System.out.println(countMap);
		
		
		
//===============================================================================================================
		
		
		List<String> fruitsBasket = new ArrayList<>();
		
		for(int i = 0 ; i < 1000 ; i++) {
			fruitsBasket.add(fruits[(int)(Math.random()*fruits.length)]);
		}
		System.out.println(fruitsBasket);
		
		// 키를 과일로 놓고 과일의 숫자를 value로 
		Map<String, Integer> fruitList = new HashMap<>();
		
		
		for(int i = 0 ; i < fruitsBasket.size() ; i++) {
			String fruit = fruitsBasket.get(i);
			fruitList.putIfAbsent(fruitsBasket.get(i), 0);
			if(fruitList.containsKey(fruit)) {
				int num = fruitList.remove(fruit);
				num++;
				fruitList.put(fruit, num);
			}	
		}
		
		
		System.out.println(fruitList);
	}
}
