package gui.labels;

import util.interfaces.Dimensions;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una etiqueta con la imagen de un retrato
 */
public class PortraitLabel extends JLabel {

	/**
	 * Constructor de la clase
	 */
	public PortraitLabel() {

		Dimension size = Dimensions.PORTRAIT_SIZE;
		setSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setVerticalAlignment(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.CENTER);
		setHorizontalAlignment(SwingConstants.CENTER);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setOpaque(false);
		setIcon(new ImageIcon(ImageManager.getInstance().getImage("portrait")));
	}
}
