package gui.buttons;

import enemies.Enemy;
import gui.events.FleeButtonListener;

public class FleeButton extends ActionButton {

	private Enemy enemy;

	public FleeButton(Enemy enemy) {

		super("Huir");
		this.enemy = enemy;
		addActionListener(new FleeButtonListener(enemy));
	}
}
