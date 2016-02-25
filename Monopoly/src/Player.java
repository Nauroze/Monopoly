public class Player {
	int totalDistance = 0;
	int position = 0;
	int id;
	String name;
	boolean broke = false;
	Money money = new Money(5000);
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getTotalDistance() {
		return totalDistance;
	}
	
	public int tossDie(Dice die) {
		int face = die.getFace();
		Message.print(this, getName() + " tosses the dice... Face is " + face);
		return face;
	}
	
	public int getCurrentPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void nextTurn() {
		totalDistance++;
	}
	
	public String getName() {
		return name;
	}
	
	public Money getMoney() {
		return money;
	}
	
	public int getID() {
		return id;
	}
	
	public void setBroke(boolean brokeout) {
		this.broke = brokeout;
	}
	
	public boolean isBroke() {
		return broke;
	}
}
