package walmart.assessment.solution.two;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputString;
		List<StringIntegerPair> output;
		
		// Get input from user
		System.out.println("Enter a string to analyse:");
		inputString= scan.nextLine();
		
		// Process and count word frequency
		output = countAndGetWordFrequency(inputString);
		
		// Print user feedback
		if(output == null) {
			System.out.println("Invalid Input");
		} else {
			System.out.println("Words Frequency:");
			System.out.print("[");
			for(int i = 0 ; i < output.size() ; i++) {
				final StringIntegerPair pair = output.get(i);
				System.out.print("{\""+ pair.getValue() + "\"," + pair.getCount() + "}");
				if (i < (output.size() - 1)) {
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
		// Close scanner		
		scan.close();

	}
	
	/**
	 * Process dirty input string and count word frequency
	 * @param dirtyInputString
	 * @return List
	 */

	@SuppressWarnings("null")
	private static List<StringIntegerPair> countAndGetWordFrequency(String dirtyInputString) {
		List<StringIntegerPair> returnVal = null;
		/**
		 * Bullet proofing
		 * Do not proceed to clean the input string
		 */
		if(dirtyInputString == null || dirtyInputString.isEmpty()) {
			return returnVal;
		} else {
			String[] cleanInputWords = cleanInputString(dirtyInputString);
			HashMap<String, Integer> container = new HashMap<String, Integer>();
			returnVal = new ArrayList<StringIntegerPair>();
			/**
			 * Iterate over words and check if exist in container
			 * if exist, increment the count. if not, add it in
			 * the container
			 */
			for (String word : cleanInputWords) {
				Integer value = container.get(word);
				if (value == null) {
					value = 1;
				} else {
					value += 1;
				}
				container.put(word, value);
			}
			/**
			 * Prepare return list, returnVal
			 * Iterate over key and value, add it to the list
			 */
			for (Map.Entry<String, Integer> containerVal : container.entrySet()) {
				StringIntegerPair val = new StringIntegerPair();
				val.setValue(containerVal.getKey());
				val.setCount(containerVal.getValue());
				returnVal.add(val);
			}

		}
		return returnVal;
	}
	/**
	 * Clean dirty input string
	 * @param dirtyInputString
	 * @return string array of words
	 * 
	 */
	private static String[] cleanInputString(String dirtyInputString) {
		String[] dirtyInputStringSpillted = dirtyInputString.toLowerCase().split("[.|,|(|)|!]");
		StringBuilder refinedInput = new StringBuilder();
		for (int i = 0; i < dirtyInputStringSpillted.length; i++) {
			dirtyInputStringSpillted[i].replaceAll("[^a-zA-Z0-9_\\\'-]", " ");
			refinedInput.append(dirtyInputStringSpillted[i].trim());
			if (i != (dirtyInputStringSpillted.length - 1))
				refinedInput.append(" ");
		}
		return refinedInput.toString().split(" ");
	}

}
