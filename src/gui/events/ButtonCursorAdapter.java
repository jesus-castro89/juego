package gui.events;

import gui.buttons.ActionButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class ButtonCursorAdapter extends MouseAdapter {

	private final ActionButton button;

	public ButtonCursorAdapter(ActionButton button) {

		this.button = button;
	}

	// Cuando el mouse entra en el botón
	@Override
	public void mouseEntered(java.awt.event.MouseEvent evt) {

		button.setImage(((ImageIcon) button.getRolloverIcon()).getImage());
		button.setForeground(new Color(22, 26, 99));
		button.repaint();
	}

	// Cuando el mouse sale del botón
	@Override
	public void mouseExited(java.awt.event.MouseEvent evt) {

		button.setImage(((ImageIcon) button.getIcon()).getImage());
		button.setForeground(new Color(0, 0, 0));
		button.repaint();
	}
}
