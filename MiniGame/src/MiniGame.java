import java.util.Scanner;

public class MiniGame {
	public static void main(String args[]) {
		for (int i = 0; i < 40; i++){
			System.out.println();
		}
		System.out.println("Welcome to Connect Four!");
		ConnectFour game = new ConnectFour();
		game.play();
	}
}
