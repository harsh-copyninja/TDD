package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int intAdd(String toBeAdded) {
		int sum = 0;
		String del = ",";
		if (toBeAdded.startsWith("//")) {
			String regex = "//.*\n";
			Pattern pattern = Pattern.compile(regex);
			Matcher m = pattern.matcher(toBeAdded);
			if(m.find()) {
				del = toBeAdded.substring(m.start()+2,m.end()-1);
				toBeAdded = toBeAdded.substring(m.end());
			}
		}
		toBeAdded = toBeAdded.replaceAll("\n", del);
		String nums[] = toBeAdded.split(del);
		for (String num : nums) {
			sum+=parseInt(num);
		}
		return sum;
	}
	
	private int parseInt(String num) {
		if(num == "") {
			return 0;
		}
		return Integer.parseInt(num);
	}

}
