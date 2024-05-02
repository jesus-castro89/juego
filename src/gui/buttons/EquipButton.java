package gui.buttons;

import gui.GameWindow;
import gui.events.EquipButtonListener;
import gui.panels.*;
import items.Item;
import player.Player;

public class EquipButton extends ActionButton {

	public EquipButton(Item item) {

		super("Equipar");
		addActionListener(new EquipButtonListener(item));
	}
}
