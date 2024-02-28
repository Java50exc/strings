package telran.performance;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import telran.text.JoinStrings;


public class JoinStringsPerformanceAppl {

	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 1000;
	private static final String PACKAGE = "telran.text.";
	private static final String START_METHOD = "run";

	public static void main(String[] args) throws Exception {
		runTests(getJoinStringTests(args, getStrings()));

	}

	private static void runTests(Object[] tests) throws Exception {
		for (var test : tests) {
			test.getClass().getMethod(START_METHOD).invoke(test);
		}
	}

	private static PerformanceTest[] getJoinStringTests(String[] testNames, String[] testStrings) throws Exception {
		PerformanceTest[] testsArr = new PerformanceTest[testNames.length];

		for (int i = 0; i < testsArr.length; i++) {
			JoinStrings test = (JoinStrings) Class.forName(PACKAGE + testNames[i]).getConstructor().newInstance();
			testsArr[i] = new JoinStringsPerformanceTest(getTestName(testNames[i]), N_RUNS, testStrings, test);
		}
		return testsArr;
	}
	

	private static String getTestName(String className) {

		return String.format("%s; Number of the strings is %d", className, N_STRINGS);
	}

	private static String[] getStrings() {
		String[] res = new String[N_STRINGS];
		Arrays.fill(res, "string");
		return res;
	}

}