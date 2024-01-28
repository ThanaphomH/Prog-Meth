package logic.unit;
public class BaseCompetitor {
	private String name;
	private int hp;
	private int power;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = Math.max(hp, 0);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = Math.max(power, 1);
	}
	
	public BaseCompetitor(String name) {
		this.name = name;
		this.hp = 5;
		this.power = 3;
	}
	public BaseCompetitor(String name,int hp,int power) {
		this.name = name;
		this.hp = Math.max(hp, 0);
		this.power = Math.max(power,1);
	}
	
	public void attack(BaseCompetitor enemy) {
		enemy.setHp(Math.max(enemy.getHp() - this.getPower(), 0));
	}
	
	public String getType() {
		if (this instanceof Sorcerer) {
			return "Sorcerer";
		} else if (this instanceof Tiger) {
			return "Tiger";
		} else if (this instanceof ToughMan) {
			return "ToughMan";
		}
		return "BaseCompetitor";
	}
}