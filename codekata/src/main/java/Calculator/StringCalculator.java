package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exception.NegativeNumberFoundException;

public class StringCalculator {

	private final String DELEMITER_REGEX = "//.*\n";
	private final String DELEMITER_REGEX_ANY_LENGTH = "//\\[.*\\]\n";
	private String[] delemiters;
	private int count = 0;
	private final String[]  defaultDels = {","};; 
	
	public int intAdd(String toBeAdded) throws NegativeNumberFoundException {
		count++;
		delemiters = defaultDels;
		if (isNewDelimeter(toBeAdded)) {
			delemiters = getNewDelimeter(toBeAdded);
			toBeAdded = removeDelimeterText(toBeAdded);
		}
		toBeAdded = toBeAdded.replaceAll("\n", delemiters[0]);
		return calculateSum(toBeAdded);
	}
	
	private int calculateSum(String toBeAdded) throws NegativeNumberFoundException {
		int sum = 0;
		int number;
		String delRegex = ""  ;
		for (int i=0; i<delemiters.length ;i++) {
			delRegex+="("+escapeSpecialCharacter(delemiters[i])+")";
			if( i < delemiters.length - 1) {
				delRegex+="|";
			}
		}
		System.out.println(toBeAdded +  " " + delRegex);
		String nums[] = toBeAdded.split("["+delRegex+"]");
		checkForNegative(nums);
		for (String num : nums) {
			number = parseInt(num);
			//ignoring number greater than 1000 by substituting it as 0
			sum+=(number>1000?0:number);
		}
		return sum;
	}

	private void checkForNegative(String[] nums) throws NegativeNumberFoundException {
		List<String> negativeNums = new ArrayList<String>();
		int number;
		for (String num : nums) {
			System.out.print(num+" ");
			number=parseInt(num);
			if (number < 0 ) {
				negativeNums.add(num);
			}
		}
		System.out.println();
		if (negativeNums.size() > 0) {
			throw new NegativeNumberFoundException(String.format("negatives not allowed: %s", String.join(" ", negativeNums)));
		}
	}

	private String removeDelimeterText(String toBeAdded) {
		return toBeAdded.replaceAll(DELEMITER_REGEX, "");
	}
	
	private String[] getNewDelimeter(String toBeAdded) {
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

