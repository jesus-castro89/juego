package gui.buttons;

import player.Player;
import util.managers.FileManager;

public class SaveButton extends ActionButton {

	private Player player;

	public SaveButton(Player player) {

		super("Guardar");
		this.player = player;
		addActionListener(e -> {
			// Save the game
			FileManager.saveGame(player);
		});
	}
}
