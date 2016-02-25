import java.util.Random;

public class Board {
	int currentTurn = 0;
	int totalPlayer = 0;
	Player[] players;
	Square[] squares = new Square[40];
	String[] names = new String[] { "Ignore Space", //0
									"Baseline",   //1
									"Wellington", 
									"Laurier", 
									"Rideau", 
									"Colonal By", 
									"Metcalfe", 
									"Kent", 
									"Slater", 
									"Ignore Space", //9
									"Sussex", 
									"Bronson",   
									"Carling",  
									"Innes",
									"Lees Ave",
									"Hunt Club",
									"Woodroffe",
									"Kent",
									"Pinecrest",
									"Ignore Space", //19
									"Littly Italy",
									"Chinatown",
									"King Edward", 
									"Robertson",  
									"Maitland",
									"Merivale",
									"Meadowlands",
									"Fisher",
									"Deerfield",
									"Ignore Space", //29
									"Terry Fox",
								    "Heron",
									"Eagleson",
									"Clyde",    
									"Blair",  
									"Bay",
									"Albert",
									"Smyth",
									"Sparks",
									"Nicholas", //39
									};
	
	
	public Board(int totalPlayer) {
		players = new Player[totalPlayer];
		this.totalPlayer = totalPlayer;
		for(int i = 0;i < players.length;i++){
			players[i] = new Player(i, "Player " + (i + 1));
		}
		Random rand = new Random();
		for(int i = 0;i < squares.length;i++){
			if(i == 0){
				squares[i] = new GoSquare("GO");
			}else if(i == 9){
				squares[i] = new JailSquare("Jail");
			}else if(i == 19){
				squares[i] = new FreeParkingSquare("FreeParking");
			}else if(i == 29){
				squares[i] = new GoToJailSquare("Go to Jail");
			}else{
				squares[i] = new HouseSquare(names[i], 400 + rand.nextInt(300));
				// System.out.println(squares[i].getName());
			}
		}
	}
	
	public Square movePlayer(Player player, int face) {
		return movePlayer(player, face, true);
	}
	
	public Square movePlayer(Player player, int face, boolean count) {
		if(player.isBroke()){ return squares[player.getCurrentPosition()]; }
		int newPosition = normalizePosition(player.getCurrentPosition() + face);
		player.setPosition(newPosition);
		Message.print(player, player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
		squares[newPosition].doAction(player, this);
		if(player.getMoney().isBankrupt()){
			Message.print(player, player.getName() + " is bankrupt!");
			player.setBroke(true);
		}else{
			if(count){
				player.nextTurn();
			}
		}
		return squares[newPosition];
	}
	
	public boolean hasWinner() {
		int ingame = 0;
		for(Player player:players){
			if(!player.isBroke()){
				ingame++;
			}
		}
		return ingame <= 1;
	}
	
	public Player getWinner() {
		if(!hasWinner()){ return null; }
		for(Player player:players){
			if(!player.isBroke()){ return player; }
		}
		return null;
	}
	
	public Player getMaxMoneyPlayer() {
		Player maxplayer = null;
		for(Player player:players){
			if(maxplayer == null || maxplayer.getMoney().getMoney() < player.getMoney().getMoney()){
				maxplayer = player;
			}
		}
		return maxplayer;
	}
	
	public int normalizePosition(int position) {
		return position % squares.length; //Avoid exceeding the 40 squares on the board.
	}
	
	public Player getCurrentPlayer() {
		return players[currentTurn];
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void nextTurn() {
		if(++currentTurn >= players.length){
			currentTurn = 0;
		}
	}
	
	public Player getPlayer(int id) {
		return players[id];
	}
	
	public int getTotalSquare() {
		return squares.length;
	}
}
