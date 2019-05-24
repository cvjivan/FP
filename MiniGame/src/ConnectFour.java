import java.util.*;

public class ConnectFour{
	
    String array[][] = new String[6][7]; 
    public int scannerInput;
    public boolean playerOne;
    public boolean playerTwo;
    public int counter;
    public boolean win;
	
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
	
	public void run() {
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
		try {
			this.scannerInput = Integer.parseInt(input);
		}catch(NumberFormatException e) {
			System.out.println("Choose a column!");
		}
		
	
	}
	
	public void play() {
		boolean x = false;
		System.out.println("Welcome to Connect Four!");
		run();
		while (!win(x)) {
			if (scannerInput <= 7 && scannerInput >= 1) {
				if (check(scannerInput) >= 0) {
					array[check(scannerInput)][scannerInput-1] = place();
					run();
					which();
				}else {
					System.out.println("This array is full.");
					x = true;
					which();
					play();
				}
			}else {
				System.out.println("Number has to be between 1 and 7!");
				x = true;
				which();
				play();
			}
		}
		
	}
	
	public int check(int col) {
		int x = -1;
		for (int i = 5; i >= 0; i--) {
			if (array[i][col-1].equals(" ")) {
				x = i;
				i = -1;
			}
		}
		return x;
	}
	
	//change later
	public boolean win(boolean x) {
		return x;
	}
	
	public void which() {
		if (counter % 2 == 0) {
			this.playerOne = true;
			this.playerTwo = false;
		}else {
			this.playerOne = false;
			this.playerTwo = true;
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
