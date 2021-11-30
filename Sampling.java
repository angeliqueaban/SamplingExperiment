import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sampling {
	static List<Integer> population = new ArrayList<Integer>(10_000_000);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		population = new ArrayList<Integer>(10_000_000);
		int numA = (int) (10_000_000 * .52);
		for (int i = 0; i < 10_000_000; i++) {
			if (i < numA)
				population.add(1); // 0=A
			else
				population.add(0); // 1=B
		}

		double sample = 0;
		int timesToLoop = 20;
		for (int i = 0; i < timesToLoop; i++) {
			double result = 0;
			double n = 400;
			while (result < 0.9) {
				result = getSamples(n);
				n += 1;
			}
			sample += n;
			System.out.println(n);

		}
		System.out.println(sample/timesToLoop);

	}

	public static double getSamples(double sampleSize) {
		Random rand = new Random();
		double majority = 0;
		for (int timesToLoop = 0; timesToLoop < 100; timesToLoop++) {
			double count = 0;
			for (int i = 0; i < sampleSize; i++) {
				int index = rand.nextInt(population.size());
				if (population.get(index) == 1)
					count++;
			}
			// System.out.println(count/sampleSize);
			if (count > sampleSize / 2)
				majority++;

		}

		//System.out.println("For sample size " + sampleSize + " A was a majority " + majority / 100 + " times.");
		return majority / 100;
	}
}
