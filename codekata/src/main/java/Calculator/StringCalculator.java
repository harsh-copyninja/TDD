package Calculator;

public class StringCalculator {

	public int intAdd(String toBeAdded) {
		int sum = 0;
		String nums[] = toBeAdded.split(",");
		for (String num : nums) {
			String newLineSplitNums[] = num.split("\n");
			for (String number : newLineSplitNums) {
				sum+=parseInt(number);
			}
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
