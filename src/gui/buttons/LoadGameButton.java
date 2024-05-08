package gui.buttons;

import gui.events.FileListener;

public class LoadGameButton extends ActionButton {


	public LoadGameButton(int slot) {

		super("Cargar Partida");
		addActionListener(new FileListener(this, slot));
	}
}
