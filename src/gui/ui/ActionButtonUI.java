package gui.ui;

import gui.buttons.ActionButton;
import gui.events.ButtonCursorAdapter;
import gui.events.HandCursorListener;
import util.interfaces.Dimensions;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import java.awt.*;

public class ActionButtonUI extends BasicButtonUI {

	@Override
	protected void installDefaults(AbstractButton b) {

		ImageManager manager = ImageManager.getInstance();
		b.setIcon(new ImageIcon(manager.getImage("button")));
		b.setRolloverIcon(new ImageIcon(manager.getImage("buttonHover")));
		b.setFont(FontManager.getInstance().getFont("Player"));
		b.setForeground(Color.BLACK);
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		b.setVerticalTextPosition(SwingConstants.CENTER);
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setVerticalAlignment(SwingConstants.CENTER);
		b.setBorder(BorderFactory.createEmptyBorder());
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
		b.setBorderPainted(false);
		b.setMargin(new Insets(0, 0, 0, 0));
		b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b.addMouseListener(new ButtonCursorAdapter((ActionButton) b));
	}

	@Override
	public Dimension getPreferredSize(JComponent c) {

		FontMetrics fm = c.getFontMetrics(c.getFont());
		int textWidth = fm.stringWidth(((JButton) c).getText());
		int textHeight = fm.getHeight();
		int minWidth = Math.max(textWidth + 20, Dimensions.BUTTON_SIZE.width);
		int minHeight = Math.max(textHeight + 10, Dimensions.BUTTON_SIZE.height);
		return new Dimension(minWidth, minHeight); // Agregar un margen de 10 pixeles
	}

	@Override
	public Dimension getMinimumSize(JComponent c) {

		return getPreferredSize(c);
	}

	@Override
	public Dimension getMaximumSize(JComponent c) {

		return getPreferredSize(c);
	}

	@Override
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {

		ActionButton button = (ActionButton) c;
		Graphics2D g2d = (Graphics2D) g;
		//Activamos la interpolación
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Pintamos la imagen
		Image image = button.getImage();
		if (image == null) {
			image = ImageManager.getInstance().getImage("button");
		}
		g2d.drawImage(image, 0, 0, getPreferredSize(c).width, getPreferredSize(c).height, null);
	}

	@Override
	public void paint(Graphics g, JComponent c) {

		Graphics2D g2d = (Graphics2D) g;
		//Activamos la interpolación
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		//Modificamos la fuente y el color de la fuente
		g2d.setColor(c.getForeground());
		//Pintamos el icono y el texto
		paintIcon(g2d, c, new Rectangle(0, 0, getPreferredSize(c).width, getPreferredSize(c).height));
		paintText(g2d, c, new Rectangle(0, 0, getPreferredSize(c).width, getPreferredSize(c).height),
				((JButton) c).getText());
	}


	@Override
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {

		AbstractButton b = (AbstractButton) c;
		ButtonModel model = b.getModel();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		int mnemIndex = b.getDisplayedMnemonicIndex();
		// Calcular la posición central del texto
		int textWidth = fm.stringWidth(((JButton) c).getText());
		int x = textRect.x + (textRect.width - textWidth) / 2;
		int y = textRect.y + (textRect.height - fm.getHeight()) / 2 + fm.getAscent();
		/* Draw the Text */
		if (model.isRollover()) {
			BasicGraphicsUtils.drawStringUnderlineCharAt(g2d, text, mnemIndex, x, y - 2);
		} else {
			BasicGraphicsUtils.drawStringUnderlineCharAt(g2d, text, mnemIndex, x, y);
		}
	}
}
