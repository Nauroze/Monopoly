public class Message {
	public static void print(Player player, String msg) {
		System.out.println("[Turn " + (player.getTotalDistance() + 1) + "] [" + player.getCurrentPosition() + "] [$" + player.getMoney().getMoney() + "] " + msg);
	}
}
