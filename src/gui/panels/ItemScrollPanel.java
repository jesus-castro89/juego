package gui.panels;

import org.jetbrains.annotations.NotNull;
import util.interfaces.Dimensions;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class ItemScrollPanel extends JScrollPane {

	private Dimension scrollSize;

	public ItemScrollPanel(JPanel panel) {

		super(panel);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getVerticalScrollBar().setOpaque(false);
		getVerticalScrollBar().setBorder(null);
		getViewport().setOpaque(false);
		getViewport().setBorder(null);
		setOpaque(false);
		setBorder(null);
	}

	public Dimension getScrollSize() {

		return scrollSize;
	}

	public void setScrollSize(Dimension scrollSize) {

		this.scrollSize = scrollSize;
	}
}
