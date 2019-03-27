import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
		 * Another option is to just sort each string into a character array and run a comparison between arrays. I implemented HashMaps because I wanted to practice with them.
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
		
		Scanner fifthInput = new Scanner(System.in);
		String firstStringCompare="", secondStringCompare="";
		boolean[] stringOneBits, stringTwoBits;
		int totalFalse=0;
		
		System.out.println("Ok, I can do that. For this problem I'm going to need two strings to compare to eachother. Remeber, the only edits I'm checking for are insertion, deletion, or replacement.");
		System.out.println("What is the first string you want me to use in the comparison?");
		
		firstStringCompare = fifthInput.nextLine();
		stringOneBits = new boolean[firstStringCompare.length()];
		
		for(int i=0;i<firstStringCompare.length();i++) {
			stringOneBits[i] = false;
		}
		
		System.out.println("Good, I can work with that. Whats the second string?");
		
		secondStringCompare = fifthInput.nextLine();
		stringTwoBits = new boolean[secondStringCompare.length()];
		
		for(int i=0;i<secondStringCompare.length();i++) {
			stringTwoBits[i] = false;
		}
		
		/*
		 * As an initial matter, if the strings have more than 1 character difference in lengths, they cannot be only 1 edit apart.
		 * If the strings are the same length, they cannot be an insertion or a removal, only a replacement. Meaning they can only have one substitute character.
		 * If the strings are 1 character difference, the only possible edits are insertion and deletion.
		 */
		
		if(firstStringCompare.equals(secondStringCompare)) {
			System.out.println("My analysis is that the two strings are exactly the same! Therefore, they cannot be 1 edit apart.");
			return;
		}
		else if((firstStringCompare.length() - secondStringCompare.length()) > 1 || (secondStringCompare.length() - firstStringCompare.length()) > 1) {
			
			System.out.println("These strings cannot be only 1 edit apart due to their relative lengths.");
			return;
			
		}
		else if(firstStringCompare.length() == secondStringCompare.length()){
			
			for(int i=0; i<firstStringCompare.length();i++) {
				if(firstStringCompare.charAt(i)==secondStringCompare.charAt(i)) {
					stringOneBits[i]=true;
				}
			}
			for(int i=0;i<firstStringCompare.length();i++) {
				if(!stringOneBits[i]) {
					totalFalse++;
				}
			}
			
			if(totalFalse > 1) {
				System.out.println("My algorithm has determined that more than one replacement has been made on these strings.  They cannot be 1 edit apart.");
				return;
			}
			else {
				System.out.println("My algorithm has determined that one replacement has been made on these strings. They are only one edit apart.");
				return;
			}
			
		}
		else {
			
			
		}
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
		
		Scanner eighthInput = new Scanner(System.in);
		int arraySize=0;
		int[][] matrix;
		boolean[] row, column;
		Random r = new Random();
		Map<Integer, Integer> matrixMap = new HashMap<>();
		
		System.out.println("This is totally a problem that is within my abilities as a computer. First I'm going to need a number from you greater than or equal to 1");
		System.out.println("This will be the dimensions of the matrix.  So if you chose \"3\" the matrix would be 3x3");
		System.out.println("Ok, hit me with the number:");
		
		arraySize = Integer.parseInt(eighthInput.nextLine());
		
		matrix = new int[arraySize][arraySize];
		row = new boolean[arraySize];
		column = new boolean[arraySize];
		
		/*
		 * First things first, initialize arrays to FALSE
		 */
		
		for(int i=0; i<arraySize; i++) {
			row[i] = false;
			column[i] = false;
		}
		
		/*
		 * First things first we have to initialize the array
		 */
		System.out.println("Ok I have generated the following array for you:");
		
		for(int i=0;i<arraySize;i++) {
			for(int j=0; j<arraySize; j++) {
				matrix[i][j] = r.nextInt(9);
				System.out.print(matrix[i][j]);
				
				if(!matrixMap.containsKey(matrix[i][j])) {
					matrixMap.put(matrix[i][j], 1);
				}
				
			}
			System.out.println();
		}
		
		/*
		 * First, lets make sure it even has "0" in the array, using the HashMap we created above of course.
		 */
		
		if(!matrixMap.containsKey(0)) {
			System.out.println("Sorry, my randomly generated matrix doesn't have any \"0\" in it to replace.");
		}
		else {
			
			/*
			 * We are going to iterate through the array, if we find a "0" we are going to flag that row and column in row[] and column[]
			 * We can't just set the row and column to "0" otherwise we will just end up with a full matrix of "0"
			 */
			
			for(int i=0; i<arraySize;i++) {
				for(int j=0; j<arraySize;j++) {
					if(matrix[i][j]==0) {
						
						row[i]=true;
						column[j]=true;
						
					}
				}
			}
			
			/*
			 * At this point, we know which rows and which columns have "0" in them.  Now we can go through and replace the row and the column with "0"
			 */
			
			for(int i=0; i<arraySize; i++) {
				if(row[i] == true) {
					for(int j=0; j<arraySize; j++) {
						matrix[i][j]=0;
					}
				}
				if(column[i]==true) {
					for(int j=0; j<arraySize; j++) {
						matrix[j][i]=0;
					}
				}
			}
			
			/*
			 *  Good, now we can display the converted matrix to the user
			 */
			
			System.out.println("Hey! good news! I was able to convert the matrix I randomly generated! Behold my artwork:");
			
			for(int i=0;i<arraySize;i++) {
				for(int j=0; j<arraySize; j++) {
					System.out.print(matrix[i][j]);
				}
				System.out.println();
			}
		}
		
	}

	public static void problemNineSolution() {
		
	}
}

