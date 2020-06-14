package Calculator;

public class StringCalculator {

	public int intAdd(String toBeAdded) {
		if (toBeAdded == "")
			return 0;
		String nums[] = toBeAdded.split(",");
		if (nums.length == 1)
			return Integer.parseInt(nums[0]);
		return Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
	}

}
