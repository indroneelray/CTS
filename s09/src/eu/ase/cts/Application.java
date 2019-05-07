package eu.ase.cts;

import eu.ase.cts.exception.UnsupportedCharacterException;
import eu.ase.cts.model.heroes.Warrior;
import eu.ase.cts.utils.BossFight;
import eu.ase.cts.utils.CharacterFactory;
import eu.ase.cts.utils.CharacterType;
import eu.ase.cts.utils.MonsterType;

public class Application {

	
	public static void main(String[] args) {
		try {
			Warrior warr = (Warrior) CharacterFactory.getCharacter(CharacterType.TANK);
			warr.setCharacterName("Fighter");
			warr.setSkills(new String[] {"DASH", "SWORD_ATTACK", "BLOCK"});
			BossFight bossFight = new BossFight();
			
			for(int i = 0; i < 10; i++) {
				try {
					bossFight.spawnMonster(MonsterType.HUMAN).summonMonster();
					bossFight.spawnMonster(MonsterType.BEAST).summonMonster();
					bossFight.spawnMonster(MonsterType.INSECT).summonMonster();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				warr.useSkill();
				System.out.println("------Monsters were defeated------- ");
				System.out.println();
			}
			
		} catch (UnsupportedCharacterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
