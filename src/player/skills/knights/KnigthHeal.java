package player.skills.knights;

import enemies.Enemy;
import player.Player;
import player.skills.Skill;
import util.annotations.JobRestriction;


@JobRestriction(jobs = {"Caballero novato", "Caballero"})
public class KnigthHeal extends Skill {

	public KnigthHeal() {

		super("Curación de Caballero", "Recupera el 5% de vida del Personaje", 1, 10);
	}

	@Override
	public void activate() {

		Player player = Player.getInstance();
		player.heal((int) (player.getMaxHp() * .05));
	}
}
