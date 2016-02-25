public class GoSquare extends Square {
	public GoSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		Message.print(player, player.getName() + " is at Go, earning $1000.");
		player.getMoney().addMoney(1000);
	}
}
