package gui.labels;

import util.interfaces.Dimensions;

import javax.swing.*;
import java.awt.*;

public class SpriteLabel extends JLabel {

	private Image image;

	public SpriteLabel(Image image) {

		this.image = image;
		Dimension size = Dimensions.SPRITE_SIZE;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setOpaque(false);
		setVisible(true);
	}

	public void updateImage(Image image) {

		this.image = image;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w = Math.min(image.getWidth(null), 256);
		int h = Math.min(image.getHeight(null), 140);
		int x = (384 - w) / 2;
		int y = (140 - h) / 2;
		g2d.drawImage(image, x, y, w, h, null);
	}
}
