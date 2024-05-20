package gui.labels;

import characters.BasicCharacter;
import util.interfaces.Dimensions;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class HpLabel extends JLabel {

	protected BasicCharacter character;
	protected Image image;
	protected String displayText;

	public HpLabel(BasicCharacter character) {

		super(character.getName());
		this.character = character;
		init();
		Font font = FontManager.getInstance().getFont("Depixel");
		Dimension size = Dimensions.BAR_SIZE;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setBorder(BorderFactory.createEmptyBorder());
		setFont(font);
	}

	protected void init() {

		displayText = String.format("%d/%d", character.getHp(), character.getMaxHp());
		double hpPercentage = (double) character.getHp() / character.getMaxHp();
		ImageManager imageManager = ImageManager.getInstance();
		Color color;
		if (hpPercentage >= .8) {
			image = imageManager.getImage("hp100");
			color = new Color(0, 0, 0, 255);
		} else if (hpPercentage > 0.6) {
			image = imageManager.getImage("hp80");
			color = new Color(0, 0, 0, 255);
		} else if (hpPercentage > 0.4) {
			image = imageManager.getImage("hp60");
			color = new Color(109, 109, 109, 255);
		} else if (hpPercentage > 0.2) {
			image = imageManager.getImage("hp40");
			color = new Color(109, 109, 109, 255);
		} else if (hpPercentage > 0) {
			image = imageManager.getImage("hp20");
			color = new Color(109, 109, 109, 255);
		} else {
			image = imageManager.getImage("hp0");
			color = new Color(255, 255, 255, 255);
		}
		setForeground(color);
	}

	public void updateCharacter(BasicCharacter character) {

		this.character = character;
		init();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		paintImage(g2d);
	}

	protected void paintImage(Graphics2D g2d) {

		g2d.drawImage(image, 0, 0, null);
		int textPositionY = image.getHeight(null) / 2 + 1 + g2d.getFontMetrics().getHeight() / 4;
		int textPositionX = ((image.getWidth(null) - 28) / 2) + 28 - (g2d.getFontMetrics().stringWidth(displayText) / 2);
		g2d.translate(textPositionX, textPositionY);
		g2d.drawString(displayText, 0, 0);
	}

	public void setText(String text) {

		this.displayText = text;
		repaint();
	}
}