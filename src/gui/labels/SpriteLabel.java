package gui.labels;

import org.jetbrains.annotations.NotNull;
import util.interfaces.Dimensions;

import javax.swing.*;
import java.awt.*;

public class SpriteLabel extends JLabel {

	protected Image image;

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
		paintImage(g2d);
	}

	protected void paintImage(@NotNull Graphics2D g2d) {


		int w = Math.min(image.getWidth(null), Dimensions.SPRITE_SIZE.width);
		int h = Math.min(image.getHeight(null), Dimensions.SPRITE_SIZE.height);
		int x = ((Dimensions.DIALOG_PANEL_SIZE.width / 2) - w) / 2;
		int y = (Dimensions.SPRITE_SIZE.height - h) / 2;
		g2d.drawImage(image, x, y, w, h, null);
	}
}
