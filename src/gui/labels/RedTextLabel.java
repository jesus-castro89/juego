package gui.labels;

import gui.ui.TextLabelUI;

import javax.swing.*;

/**
 * Clase que representa una etiqueta de texto con fondo rojo
 */
public class RedTextLabel extends JLabel {

	/**
	 * Constructor de la clase
	 *
	 * @param text texto a mostrar
	 */
	public RedTextLabel(String text) {

		super(text, null, SwingConstants.CENTER);
		setUI(new TextLabelUI());
	}
}
