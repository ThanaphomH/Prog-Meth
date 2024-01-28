package logic.unit;
public class ToughMan extends BaseCompetitor {
	private int maxHp;
	public ToughMan(String name) {
		super(name, 8 , 4);
		this.maxHp = 8;
	}
	public ToughMan(String name , int hp , int power) {
		super(name , Math.max(hp, 0) , Math.max(power, 1));
		this.maxHp = Math.max(hp,0);
	}
	public void heal(int healHP) {
		if (healHP < 0) return;
		this.setHp(Math.min(this.getMaxHp(), this.getHp() + healHP));
	}
	public void attack(BaseCompetitor enemy) {
		if (enemy.getType().equals("Sorcerer")) {
			enemy.setHp(Math.max(enemy.getHp() - this.getPower()/2 , 0));
		} else if (enemy.getType().equals("ToughMan") || enemy.getType().equals("BaseCompetitor")) {
			enemy.setHp(Math.max(enemy.getHp() - this.getPower() , 0));
		} else {
			enemy.setHp(Math.max(enemy.getHp() - this.getPower()*3/2 , 0));
		}
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = Math.max(maxHp, 0);
		if (this.getHp() > this.maxHp) {
			this.setHp(maxHp);
		}
	}
	
}