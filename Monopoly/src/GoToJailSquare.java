public class GoToJailSquare extends Square {
	public GoToJailSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		Message.print(player, player.getName() + " goes to Jail.");
		board.movePlayer(player, -board.getTotalSquare() / 2, false);
	}
}
