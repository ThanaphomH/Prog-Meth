package logic.game;

import java.util.ArrayList;

import logic.unit.BaseCompetitor;
import logic.unit.Sorcerer;
import logic.unit.Tiger;
import logic.unit.ToughMan;

public class GameSystem {
	private ArrayList<BaseCompetitor>allCompetitors;
	private boolean gameEnd;
	private static GameSystem instance = null;
	
	public static GameSystem getInstance() {
		if(instance == null) {
			instance = new GameSystem();
		}
		return instance;
	}
	private GameSystem() {
		allCompetitors = new ArrayList<BaseCompetitor>();
		allCompetitors.add(new BaseCompetitor("c1"));
		allCompetitors.add(new BaseCompetitor("c2",5,2));
		allCompetitors.add(new Tiger("t1",6,4));
		allCompetitors.add(new Sorcerer("s1",5,3));
		allCompetitors.add(new ToughMan("c1",10,1));
		setGameEnd(false);
	}
	public ArrayList<BaseCompetitor> getAllCompetitors() {
		return allCompetitors;
	}
	public void setAllCompetitors(ArrayList<BaseCompetitor> allCompetitors) {
		this.allCompetitors = allCompetitors;
	}
	public boolean isGameEnd() {
		if(allCompetitors.size()<=1) {
			gameEnd=true;
		}
		return gameEnd;
	}
	public void setGameEnd(boolean gameEnd) {
		this.gameEnd = gameEnd;
	}
	public void addNewCompetitor(String name,int choice) {
		/*FILL CODE*/
		BaseCompetitor newCompetitor = new BaseCompetitor(name);
		switch (choice) {
			case 0 :
				newCompetitor = new BaseCompetitor(name);
				break;
			case 1 :
				newCompetitor = new Sorcerer(name);
				break;
			case 2 :
				newCompetitor = new Tiger(name);
				break;
			case 3 :
				newCompetitor = new ToughMan(name);
		}
		this.allCompetitors.add(newCompetitor);
	}
	public void printCompetitorsStatus() {
		for(int i=0;i<allCompetitors.size();i++) {
			BaseCompetitor temp=allCompetitors.get(i);
			System.out.println(temp.getType()+" "+temp.getName()+" hp: "+temp.getHp()+" power: "+temp.getPower());
		}
	}
	public void removeDeadCompetitors() {
		for(int j=allCompetitors.size()-1;j>=0;j--) {
			if(allCompetitors.get(j).getHp()<=0) {
				allCompetitors.remove(j);
			}
		}
	}
}
