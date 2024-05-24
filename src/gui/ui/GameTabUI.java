package gui.ui;

import util.interfaces.Dimensions;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class GameTabUI extends BasicTabbedPaneUI {

	private final Font tabFont;
	private final FontMetrics tabMetrics;

	public GameTabUI() {

		tabFont = FontManager.getInstance().getFont("Player");
		tabMetrics = new JLabel().getFontMetrics(tabFont);
	}

	@Override
	protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {

		return Math.max(tabMetrics.stringWidth(tabPane.getComponentAt(tabIndex).getName()) + 32,
				Dimensions.TAB_LABEL_SIZE.width+16);
	}

	@Override
	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {

		return Math.min(fontHeight + 16, Dimensions.TAB_LABEL_SIZE.height);
	}

	@Override
	protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
	                        Rectangle iconRect, Rectangle textRect) {

		Image img;
		String title = tabPane.getComponentAt(tabIndex).getName();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(tabFont);
		g2d.setColor(Color.BLACK);
		if (tabIndex == tabPane.getSelectedIndex()) {
			img = ImageManager.getInstance().getImage("inactiveTab");
		} else {
			img = ImageManager.getInstance().getImage("activeTab");
		}
		int imgWidth = calculateTabWidth(tabPlacement, tabIndex, g2d.getFontMetrics()) - 5;
		int imgHeight = calculateTabHeight(tabPlacement, tabIndex, g2d.getFontMetrics().getHeight());
		int imgX = rects[tabIndex].x + (rects[tabIndex].width - imgWidth) / 2;
		int imgY = rects[tabIndex].y + (rects[tabIndex].height - imgHeight) / 2;
		g2d.drawImage(img, imgX, imgY, imgWidth, imgHeight, null);
		int titleWidth = g2d.getFontMetrics().stringWidth(title);
		int titleHeight = g2d.getFontMetrics().getHeight();
		int titleAscent = g2d.getFontMetrics().getAscent();
		int textX = imgX + (imgWidth - titleWidth) / 2;
		int textY = imgY + (imgHeight - titleHeight) / 2 + titleAscent;
		g2d.drawString(title, textX, textY);
	}

	@Override
	protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {

	}
}
