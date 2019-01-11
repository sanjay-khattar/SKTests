/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

package tests.sanjay;

import java.util.HashMap;
import java.util.Map;

/*
**  Instructions:
**
**  Given a list of student test scores, find the best average grade.
**  Each student may have more than one test score in the list.
**
**  Complete the bestAverageGrade function in the editor below.
**  It has one parameter, scores, which is an array of student test scores.
**  Each element in the array is a two-element array of the form [student name, test score]
**  e.g. [ "Bobby", "87" ].
**  Test scores may be positive or negative integers.
**
**  If you end up with an average grade that is not an integer, you should
**  use a floor function to return the largest integer less than or equal to the average.
**  Return 0 for an empty input.
**
**  Example:
**
**  Input:
**  [ [ "Bobby", "87" ],
**    [ "Charles", "100" ],
**    [ "Eric", "64" ],
**    [ "Charles", "22" ] ].
**
**  Expected output: 87
**  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
**  respectively. 87 is the highest.
*/

/**
 * 
 * @author sanjaykdev
 *
 */
public class GS2 {
	/*
	 ** Find the best average grade.
	 */
	public static Integer bestAverageGrade(String[][] scores) {
		int bestAverageGrade = 0;

		Map<String, Integer[]> averageGrades = new HashMap<String, Integer[]>();

		for (int i = 0; i < scores.length; i++) {
			String[] score = scores[i];
			String name = score[0];
			int grade = Integer.valueOf(score[1]);

			Integer[] averageGradeWithCount = averageGrades.get(name);
			if (averageGradeWithCount != null) {
				int averageGrade = averageGradeWithCount[0];
				int count = averageGradeWithCount[1];

				averageGrade = ((averageGrade * count) + grade) / (count + 1);
				count++;
				
				averageGradeWithCount[0] = averageGrade;
				averageGradeWithCount[1] = count;

			} else {
				averageGradeWithCount = new Integer[2];
				averageGradeWithCount[0] = grade;
				averageGradeWithCount[1] = 1;
			}

			averageGrades.put(name, averageGradeWithCount);
			
		}
		
		for (Integer[] averageGradeWithCount : averageGrades.values()) {
			int averageGrade = averageGradeWithCount[0];
			
			if (bestAverageGrade < averageGrade) {
				bestAverageGrade = averageGrade;
			}
		}
		
		return bestAverageGrade;
	}

	/*
	 ** Returns true if the tests pass. Otherwise, returns false;
	 */
	public static boolean doTestsPass() {
		// TODO: implement more test cases
		String[][] tc1 = { { "Bobby", "87" }, { "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } };

		return bestAverageGrade(tc1) == 87;
	}

	/*
	 ** Execution entry point.
	 */
	public static void main(String[] args) {
		// Run the tests
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
}
