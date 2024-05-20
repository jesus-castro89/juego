package gui.panels;

import gui.ui.PanelUI;

import javax.swing.*;

public abstract class BackGroundPanel extends JPanel {

	public BackGroundPanel() {

		setUI(new PanelUI());
		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setOpaque(false);
	}
}
