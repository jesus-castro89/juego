package gui.ui;

import util.interfaces.Dimensions;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class TextLabelUI extends BasicLabelUI {

	@Override
	protected void installDefaults(JLabel c) {

		c.setHorizontalTextPosition(SwingConstants.CENTER);
		c.setVerticalTextPosition(SwingConstants.CENTER);
		c.setHorizontalAlignment(SwingConstants.CENTER);
		c.setVerticalAlignment(SwingConstants.CENTER);
		c.setOpaque(false);
		c.setFont(FontManager.getInstance().getFont("Player"));
		c.setForeground(Color.BLACK);
		c.setBorder(BorderFactory.createEmptyBorder());
	}

	@Override
	public void paint(Graphics g, JComponent c) {

		Graphics2D g2d = (Graphics2D) g;
		Image image = getTextHolder();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(image, 0, 0, getPreferredSize(c).width, getPreferredSize(c).height, null);
		int x = (getPreferredSize(c).width - c.getFontMetrics(c.getFont()).stringWidth(((JLabel) c).getText())) / 2;
		int y = (getPreferredSize(c).height - c.getFontMetrics(c.getFont()).getHeight()) / 2 + c.getFontMetrics(c.getFont()).getAscent();
		paintEnabledText((JLabel) c, g2d, ((JLabel) c).getText(), x, y);
	}

	protected Image getTextHolder() {

		return ImageManager.getInstance().getImage("textHolder");
	}

	@Override
	protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {

		super.paintEnabledText(l, g, s, textX, textY);
	}

	@Override
	public Dimension getPreferredSize(JComponent c) {

		return Dimensions.LABEL_SIZE;
	}

	@Override
	public Dimension getMaximumSize(JComponent c) {

		return getPreferredSize(c);
	}

	@Override
	public Dimension getMinimumSize(JComponent c) {

		return getPreferredSize(c);
	}
}
