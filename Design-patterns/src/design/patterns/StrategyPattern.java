/**
 * 
 */
package design.patterns;

/*
 * @author mayank
 * 
 * It is a behavioral design pattern. The idea is when we have multiple algorithms for a specific 
 * task and we can choose the algorithm we want at runtime. We basically pass the algorithm as parameter.
 * These implementations are interchangeable based on the requirement and we don't have to disrupt the
 * workflow.  
 */

import java.util.Arrays;

/**
 * @author mayank
 *
 */

import java.util.List;

//Algorithm
interface SortingStrategy{
	void sort(List<?> elements);
}

//One implementation of our algorithm
class MergeSort implements SortingStrategy{
	
	@Override
	public void sort(List<?> elements) {
		System.out.println("Merge Sort Implemented..");
	}
}

//Another implementation of our algorithm
class QuickSort implements SortingStrategy{

	@Override
	public void sort(List<?> elements) {
		System.out.println("Quick Sort Implemented..");
	}
}

//Here we will pass our algorithm at runtime
class Sorting{
	private List<?> elements;
	
	public Sorting(List<?> elements) {
		this.elements = elements;
	}
	
	public void sortData(SortingStrategy strategy) {
		strategy.sort(elements);
	}
}

public class StrategyPattern {

	public static void main(String[] args) {
		
		List<Integer> elements = Arrays.asList(5, 2, 9, 6, 1);
		Sorting sorting = new Sorting(elements);
		sorting.sortData(new MergeSort());
		
		sorting.sortData(new QuickSort());
	}
}
