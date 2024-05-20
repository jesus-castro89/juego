package gui.windows;

import gui.panels.StartPanel;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {

	private static StartWindow instance;

	public static StartWindow getInstance() {

		if (instance == null) {
			instance = new StartWindow();
		}
		return instance;
	}

	private StartWindow() {

		super("Start Window");
		add(StartPanel.getInstance());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void update() {

		StartPanel.getInstance().update();
	}

	public static void main(String[] args) {

		StartWindow.getInstance();
	}
}
