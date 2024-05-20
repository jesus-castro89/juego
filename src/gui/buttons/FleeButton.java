package gui.buttons;

import enemies.Enemy;
import gui.events.FleeButtonListener;
import player.Player;

public class FleeButton extends ActionButton {

	public FleeButton(Player player, Enemy enemy) {

		super("Huir");
		addActionListener(new FleeButtonListener(player, enemy));
	}
}
