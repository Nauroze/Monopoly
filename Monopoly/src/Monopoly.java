import java.util.Scanner;

public class Monopoly {
	Dice die = new Dice();
	Board board;
	
	public Monopoly(int totalPlayer) {
		board = new Board(totalPlayer);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalPlayer = 0;
		System.out.println("Welcome to Ottawa Monopoly!");
		System.out.println("=============================");
		while (totalPlayer < 2 || totalPlayer > 8){
			System.out.print("Enter the number of Players: ");
			try { 
				totalPlayer = scanner.nextInt();}
		    catch (Exception e) {
		    	System.out.println("Please Try Again.");
		    	scanner = new Scanner(System.in);
		    }
			
		} 
		scanner.close();
		Monopoly game = new Monopoly(totalPlayer);
		game.startGame();
	}
	
	public void startGame() {
		System.out.println("Game start!");
		System.out.println("========");
		while (!isGameEnd() && !board.hasWinner()){
			if(!board.getCurrentPlayer().isBroke()){
				int face = board.getCurrentPlayer().tossDie(die);
				board.movePlayer(board.getCurrentPlayer(), face);
			}
			board.nextTurn();
		}
		System.out.println("========");
		if(board.hasWinner()){
			System.out.println(board.getWinner().getName() + " wins!");
		}else{
			System.out.println(board.getMaxMoneyPlayer().getName() + " has won by having most money at the end of rounds!");
		}
		System.out.println("Game over!");
	}
	
	public boolean isGameEnd() {
		for(Player player:board.getPlayers()){
			if(player.getTotalDistance() < 40){ return false; }
		}
		return true;
	}
}
