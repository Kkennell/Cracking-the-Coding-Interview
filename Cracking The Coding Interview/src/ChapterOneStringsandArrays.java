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
		 * 
		 * We can also use a BitStream to do this with an AND compare
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
		
		Scanner secondInput = new Scanner(System.in);
		String secondProblemStringOne = "", secondProblemStringTwo = "";
		Map<Character, Integer> stringOneMap = new HashMap<>();
		Map<Character, Integer> stringTwoMap = new HashMap<>();
		
		System.out.println("Ok. I'm happy to solve this problem for you.  Please provide me with a string of characters:");
		secondProblemStringOne = secondInput.nextLine();
		
		System.out.println("Yeah, I'm gonna need a second string to do this comparison:");
		secondProblemStringTwo = secondInput.nextLine();
		
		/*
		 * If the strings are NOT the same length, one cannot be a permutation of the other.
		 * If they are the same length, we are just going to use another HashMap where the character is the key and the value is the number of times that character is in the string. 
		 */
		
		if(secondProblemStringOne.length() != secondProblemStringTwo.length()) {
			
			System.out.println("My analysis has detected that \""+secondProblemStringOne+"\" and \""+secondProblemStringTwo+"\" are of different lengths.  They cannot be permutations of eachother. Sorry.");
		}
		else {
			for(int i=0; i< secondProblemStringOne.length(); i++) {
				if(stringOneMap.containsKey(secondProblemStringOne.charAt(i))) {
					stringOneMap.replace(secondProblemStringOne.charAt(i), stringOneMap.get(secondProblemStringOne.charAt(i))+1);
				}else {
					stringOneMap.put(secondProblemStringOne.charAt(i), 1);
				}	
			}
			
			for(int i=0; i< secondProblemStringTwo.length(); i++) {
				if(stringTwoMap.containsKey(secondProblemStringTwo.charAt(i))) {
					stringTwoMap.replace(secondProblemStringTwo.charAt(i), stringTwoMap.get(secondProblemStringTwo.charAt(i))+1);
				}else {
					stringTwoMap.put(secondProblemStringTwo.charAt(i), 1);
				}	
			}
			
			/*
			 * If String 2 has a character that is not in String 1, OR String 1 has a character in String 2, they cannot be permutations of each other.
			 */
			
			for(int i=0;i<secondProblemStringTwo.length();i++) {
				if(!stringOneMap.containsKey(secondProblemStringTwo.charAt(i)) || !stringTwoMap.containsKey(secondProblemStringOne.charAt(i))) {
					System.out.println("My analysis indicates that \""+secondProblemStringOne+"\" and \""+secondProblemStringTwo+"\" are not permutations of eachother, since they contain at least one different character. Sorry.");
					return;
				}
			}
			
			/*
			 * Now we just need to determine whether String 1 and String 2 have the same value for each key
			 */
			
			for(Map.Entry<Character, Integer> entry : stringOneMap.entrySet()) {
				if(stringOneMap.get(entry.getKey()) != stringTwoMap.get(entry.getKey())) {
					System.out.println("My analysis indicates that \""+secondProblemStringOne+"\" and \""+secondProblemStringTwo+"\" are not permutations of eachother. Sorry.");
					return;
				}
			}
			
			System.out.println("My analysis indicates that \""+secondProblemStringOne+"\" and \""+secondProblemStringTwo+"\" ARE permutations of eachother. Good Job!");
		}
		
	}
	
	public static void problemThreeSolution() {
		
		Scanner thirdInput = new Scanner(System.in);
		String thirdProblemString= "", replacementString="";
		
		System.out.println("I'd be happy to assist you with that.  Please provide me with a string, and I'll replace all spaces with \"%20\":");
		thirdProblemString = thirdInput.nextLine();
		
		for(int i=0;i<thirdProblemString.length();i++) {
			if(thirdProblemString.charAt(i) == ' ') {
				replacementString += "%20";
			}
			else {
			
				replacementString += thirdProblemString.charAt(i);
			}
		}
		
		System.out.println("Your new string is "+replacementString);
		
		return;
	}
	
	public static void problemFourSolution() {
		
	}
	
	public static void problemFiveSolution() {
		
	}
	
	public static void problemSixSolution() {
		
		Scanner sixthInput = new Scanner(System.in);
		Map<Character, Integer> characterMap = new HashMap<>();
		String sixthInputString="", replacementString="";
		int anyUpdates=0;
		
		System.out.println("I'd be happy to help you with that.  Please provide me with a string and I'll compress the string with a counts of repeated characters:");
		sixthInputString = sixthInput.nextLine();
		
		/*
		 * Similar to an earlier problem. We are going to use a HashMap where the key is the character and the value is the count.
		 */
		
		for(int i=0; i<sixthInputString.length();i++) {
			if(characterMap.containsKey(sixthInputString.charAt(i))) {
				characterMap.replace(sixthInputString.charAt(i), characterMap.get(sixthInputString.charAt(i))+1);
				anyUpdates++;
			}else {
				characterMap.put(sixthInputString.charAt(i), 1);
			}
		}
		
		/*
		 * Per the problem instructions, if no character is repeated, output the original string
		 * Otherwise output the compressed string
		 */
		if(anyUpdates == 0) {
			System.out.println("There is no need to compress your string \""+sixthInputString+"\" contains no duplicate characters to compress.");
			return;
		}
		else {
			for(Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
			
			replacementString = replacementString + entry.getKey() + characterMap.get(entry.getKey());
			}
		
			System.out.println("Your brand new concatinated string is: "+replacementString);
			return;
		}
	}
	
	public static void problemSevenSolution() {
		
	}
	
	public static void problemEightSolution() {
		
	}

	public static void problemNineSolution() {
		
	}

}
