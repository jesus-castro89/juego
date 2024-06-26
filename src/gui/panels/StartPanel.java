package gui.panels;

import gui.buttons.LoadGameButton;
import gui.buttons.NewGameButton;
import gui.labels.FileLabel;
import gui.labels.RedTextLabel;
import gui.ui.TextLabelUI;
import player.Player;
import util.managers.FileManager;
import util.managers.FontManager;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class StartPanel extends BackGroundPanel {

	private JPanel backgroundPanel;
	private JPanel titlePanel;
	private JPanel slot1Panel;
	private JPanel slot2Panel;
	private JPanel slot3Panel;
	private JPanel slot4Panel;
	private JLabel title;
	private JButton slot1NewGameButton;
	private JButton slot1LoadGameButton;
	private JLabel slot1Label;
	private JLabel slot2Label;
	private JLabel slot3Label;
	private JLabel slot4Label;
	private JButton slot2NewGameButton;
	private JButton slot3NewGameButton;
	private JButton slot4NewGameButton;
	private JButton slot2LoadGameButton;
	private JButton slot3LoadGameButton;
	private JButton slot4LoadGameButton;

	private static StartPanel instance;

	public static StartPanel getInstance() {

		if (instance == null) {
			instance = new StartPanel();
		}
		return instance;
	}

	private StartPanel() {

		super();
		add(backgroundPanel);
		update();
		title.setFont(FontManager.getInstance().getFont("Game Title"));
	}

	public void update() {

		for (int i = 1; i <= 4; i++) {
			// Cargamos el nombre de la partida
			String slotName = "Slot " + i;
			JLabel slotLabel = null;
			try {

				slotLabel = (JLabel) getClass().getDeclaredField("slot" + i + "Label").get(this);
				Player player = FileManager.loadGame(i);
				if (player != null)
					slotName = String.format("%s - NIVEL: %d", player.getName().toUpperCase(), player.getLevel());
				slotLabel.setText(slotName);
				switch (i) {
					case 1 -> {
						slot1NewGameButton.setVisible(false);
						slot1LoadGameButton.setVisible(true);
					}
					case 2 -> {
						slot2NewGameButton.setVisible(false);
						slot2LoadGameButton.setVisible(true);
					}
					case 3 -> {
						slot3NewGameButton.setVisible(false);
						slot3LoadGameButton.setVisible(true);
					}
					case 4 -> {
						slot4NewGameButton.setVisible(false);
						slot4LoadGameButton.setVisible(true);
					}
				}
			} catch (IllegalAccessException | NoSuchFieldException e) {

				JOptionPane.showMessageDialog(null, "Error al cargar la partida " + i,
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (FileNotFoundException e) {

				slotLabel.setText("-- Vació --");
				switch (i) {
					case 1 -> slot1LoadGameButton.setVisible(false);
					case 2 -> slot2LoadGameButton.setVisible(false);
					case 3 -> slot3LoadGameButton.setVisible(false);
					case 4 -> slot4LoadGameButton.setVisible(false);
				}
			}
		}
	}

	private void createUIComponents() {

		// Creamos las etiquetas de los slots
		slot1Label = new FileLabel(" ");
		slot2Label = new FileLabel(" ");
		slot3Label = new FileLabel(" ");
		slot4Label = new FileLabel(" ");
		// Creamos los botones de cargar partida
		slot1LoadGameButton = new LoadGameButton(1);
		slot2LoadGameButton = new LoadGameButton(2);
		slot3LoadGameButton = new LoadGameButton(3);
		slot4LoadGameButton = new LoadGameButton(4);
		// Creamos los botones de nueva partida
		slot1NewGameButton = new NewGameButton(1);
		slot2NewGameButton = new NewGameButton(2);
		slot3NewGameButton = new NewGameButton(3);
		slot4NewGameButton = new NewGameButton(4);
	}
}
