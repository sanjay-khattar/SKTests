/**
 * 
 */
package tests.sanjay;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * How do you find the first non-repeated character in a string?
 *		For example:
 *			input: 'aaabbccxyyz' -> out: 'x'
 *			input: 'abcabcabcxxz' -> out: 'z'
 * </pre>
 *
 * @author sanjaykdev
 *
 */
public class CharacterSearch {

	private static final Map<String, Character> testcases = new HashMap<String, Character>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testcases.put("aaabbccxyyz", 'x');
		testcases.put("abcabcabcxxz", 'z');

		boolean allPassed = true;

		for (Map.Entry<String, Character> testCase : testcases.entrySet()) {
			System.out.print("testCase: " + testCase);

			Character actualResult = getFirstNonRepeatingChar(testCase.getKey());
			boolean passed = actualResult.equals(testCase.getValue());

			if (!passed) {
				System.out.println(" Failed!");
			} else {
				System.out.println(" Passed.");

			}

			allPassed = allPassed && passed;
		}

		if (allPassed) {
			System.out.println("All tests pass!");
		} else {
			System.out.println("At least one failure! :( ");
		}

	}

	public static Character getFirstNonRepeatingChar(String strInput) {
		Character firstNonRepeatingChar = null;

		int strLength = strInput.length();

		if (strLength > 0) {
			HashMap<Character, Boolean> charactersMap = new HashMap<Character, Boolean>(strLength);

			for (int i = 0; i < strLength; i++) {
				char character = strInput.charAt(i);
				if (charactersMap.containsKey(character)) {
					charactersMap.put(character, Boolean.FALSE);
				} else {
					charactersMap.put(character, Boolean.TRUE);
				}
			}

			if (charactersMap.containsValue(true)) {
				for (int i = 0; i < strLength; i++) {
					char character = strInput.charAt(i);
					Boolean isNonRepeating = charactersMap.get(character);
					if (isNonRepeating) {
						firstNonRepeatingChar = character;
						break;
					}
				}
			}

		}

		return firstNonRepeatingChar;

	}

}
