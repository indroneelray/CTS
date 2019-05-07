package eu.ase.cts.utils;

import java.util.HashMap;
import java.util.Map;

import eu.ase.cts.model.monsters.Monster;
import eu.ase.cts.model.monsters.MonsterBeast;
import eu.ase.cts.model.monsters.MonsterHuman;
import eu.ase.cts.model.monsters.MonsterInsect;

public class BossFight {
	
	private Map<MonsterType, Monster> monsters = new HashMap<MonsterType, Monster>();
	
	public BossFight() {
		this.monsters.put(MonsterType.HUMAN, new MonsterHuman());
		this.monsters.put(MonsterType.BEAST, new MonsterBeast());
		this.monsters.put(MonsterType.INSECT, new MonsterInsect());
	}
	
	public Monster spawnMonster(MonsterType type) throws CloneNotSupportedException {
		return this.monsters.get(type).clone();
	}
}
