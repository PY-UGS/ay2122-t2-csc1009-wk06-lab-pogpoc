package Pract6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;


public class Main {
	// Random Class Function
	private static final Random RANDOM;

	static {
		RANDOM = new Random();
	}
	//Linked List Methods
	static void addAndSort(LinkedList<Integer> list, int value) { // Q1
		Iterator<Integer> iterator = list.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			int num = iterator.next();
			if (value >= num) {
				index = list.indexOf(num) + 1;
			}
		}
		list.add(index, value);
	}

	static void swapValues(LinkedList<Integer> list, int indexOne, int indexTwo) { // Q2
		int elementOne = list.get(indexOne);
		int elementTwo = list.get(indexTwo);

		if (indexOne == -1 || indexTwo == -1) {
			return;
		}

		list.set(indexOne, elementTwo);
		list.set(indexTwo, elementOne);
	}

	static int findValue(LinkedList<Integer> list, int searchVal) { // Q3
		for (int i : list) {
			if (i == searchVal) {
				return list.indexOf(searchVal);
			}
		}
		return -1;
	}

	public static int getRandomValue(int lowerBound, int upperBound) {
		return RANDOM.nextInt((upperBound - lowerBound) + 1 ) +lowerBound;
	}
	
	//Hashmaps Methods
	//addAndSort

	public static void addAndSort(Map<Integer, Integer> map, int value) {
		int idx = 0;

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			if (value >= entry.getValue().intValue()) {
				idx = entry.getKey() + 1;
			}
		}
		int currVal = value;
		int nextVal = 0;

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			if (idx == entry.getKey().intValue()) {
				nextVal = entry.getValue();
				map.put(idx, currVal);
				currVal = nextVal;
				idx++;
			}
		}
		map.put(idx, currVal);

	}
	//Swap
	public static void swapValues(Map<Integer, Integer> map, int idxOne, int idxTwo) {
		int elementOne = map.get(idxOne);
		int elementTwo = map.get(idxTwo);

		map.put(idxOne, elementTwo);
		map.put(idxTwo, elementOne);
	}
	
	//Random
	public static int findValue(Map<Integer, Integer> map, int searchVal) {

		if (!map.containsValue(searchVal)) {
			return -1;
		}

		int idx = 0;

		for (int i : map.keySet()) {
			if (map.get(i) == searchVal) {
				idx = i;
			}
		}

		return idx;
	}	
	
	// Main
	private static final int UPPER_BOUND = 10000;
	private static final int LOWER_BOUND = 1000;
	
	public static void main(String[] args) {
		System.out.println("\n***** Questions 1 - 3 using HashMap *****\n");
		
		LinkedList<Integer> main = new LinkedList<Integer>();
		main.add(1);
		main.add(3);
		main.add(5);
		main.add(7);
		main.add(9);
		main.add(11);

		// Q1
		System.out.println("Linked List before: " + main);
		addAndSort(main, 5);
		System.out.println("Linked List after: " + main);

		// Q2
		System.out.println("Before swapping of list: " + main);
		swapValues(main, 1, 5);
		System.out.println("After swapping of list: " + main);

		// Q3
		LinkedList<Integer> randomList = new LinkedList<>();
		while (randomList.size() < 500) {
			randomList.add(getRandomValue(LOWER_BOUND, UPPER_BOUND));
		}

		int indexValue = findValue(randomList, getRandomValue(LOWER_BOUND, UPPER_BOUND));
		System.out.println("Index of value is " + indexValue);
		
		System.out.println("\n***** Questions 4 - 6 using HashMap *****\n");
		
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(hashMap.size(), 0);
		hashMap.put(hashMap.size(), 3);
		hashMap.put(hashMap.size(), 5);
		hashMap.put(hashMap.size(), 7);
		hashMap.put(hashMap.size(), 9);
		hashMap.put(hashMap.size(), 11);
		// Question 4
		System.out.println("Before order of hashmap: " + hashMap);
		addAndSort(hashMap, 12);
		System.out.println("After order of hashmap: " + hashMap);
		//Question 5
		System.out.println("Before swapping of hashmap: " + hashMap);
		swapValues(hashMap, 1, 5);
		System.out.println("After swapping of hashmap: " + hashMap);
		//Question 6
		Map<Integer, Integer> randomMap = new HashMap<>();
		int mapSize = 0;

		while (mapSize < 500) {
			randomMap.put(mapSize,getRandomValue(LOWER_BOUND, UPPER_BOUND));
			mapSize++;
		}

		indexValue = findValue(randomMap, getRandomValue(LOWER_BOUND, UPPER_BOUND));
		System.out.println("Index of value is " + indexValue);

	}
}
	



