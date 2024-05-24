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

	public ActionButton(String displayText) {

		super(displayText, new ImageIcon(ImageManager.getInstance().getImage("button")));
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

	public Image getImage() {

		return image;
	}

	public void setImage(Image image) {

		this.image = image;
	}
}
