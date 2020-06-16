package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exception.NegativeNumberFoundException;

public class StringCalculator {

	private String DELEMITER_REGEX;
	private String[] delemiters;
	private int count;
	private String[]  defaultDels; 
	
	public  StringCalculator() {
		DELEMITER_REGEX = "//.*\n";
		count = 0;
		defaultDels = new String[1];
		defaultDels[0] = ",";
	}
	
	public int intAdd(String toBeAdded) throws NegativeNumberFoundException {
		count++;
		delemiters = defaultDels;
		if (isNewDelimeter(toBeAdded)) {
			delemiters = getNewDelimeters(toBeAdded);
			toBeAdded = removeDelimeterText(toBeAdded);
		}
		toBeAdded = toBeAdded.replaceAll("\n", delemiters[0]);
		return calculateSum(toBeAdded);
	}
	
	private int calculateSum(String toBeAdded) throws NegativeNumberFoundException {
		int sum = 0;
		int number;
		String nums[] = toBeAdded.split(getDelimeterRegex());
		checkForNegative(nums);
		for (String num : nums) {
			number = parseInt(num);
			//ignoring number greater than 1000 by substituting it as 0
			sum+=(number>1000?0:number);
		}
		return sum;
	}
	
	private String getDelimeterRegex() {
		String delRegex = "["  ;
		for (int i=0; i<delemiters.length ;i++) {
			delRegex+="("+escapeSpecialCharacter(delemiters[i])+")";
			if( i < delemiters.length - 1) {
				delRegex+="|";
			}
		}
		delRegex+="]";
		return delRegex;
	}

	private void checkForNegative(String[] nums) throws NegativeNumberFoundException {
		List<String> negativeNums = new ArrayList<String>();
		int number;
		for (String num : nums) {
			number=parseInt(num);
			if (number < 0 ) {
				negativeNums.add(num);
			}
		}
		if (negativeNums.size() > 0) {
			throw new NegativeNumberFoundException(String.format("negatives not allowed: %s", String.join(" ", negativeNums)));
		}
	}

	private String removeDelimeterText(String toBeAdded) {
		return toBeAdded.replaceAll(DELEMITER_REGEX, "");
	}
	
	private String[] getNewDelimeters(String toBeAdded) {
		String del = "";
		String[]  dels = null;
		Pattern anyLengthPattern = Pattern.compile(DELEMITER_REGEX);
		Matcher m = anyLengthPattern.matcher(toBeAdded);
		if(m.find()) {
			del = toBeAdded.substring(m.start()+2,m.end()-1);
		}
		if (del.startsWith("[") && del.endsWith("]")) {
			del = del.substring(1,del.length() -1);
		}
		dels = del.split("\\]\\[");
		if (dels == null) {
			return defaultDels;
		}
		return dels;
	}
	
	private String escapeSpecialCharacter(String del) {
		// \W designates non-word characters
		return del.replaceAll("[\\W]", "\\\\$0");
	}
	
	private Boolean isNewDelimeter(String toBeAdded) {
		return toBeAdded.startsWith("//");
	}
	
	private int parseInt(String num) {
		if(num.length() == 0) {
			return 0;
		}
		return Integer.parseInt(num);
	}

	public int GetCalledCount() {
		return count;
	}

}

