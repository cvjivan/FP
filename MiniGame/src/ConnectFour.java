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
	
	public void setUp(Players one, Players two) {
		
	}
	
	public void run() {
		print();
		System.out.println("Pick a column to place your marker in:");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().replaceAll(" ", "");	
		System.out.println(input);	
		for (int i = 0; i < 40; i++){
			System.out.println();
		}
		try {
			this.scannerInput = Integer.parseInt(input);
		}catch(NumberFormatException e) {
			System.out.println("Choose a column!");
			run();
		}	
	}
	
	public void play() {
		run();
		while (!win(place(), scannerInput - 1)) {
			this.counter--;
			if (scannerInput <= 7 && scannerInput >= 1) {
				if (check(scannerInput) >= 0) {
					array[check(scannerInput)][scannerInput-1] = place();
					this.counter--;
					if (win(place(), scannerInput - 1)){
						print();
						break;
					}
					run();
					which();
				}else {
					System.out.println("This array is full.");
					which();
					play();
				}
			}else {
				System.out.println("Number has to be between 1 and 7!");
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
	
	public void print() {
		System.out.println("    1   2   3   4   5   6   7");
		for (int i = 0; i < 6; i++) {
			System.out.print(i+1 + " | ");
			for (int j = 0; j < 7; j++) {
				System.out.print(array[i][j] + " | ");
			}
			System.out.println();
		}
	}
	//change
	public boolean win(String player, int col) {
		
		try {
			int count = 0;
			for (int j = 5; j >= 0 ; j--) {
				if (array[j][col].equals(player)) {
					count++;
				} else {
					count = 0;
				}
				if (count == 4) {
					System.out.println("Congrats Player " + player + "on winning");
					return true;

				}
			}
			for (int j = 5; j >= 0; j--) { 
				for (int i = 0; i < 4 ; i++) {
					count = 0;
					for (int x = 0; x < 4; x++){
						if (array[j][i+x].equals(player)) {
							count++;
						} else {
							count = 0;
						}
						if (count == 4) {
							System.out.println("Congrats Player " + player + " on winning");
							return true;
						}
					}
				}
			}
			for (int j = 5; j >= 3; j--) { 
				for (int i = 0; i < 4 ; i++) {
					count = 0;
					for (int x = 0; x < 4; x++){
						if (array[j-x][i+x].equals(player)) {
							count++;
						} else {
							count = 0;
						}
						if (count == 4) {
							System.out.println("Congrats Player " + player + " on winning");
							return true;
						}
					}
				}
			}
			for (int j = 5; j >= 3; j--) { 
				for (int i = 3; i < 7 ; i++) {
					count = 0;
					for (int x = 0; x < 4; x++){
						if (array[j-x][i-x].equals(player)) {	
							count++;
						} else {
							count = 0;
						}
						if (count == 4) {
							System.out.println("Congrats Player " + player + " on winning");
							return true;
						}
					}
				}
			}
			return false;
		}catch(ArrayIndexOutOfBoundsException a) {
			return false;
		}
		
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
