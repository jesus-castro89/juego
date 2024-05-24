package gui.ui;

import util.interfaces.Dimensions;
import util.managers.ImageManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class FileLabelUI extends TextLabelUI {

	@Override
	protected void installDefaults(JLabel c) {

		super.installDefaults(c);
		c.setHorizontalAlignment(SwingConstants.CENTER);
		c.setVerticalAlignment(SwingConstants.CENTER);
	}

	@Override
	public Dimension getPreferredSize(JComponent c) {

		return Dimensions.FILE_LABEL_SIZE;
	}

	@Override
	protected Image getTextHolder() {

		return ImageManager.getInstance().getImage("fileHolder");
	}
}
