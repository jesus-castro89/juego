package gui.ui;

import util.managers.ImageManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class EquipLabelUI extends BasicLabelUI {

	@Override
	public void paint(Graphics g, JComponent c) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Image image = ImageManager.getInstance().getImage("equipHolder");
		g2d.drawImage(image, 0, 0, c.getWidth(), c.getHeight(), null);
		super.paint(g2d, c);
	}

	@Override
	protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		super.paintEnabledText(l, g2d, s, textX, textY);
	}
}
