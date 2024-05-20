package gui.buttons;

import gui.events.FileListener;

public class NewGameButton extends ActionButton {

	public NewGameButton(int slot) {

		super("Nueva Partida");
		addActionListener(new FileListener(this, slot));
	}
}
