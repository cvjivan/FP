import java.util.*;

public class MiniGame {
	public static void main(String args[]) {
		for (int i = 0; i < 40; i++){
			System.out.println();
		}
		System.out.println("Welcome to Connect Four!");
		System.out.println("How Many Rows Do You Want?");
		int rows = scan();
		System.out.println("How Many Cols Do You Want?");
		int cols = scan();
		ConnectFour game = new ConnectFour(rows,cols);
		game.play();
		game.after();
	}


	public static int scan() {
		int Answer = 0;
		Scanner scanInput = new Scanner(System.in);
		String input = scanInput.nextLine();
		try {
			Answer = Integer.parseInt(input);
		}catch(NumberFormatException e) {
			System.out.println("Thats not a number please enter one");
			scan();
		}
		if (Answer < 4) {
			System.out.println("Please Enter a value greater then 3");
			return scan();
		}
		return Answer;
	}
}