package gui.buttons;

import gui.events.FileListener;
import gui.panels.StartPanel;

public class NewGameButton extends ActionButton {

	StartPanel startPanel;

	public NewGameButton(int slot) {

		super("Nueva Partida");
		addActionListener(new FileListener(this, slot));
	}
}
