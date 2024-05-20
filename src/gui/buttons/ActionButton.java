package gui.buttons;

import gui.events.ButtonCursorAdapter;
import gui.ui.ActionButtonUI;
import util.interfaces.Dimensions;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public abstract class ActionButton extends JButton {

	private Font font;
	private Image image;
	private int topPadding;
	//private final String displayText;

	public ActionButton(String displayText) {

		super(displayText, new ImageIcon(ImageManager.getInstance().getImage("button")));
		topPadding = 0;
		setBorderPainted(false);
		setContentAreaFilled(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setVerticalTextPosition(SwingConstants.CENTER);
		setHorizontalTextPosition(SwingConstants.CENTER);
		addMouseListener(new ButtonCursorAdapter(this));
		setUI(new ActionButtonUI());
	}

	@Override
	public Font getFont() {

		return font;
	}

	@Override
	public void setFont(Font font) {

		this.font = font;
	}

	public void setTopPadding(int topPadding) {

		this.topPadding = topPadding;
	}

	public int getTopPadding() {

		return topPadding;
	}

	/*public String getDisplayText() {

		return displayText;
	}*/

	public Image getImage() {

		return image;
	}

	public void setImage(Image image) {

		this.image = image;
	}
}
