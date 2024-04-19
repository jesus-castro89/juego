package player.skills;

import enemies.Enemy;
import game.exceptions.EnemyDeadException;
import gui_old.panels.DialogPanel;
import player.Player;

import java.io.Serializable;

public class BasicHeal extends Skill implements Serializable {

	private static final BasicHeal instance = new BasicHeal();
	public static final String NAME = "Curación Básica";

	public static BasicHeal getInstance() {

		if (instance == null) {

			return new BasicHeal();
		} else {
			return instance;
		}
	}

	private BasicHeal() {

		super(NAME, "Cura al jugador 8 puntos de vida", 3, 5);
	}

	@Override
	public String effect(Player player) {

		player.heal(8);
		player.useMp(manaCost);
		return String.format("¡%s ha sido curado por 8 puntos de vida!", player.getName());
	}

	@Override
	public String effect(Player player, Enemy enemy) {

		String message = effect(player);
		((DialogPanel) getCharactersPanel().getDialogPanel()).getText().append(message);
		try {
			enemy.attack();
		} catch (EnemyDeadException e) {
			throw new RuntimeException(e);
		}
		return message;
	}
}
