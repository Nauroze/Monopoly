public class Money {
	int money;
	
	public Money() {
		this(0);
	}
	
	public Money(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void addMoney(int amount) {
		money += amount;
	}
	
	public void substractMoney(int amount) {
		money -= amount;
	}
	
	public boolean isBankrupt() {
		return (money <= 0 );
	}
}
