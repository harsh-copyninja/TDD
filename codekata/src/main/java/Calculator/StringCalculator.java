package Calculator;

import java.util.ArrayList;
import java.util.List;
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
		List<String> negativeNums = new ArrayList<String>();
		int number;
		for (String num : nums) {
			number=parseInt(num);
			if (number < 0 ) {
				negativeNums.add(num);
			}
			else {
				sum+=number;
			}
		}
		if (negativeNums.size() > 0) {
			throw new NegativeNumberFoundException(String.format("negatives not allowed: %s", String.join(" ", negativeNums)));
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
	
	private int parseInt(String num) {
		if(num == "") {
			return 0;
		}
		return Integer.parseInt(num);
	}

}
