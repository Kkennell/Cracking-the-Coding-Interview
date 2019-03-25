import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Kmkennelly
 * March 2019
 *
 */
public class ChapterOneStringsandArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String problemSelection = "";
		
		System.out.println("Welcome to my technical demonstration of the solutions to the Cracking the Coding interview chapter one problems.\nFirst things first, I'm going to need you to let me know what problem you want me to solve.");
		System.out.println("Please make a selection 1.1 - 1.9. Thanks!");
		
		problemSelection = input.nextLine();
		
		switch(problemSelection) {
		
		case "1.1":
			
			System.out.println("Problem one asks the programmer to implement an algorithm to determine if a string has all unique characters.");
			
			problemOneSolution();
			
			break;
		
		case "1.2":
			
			System.out.println("Problem two asks the programmer to implement an algorithm to determine if, given two strings, one is a permutation of the other.");
			
			problemTwoSolution();
			
			break;
		
		case "1.3":
			
			System.out.println("Problem three asks the programmer to implement an algorithm to replace all spaces in a string with \"%20\"");
			
			problemThreeSolution();
			
			break;
		
		case "1.4":
			
			System.out.println("Problem four asks the programmer to implement an algorithm to determine whether any permutation of a provided string can be made into a palindrome");
			
			problemFourSolution();
			
			break;
			
		case "1.5":
			
			System.out.println("Problem five asks the programmer to implement an algorithm to determine if, given two strings, one string is no more than one edit (insertion, removal, and replacement of a character) away from the other.");
			
			problemFiveSolution();
			
			break;
		
		case "1.6":
			
			System.out.println("Problem six asks the programmer to implement an algorithm to perform basic string compression that uses the counts of repeated characters.");
			
			problemSixSolution();
			
			break;
		
		case "1.7":
			
			System.out.println("Problem seven asks the programmer to implement an algorithm to rotate an NxN matrix 90 degrees");
			
			problemSevenSolution();
			
			break;
		
		case "1.8":
			
			System.out.println("Problem eight asks the programmer to implement an algorithm that replaces the entire row and column with \"0\" if an element in the array is \"0\"");
			
			problemEightSolution();
			
			break;
		
		case "1.9":
			
			System.out.println("Problem nine asks the programmer to implement an algoritm to check if one string is a rotation of the other.");
			
			problemNineSolution();
			
			break;
		
		default:
			System.out.println("You have requested a solution for which there is no problem.  Nice.");
		}

		System.out.println("Thank you for testing my systems. Goodbye.");
	}
	
	public static void problemOneSolution() {
		
		Scanner firstInput = new Scanner(System.in);
		String firstProblemString = "";
		Map<Character, Integer> characterMap = new HashMap<>();
		
		System.out.println("Ok. I'm happy to solve this problem for you.  Please provide me with a string of characters.");
		firstProblemString = firstInput.nextLine();
		
		/*
		 * While we could use a nested for loop and brute force a solution, its more efficient to use a HashMap which computes in worst case O(n) instead of O(n^2)
		 * when using nested for loops.
		 */
		
		for(int i=0; i<firstProblemString.length(); i++) {
			if(characterMap.containsKey(firstProblemString.charAt(i))) {
				System.out.println("My analysis is that \""+firstProblemString+"\" contains duplicate characters. Sorry!");
				return;
			}
			else {
				characterMap.put(firstProblemString.charAt(i), 1);
			}
		}
		
		System.out.println("My analysis is that \""+firstProblemString+"\" does NOT contain duplicate characters.");
		return;
		
	}
	
	public static void problemTwoSolution() {
		
	}
	
	public static void problemThreeSolution() {
		
	}
	
	public static void problemFourSolution() {
		
	}
	public static void problemFiveSolution() {
		
	}
	
	public static void problemSixSolution() {
		
	}
	
	public static void problemSevenSolution() {
		
	}
	
	public static void problemEightSolution() {
		
	}

	public static void problemNineSolution() {
		
	}

}
