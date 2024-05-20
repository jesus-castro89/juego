package gui.ui;

import util.interfaces.Dimensions;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
		c.setFont(FontManager.getInstance().getFont("Depixel"));
		c.setForeground(Color.BLACK);
		c.setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	@Override
	public void paint(Graphics g, JComponent c) {

		Graphics2D g2d = (Graphics2D) g;
		Image image = ImageManager.getInstance().getImage("textHolder");
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, getPreferredSize(c).width, getPreferredSize(c).height, null);
		super.paint(g2d, c);
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
