import java.util.*;

public class ConnectFour{
	
    String array[][] = new String[10][10]; 
    private int scannerInput;
    private boolean playerOne;
    private boolean playerTwo;
    private int counter;
    private boolean win;
    private boolean z;
    private String who;
    private int cols;
    private int rows;
	//constructor 
	public ConnectFour(int rows, int cols) {
	    this.array= new String[rows][cols]; 
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				array[i][j] = " ";
			}
		}
		this.playerOne = true;
		this.playerTwo = false;
		this.counter = 0;
		this.cols = cols;
		this.rows = rows;
	}
	
	//checks value the user inputs
	public void run() {
		print();
		System.out.println("Pick a column to place your marker in:");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().replaceAll(" ", "");	
		System.out.println(input);	
		for (int i = 0; i < 400; i++){
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
			if (scannerInput <= cols && scannerInput >= 1) {
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
				System.out.println("Number has to be between 1 and " + cols + "!");
				which();
				play();
			}
		}
	}
	//prints who wins 
	public void after() {
		if (z) {
			System.out.println("Congrats Player " + who + " on winning");
		}
	} 
	
	//Returns the first empty index of the row from the col given
	public int check(int col) {
		int x = -1;
		for (int i = rows - 1; i >= 0; i--) {
			if (array[i][col-1].equals(" ")) {
				x = i;
				i = -1;
			}
		}
		return x;
	}
	//Prints out the Array
	public void print() {
		System.out.print(" ");
		for (int j = 1; j <= cols; j++) {
			if (j == 100) {
				System.out.print(" ");
			}
			if (j >= 100) {
				System.out.print(" " + j);
			} else if (j >= 10) {
				System.out.print("  " + j );
			} else {
				System.out.print("   " + j);
			}
		}
		System.out.println("");
		for (int i = 0; i < rows; i++) {
			if (i >= 9) {
				System.out.print(i+1 + "| ");
			} else {
				System.out.print(i+1 + " | ");
			}
			for (int j = 0; j < cols; j++) {
				System.out.print(array[i][j] + " | ");
			}
			System.out.println();
		}
	}
	//All of the checks determining if the player wins
	public boolean win(String player, int col) {
		z = false;
		who = player;
		try {
			int count = 0;
			for (int j = rows - 1 ; j >= 0 ; j--) {
				if (array[j][col].equals(player)) {
					count++;
				} else {
					count = 0;
				}
				if (count == 4) {
					z = true;

				}
			}
			for (int j = rows - 1; j >= 0; j--) { 
				for (int i = 0; i < cols - 3; i++) {
					count = 0;
					for (int x = 0; x < 4; x++){
						if (array[j][i+x].equals(player)) {
							count++;
						} else {
							count = 0;
						}
						if (count == 4) {
							z = true;
						}
					}
				}
			}
			for (int j = rows - 1; j >= 3; j--) { 
				for (int i = 0; i < cols - 3 ; i++) {
					count = 0;
					for (int x = 0; x < 4; x++){
						if (array[j-x][i+x].equals(player)) {
							count++;
						} else {
							count = 0;
						}
						if (count == 4) {
							z = true;
						}
					}
				}
			}
			for (int j = rows - 1; j >= 3; j--) { 
				for (int i = 3; i < cols ; i++) {
					count = 0;
					for (int x = 0; x < 4; x++){
						if (array[j-x][i-x].equals(player)) {	
							count++;
						} else {
							count = 0;
						}
						if (count == 4) {
							z = true;
						}
					}
				}
			}
			return z;
		}catch(ArrayIndexOutOfBoundsException a) {
			return false;
		}
		
	}
	//Changes who's turn it is
	public void which() {
		if (counter % 2 == 0) {
			this.playerOne = true;
			this.playerTwo = false;
		}else {
			this.playerOne = false;
			this.playerTwo = true;
		}
	}
	//Figures out who's turn it is
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
