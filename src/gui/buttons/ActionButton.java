package gui.buttons;

import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public abstract class ActionButton extends JButton {

	private String displayText;
	private Font font;
	private Icon image;
	private int topPadding;

	public ActionButton(String text) {

		this.displayText = text;
		ImageManager.getInstance().getImage("button",
				new ImageIcon("img/ui/buttons/idleButton.png").getImage());
		ImageManager.getInstance().getImage("buttonHover",
				new ImageIcon("img/ui/buttons/hoverButton.png").getImage());
		setIcon(new ImageIcon(ImageManager.getInstance().getImage("button")));
		setRolloverIcon(new ImageIcon(ImageManager.getInstance().getImage("buttonHover")));
		image = getIcon();
		topPadding=2;
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
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {

				image = getRolloverIcon();
				topPadding = 0;
				repaint();
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {

				image = getIcon();
				topPadding = 2;
				repaint();
			}
		});
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
		//Pintamos la imagen
		image.paintIcon(this, g2d, 0, 0);
		//Calculamos la posición del texto
		int textPositionY = image.getIconHeight() / 2 + (g2d.getFontMetrics().getHeight() / 4) + topPadding;
		int textPositionX = (image.getIconWidth() - g2d.getFontMetrics().stringWidth(displayText)) / 2;
		//Pintamos el texto
		g2d.drawString(displayText, textPositionX, textPositionY);
	}
}
