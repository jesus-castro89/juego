package gui.panels;

import gui.events.HandCursorListener;
import gui.ui.GameTabUI;

import javax.swing.*;
import java.awt.*;

public class ActionsPanel extends JTabbedPane {

	private static ActionsPanel instance;

	public static ActionsPanel getInstance() {

		if (instance == null) {

			instance = new ActionsPanel();
		}
		return instance;
	}

	private ActionsPanel() {

		super();
		Dimension size = new Dimension(1024, 384);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setOpaque(false);
		setUI(new GameTabUI());
		addMouseMotionListener(new HandCursorListener(this));
	}
}
