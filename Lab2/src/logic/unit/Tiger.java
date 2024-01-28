package logic.unit;

public class Tiger extends BaseCompetitor {

	public Tiger(String name) {
		super(name , 7 , 5);
	}
	public Tiger(String name,int hp , int power) {
		super(name , Math.max(hp, 0) , Math.max(power, 1));
	}
	public void train(int addPower) {
		if (addPower < 0) return;
		this.setPower(Math.max(this.getPower() + addPower , 1));
	}
	public void attack(BaseCompetitor enemy) {
		if (enemy.getType().equals("ToughMan")) {
			enemy.setHp(Math.max(0, enemy.getHp() - this.getPower()/2));
		} else if (enemy.getType().equals("Tiger") || enemy.getType().equals("BaseCompetitor")) {
			enemy.setHp(Math.max(0, enemy.getHp() - this.getPower()));
		} else {
			enemy.setHp(Math.max(0, enemy.getHp() - this.getPower()*3/2));
		}
	}
}