package player.skills.knights;

import enemies.Enemy;
import gui.GameWindow;
import player.Player;
import player.skills.Skill;
import util.annotations.JobRestriction;

@JobRestriction(jobs = {"Caballero novato", "Caballero"})
public class SwordBash extends Skill {

	public SwordBash() {

		super("Golpe de espada", "Golpe Básico de Espada", 1, 10);
	}

	@Override
	public void activate() {

		Player player = Player.getInstance();
		Enemy enemy = GameWindow.getInstance(player).getEnemy();
		enemy.takeDamage((int) (player.getStrength() * 1.5));
	}
}
