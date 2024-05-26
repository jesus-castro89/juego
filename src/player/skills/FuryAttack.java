package player.skills;

import enemies.Enemy;
import gui.exceptions.EnemyDeadException;
import gui.exceptions.PlayerDeadException;
import gui.panels.DialogPanel;
import gui.windows.GameWindow;
import player.Player;
import util.enemies.EnemyFactory;

import java.io.Serializable;

public class FuryAttack extends Skill implements Serializable {

	private static FuryAttack instance;
	public final static String NAME = "Ataque Furia";

	public static FuryAttack getInstance(Player player) {

		if (instance == null) {

			instance = new FuryAttack(player);
		}
		return instance;
	}

	public FuryAttack(Player player) {

		super(NAME, "Ataque al enemigo con +5 puntos de daño", 5, 3,
				player, player.getEnemy());
	}

	private void attack() throws EnemyDeadException {

		int damage = player.getDamage() + 5;
		player.useMp(manaCost);
		DialogPanel.getInstance().addText(
				String.format("¡%s ataca a %s con %d puntos de daño!\n", player.getName(), enemy.getName(), damage));
		DialogPanel.getInstance().addText(enemy.takeDamage(damage - enemy.getAdjustedDefense()));
		if (enemy.isDead()) {
			player.getRewards(enemy);
		}
		updatePanels();
	}

	private void setNewEnemy() {

		// Si el enemigo está muerto o escapo por una habilidad
		// Creamos un nuevo enemigo
		enemy = EnemyFactory.generateRegularEnemy(player);
		// Asignamos el nuevo enemigo al panel de juego
		GameWindow.getInstance().setEnemy(enemy);
		// Actualizamos los paneles
		updatePanels();
	}

	@Override
	public void skillAction() {

		//Si el jugador es más rápido, entonces se cura y el enemigo ataca
		if (player.getSpeed() >= enemy.getAdjustedSpeed()) {

			try {
				// Primero el jugador ataca
				attack();
				// Luego el enemigo ataca si sigue con vida
				enemy.attack();
			} catch (EnemyDeadException e) {
				// Si el enemigo muere, entonces se crea un nuevo enemigo
				setNewEnemy();
				updatePanels();
			}
			// Actualizamos los paneles
			updatePanels();
		} else {
			//Si el enemigo es más rápido, entonces el enemigo ataca y el jugador se cura
			try {
				enemy.attack();
			} catch (EnemyDeadException e) {
				// Si el enemigo muere, entonces se crea un nuevo enemigo
				setNewEnemy();
			}
			try {
				if (!player.isDead()) attack();
				else throw new PlayerDeadException();
			} catch (PlayerDeadException e) {
				// Si el jugador muere, mostramos un mensaje de consolación
				DialogPanel.getInstance().addText("¡Quizás deberías entrenar más duro!\n");
				// Revivimos al jugador
				player.revive();
				// Mostramos un mensaje de que el jugador fue revivido
				DialogPanel.getInstance().addText("¡Has sido revivido!\n");
				// Creamos un nuevo enemigo
				setNewEnemy();
				updatePanels();
			} catch (EnemyDeadException e) {
				// Si el enemigo muere, entonces se crea un nuevo enemigo
				setNewEnemy();
				updatePanels();
			}
		}
	}
}
