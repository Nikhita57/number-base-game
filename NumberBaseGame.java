import java.util.Random;
import java.util.Scanner;


public class NumberBaseGame {
	
	public static void main(String[] args) {
		int score = 0;
		//Only bases from 2-36 will be used
		//Base 10 values range from 2-1296
		while (true) {
			Random r = new Random();
			int base1 = r.nextInt(34)+2;
			int base2 = r.nextInt(34)+2;
			int value = r.nextInt(1295)+2;
			Number guessed = new Number(value, base1);
			System.out.println("Convert " + guessed.getBaseRepresentation() + ", in base " + base1 + ", to base " + base2 +".");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String ans = scan.next();
			Number a = new Number(ans, base2);
			if (a.getBase10Value() == guessed.getBase10Value()) {
				score++;
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect!");
				System.out.println(new Number(guessed.getBase10Value(), base2).getBaseRepresentation());
			}
			System.out.println("Current score: " + score);
		}

	}

}
