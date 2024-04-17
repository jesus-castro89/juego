package gui.buttons;

import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public abstract class ActionButton extends JButton {

	private String displayText;
	private Image image;
	private Font font;

	public ActionButton(String text) {

		this.displayText = text;
		image = ImageManager.getInstance().getImage("button",
				new ImageIcon("img/ui/holders/textHolder.png").getImage());
		font = FontManager.getInstance().getFont("Standard");
		Dimension size = new Dimension(117, 29);
		setSize(size);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(true);
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//Activamos la interpolación
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		g2d.drawImage(image, 0, 0, null);
		//Calculamos la posición del texto
		int textPositionY = image.getHeight(null) / 2 + (g2d.getFontMetrics().getHeight() / 4) + 2;
		int textPositionX = (image.getWidth(null) - g2d.getFontMetrics().stringWidth(displayText)) / 2;
		//Pintamos el texto
		g2d.drawString(displayText, textPositionX, textPositionY);
	}
}
