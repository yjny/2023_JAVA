interface ArrayProcessing { //Week06_02
	double apply(double[] array);
}

public class LambdaTest {

	public static final ArrayProcessing maxer = array -> {
		double max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
		}
		return max;
	};

	public static final ArrayProcessing miner = array -> {
		double min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	};

	public static final ArrayProcessing sumer = array -> {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		return total;
	};
	public static final ArrayProcessing averager = array -> sumer.apply(array) / array.length;

	public static void main(String[] args) {

		double[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println("Sum: " + sumer.apply(list));
		System.out.println("Average: " + averager.apply(list));
		System.out.println("Minimum: " + miner.apply(list));
		System.out.println("Maximum: " + maxer.apply(list));
	}
}
