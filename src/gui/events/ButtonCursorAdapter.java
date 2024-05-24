package gui.events;

import gui.buttons.ActionButton;
import util.managers.ImageManager;

import java.awt.event.MouseAdapter;

public class ButtonCursorAdapter extends MouseAdapter {

	private final ActionButton button;

	public ButtonCursorAdapter(ActionButton button) {

		this.button = button;
	}

	// Cuando el mouse entra en el botón
	public void mouseEntered(java.awt.event.MouseEvent evt) {

		button.setImage(ImageManager.getInstance().getImage("buttonHover"));
		button.repaint();
	}

	// Cuando el mouse sale del botón
	public void mouseExited(java.awt.event.MouseEvent evt) {

		button.setImage(ImageManager.getInstance().getImage("button"));
		button.repaint();
	}
}
