package gui.buttons;

import gui.events.SaveButtonListener;
import player.Player;

public class SaveButton extends ActionButton {

	public SaveButton(int slot, Player player) {

		super("Guardar");
		// Asignar la acción de guardar el avance del jugador en el archivo correspondiente
		addActionListener(new SaveButtonListener(player, slot));
	}
}