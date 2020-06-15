package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exception.NegativeNumberFoundException;

public class StringCalculator {

	private final String DELEMITER_REGEX = "//.*\n";
	
	public int intAdd(String toBeAdded) throws NegativeNumberFoundException {
		int sum = 0;
		String del = ",";
		if (isNewDelimeter(toBeAdded)) {
			del = getNewDelimeter(toBeAdded);
			toBeAdded = removeDelimeterText(toBeAdded);
		}
		toBeAdded = toBeAdded.replaceAll("\n", del);
		String nums[] = toBeAdded.split(del);
		for (String num : nums) {
			sum+=parseInt(num);
		}
		return sum;
	}
	
	private String removeDelimeterText(String toBeAdded) {
		return toBeAdded.replaceAll(DELEMITER_REGEX, "");
	}
	
	private String getNewDelimeter(String toBeAdded) {
		String del = ",";
		Pattern pattern = Pattern.compile(DELEMITER_REGEX);
		Matcher m = pattern.matcher(toBeAdded);
		if(m.find()) {
			del = toBeAdded.substring(m.start()+2,m.end()-1);
		}
		return del;
	}
	
	private Boolean isNewDelimeter(String toBeAdded) {
		return toBeAdded.startsWith("//");
	}
	
	private int parseInt(String num) throws NegativeNumberFoundException {
		if(num == "") {
			return 0;
		}
		int ans = Integer.parseInt(num);
		if(ans < 0) {
			throw new NegativeNumberFoundException();
		}
		return ans;
	}

}
