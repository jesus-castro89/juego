package player.skills;

import gui.exceptions.EnemyDeadException;
import gui.panels.DialogPanel;
import gui.windows.GameWindow;
import org.jetbrains.annotations.NotNull;
import player.Player;

import java.io.Serializable;

public class BasicHeal extends Skill implements Serializable {

	private static BasicHeal instance;
	public static final String NAME = "Curación Básica";

	public static BasicHeal getInstance(Player player) {

		if (instance == null) {

			return new BasicHeal(player);
		} else {
			return instance;
		}
	}

	private BasicHeal(Player player) {

		super(NAME, "Cura al jugador 8 puntos de vida", 3, 5,
				player, player.getEnemy());
	}

	@Override
	public void skillAction() {

		//Primero debo determinar quien es más rápido
		//Si el jugador es más rápido, entonces se cura y el enemigo ataca
		if (player.getSpeed() >= enemy.getAdjustedSpeed()) {

			heal(player);
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
			heal(player);
			updatePanels();
		}
	}

	private void heal(@NotNull Player player) {

		player.heal(8);
		player.useMp(manaCost);
		String message = String.format("¡%s usa curación básica y recupera 8 puntos de vida!", player.getName());
		DialogPanel.getInstance().addText(message);
	}
}
