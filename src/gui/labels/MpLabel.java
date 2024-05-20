package gui.labels;

import characters.BasicCharacter;

import javax.swing.*;
import java.awt.*;

public class MpLabel extends HpLabel {

	public MpLabel(BasicCharacter character) {

		super(character);
	}

	@Override
	protected void init() {

		displayText = String.format("%d/%d", character.getMp(), character.getMaxMp());
		double hpPercentage = (double) character.getMp() / character.getMaxMp();
		Color color;
		if (hpPercentage >= .8) {
			image = new ImageIcon("img/player/mp100.png").getImage();
			color = new Color(0, 0, 0, 255);
		} else if (hpPercentage > 0.6) {
			image = new ImageIcon("img/player/mp80.png").getImage();
			color = new Color(0, 0, 0, 255);
		} else if (hpPercentage > 0.4) {
			image = new ImageIcon("img/player/mp60.png").getImage();
			color = new Color(109, 109, 109, 255);
		} else if (hpPercentage > 0.2) {
			image = new ImageIcon("img/player/mp40.png").getImage();
			color = new Color(109, 109, 109, 255);
		} else if (hpPercentage > 0) {
			image = new ImageIcon("img/player/mp20.png").getImage();
			color = new Color(109, 109, 109, 255);
		} else {
			image = new ImageIcon("img/player/mp0.png").getImage();
			color = new Color(255, 255, 255, 255);
		}
		setForeground(color);
	}

	@Override
	protected void paintImage(Graphics2D g2d) {

		g2d.drawImage(image, 0, 0, null);
		int textPositionY = image.getHeight(null) / 2 + 1 + g2d.getFontMetrics().getHeight() / 4;
		int textPositionX = ((image.getWidth(null) / 2) - 14
		                    - (g2d.getFontMetrics().stringWidth(displayText) / 2));
		g2d.translate(textPositionX, textPositionY);
		g2d.drawString(displayText, 0, 0);
	}
}
