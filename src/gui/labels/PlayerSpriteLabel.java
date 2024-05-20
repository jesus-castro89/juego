package gui.labels;

import util.interfaces.Dimensions;

import java.awt.*;

public class PlayerSpriteLabel extends SpriteLabel {

	public PlayerSpriteLabel(Image image) {

		super(image);
		Dimension size = Dimensions.PLAYER_SPRITE_SIZE;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
	}

	@Override
	protected void paintImage(Graphics2D g2d) {

		int w = Math.min(image.getWidth(null), Dimensions.PLAYER_SPRITE_SIZE.width);
		int h = Math.min(image.getHeight(null), Dimensions.PLAYER_SPRITE_SIZE.height);
		int x = ((Dimensions.DIALOG_PANEL_SIZE.width / 2) - w) / 2;
		int y = (Dimensions.SPRITE_SIZE.height - h) / 2;
		g2d.drawImage(image, x, y, w, h, null);
	}
}
