package gui.panels;

import player.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {

	private InventoryPanel instance;
	private Player player;
	private JPanel backgroundPanel;

	public InventoryPanel getInstance() {

		if (instance == null) {

			instance = new InventoryPanel();
		}
		return instance;
	}

	private InventoryPanel() {

		player = Player.getInstance();
	}
}
