package player.skills;

import gui.exceptions.EnemyDeadException;
import org.jetbrains.annotations.NotNull;
import player.Player;

import java.io.Serializable;

public class Slash extends Skill implements Serializable {

	private static Slash instance;
	public static final String NAME = "Corte";

	public static Slash getInstance(Player player) {

		if (instance == null) {

			instance = new Slash(player);
		}
		return instance;
	}

	private Slash(Player player) {

		super(NAME, "Ataque físico que inflige +10 puntos de daño", 3, 5,
				player, player.getEnemy());
	}

	@Override
	public void skillAction() {

		//Primero debo determinar quien es más rápido
		//Si el jugador es más rápido, entonces se cura y el enemigo ataca
		if (player.getSpeed() >= enemy.getAdjustedSpeed()) {

			attack(player);
			try {
				enemy.attack();
			} catch (EnemyDeadException e) {
				throw new RuntimeException(e);
			}
			updatePanels();
		} else {
			//Si el enemigo es más rápido, entonces el enemigo ataca y el jugador se cura
			try {
				enemy.attack();
			} catch (EnemyDeadException e) {
				throw new RuntimeException(e);
			}
			attack(player);
			updatePanels();
		}
	}

	private void attack(@NotNull Player player) {

		enemy.takeDamage(player.getStrength() + 10);
		player.useMp(manaCost);
	}
}