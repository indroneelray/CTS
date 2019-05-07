package eu.ase.cts.model.monsters;

import eu.ase.cts.utils.MonsterType;

public class MonsterInsect extends Monster {
	
		public MonsterInsect() {
			this.setMonsterType(MonsterType.INSECT);
		}

		@Override
		public void summonMonster() {
			System.out.println("Big ass Insect was summoned!");
		}
	
}
