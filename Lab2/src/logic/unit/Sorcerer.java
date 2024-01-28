package logic.unit;

public class Sorcerer extends BaseCompetitor {

	public Sorcerer(String name) {
		super(name , 4 , 2);
	}
	public Sorcerer(String name,int hp,int power) {
		super(name , Math.max(hp , 0) , Math.max(power, 1));
	}
	public void lowerPower(BaseCompetitor enemy , int powerDown) {
		if (powerDown < 0) return;
		enemy.setPower(Math.max(enemy.getPower() - powerDown ,1));
	}
	public void attack(BaseCompetitor enemy) {
		if (enemy.getType().equals("Tiger")) {
			enemy.setHp(Math.max(enemy.getHp() - this.getPower()/2, 0));
		} else if (enemy.getType().equals("Sorcerer") || enemy.getType().equals("BaseCompetitor")) {
			enemy.setHp(Math.max(enemy.getHp() - this.getPower(), 0));
		} else {
			enemy.setHp(Math.max(enemy.getHp() - this.getPower()*3/2, 0));
		}
	}
}