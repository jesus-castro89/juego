package gui.buttons;

import enemies.Enemy;
import gui.events.AttackButtonListener;
import player.Player;

public class AttackButton extends ActionButton {

	// Constructor que recibe un enemigo como parámetro
	public AttackButton(Enemy enemy, Player player) {

		super("Atacar");
		// Asignar la acción de atacar al enemigo
		addActionListener(new AttackButtonListener(enemy, player));
	}
}
