import java.util.*;
public class ConnectFour{
	
    String array[][] = new String[6][7]; 
    public int scannerInput;
    public boolean playerOne;
    public boolean playerTwo;
    public int counter;
	
	public ConnectFour() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				array[i][j] = " ";
			}
		}
		this.playerOne = true;
		this.playerTwo = false;
		this.counter = 0;
	}
	
	public void play() {
		System.out.println("Welcome to Connect Four!");
		System.out.println("    1   2   3   4   5   6   7");
		for (int i = 0; i < 6; i++) {
			System.out.print(i+1 + " | ");
			for (int j = 0; j < 7; j++) {
				System.out.print(array[i][j] + " | ");
			}
			System.out.println();
		}
		
		System.out.println("Pick a column to place your marker in:");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();	
		this.scannerInput = Integer.parseInt(input);
		
	}
	public void which() {
		if (counter % 1 == 0) {
			this.playerOne = false;
			this.playerTwo = true;
		}else {
			this.playerOne = true;
			this.playerTwo = false;
		}
	}
	
	public String place() {
		if (playerOne) {
			this.counter++;
			return "X";	
		}else {
			this.counter++;
			return "O";
		}
	}
	
}
