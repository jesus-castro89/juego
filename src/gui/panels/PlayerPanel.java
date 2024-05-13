package gui.panels;

import gui.labels.HpLabel;
import gui.labels.MpLabel;
import gui.labels.PortraitLabel;
import gui.labels.RedTextLabel;
import player.Player;
import util.interfaces.Dimensions;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el panel del jugador
 */
public class PlayerPanel extends BackGroundPanel {

	private static PlayerPanel instance;
	private final Player player;
	private JPanel mainPanel;
	private JLabel portraitLabel;
	private JLabel nameLabel;
	private JLabel levelLabel;
	private JLabel hpLabel;
	private JLabel mpLabel;

	/**
	 * Método que devuelve la instancia del panel del jugador
	 *
	 * @return instancia del panel del jugador
	 */
	public static PlayerPanel getInstance(Player player) {

		if (instance == null) {

			instance = new PlayerPanel(player, ImageManager.getInstance().getImage("playerPanel"),
					Dimensions.SIDE_PANEL_SIZE);
		}
		return instance;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param player jugador
	 */
	private PlayerPanel(Player player, Image image, Dimension dimension) {

		super(image, dimension);
		this.player = player;
		add(mainPanel);
		update();
		mainPanel.setSize(dimension);
		mainPanel.setPreferredSize(dimension);
		mainPanel.setMaximumSize(dimension);
		mainPanel.setMinimumSize(dimension);
	}

	/**
	 * Método que actualiza el panel
	 */
	public void update() {

		//Actualizamos los valores del jugador
		nameLabel.setText(player.getName());
		// Actualizamos el nivel del jugador
		levelLabel.setText(String.format("Nivel: %d", player.getLevel()));
		// Actualizamos las barras
		((HpLabel) hpLabel).updateCharacter(player);
		((MpLabel) mpLabel).updateCharacter(player);
		// Actualizamos el panel
		repaint();
	}

	/**
	 * Método que inicializa los componentes del panel
	 */
	private void createUIComponents() {

		//Agregamos la etiqueta del retrato
		portraitLabel = new PortraitLabel();
		//Agregamos la etiqueta del nombre
		nameLabel = new RedTextLabel(player.getName());
		//Agregamos la etiqueta del nivel
		levelLabel = new RedTextLabel("Nivel: " + player.getLevel());
		//Agregamos la etiqueta de los puntos de vida
		hpLabel = new HpLabel(player);
		//Agregamos la etiqueta de los puntos de maná
		mpLabel = new MpLabel(player);
	}

	//Getters

	/**
	 * Método que devuelve el jugador
	 *
	 * @return jugador
	 */
	public Player getPlayer() {

		return player;
	}

	/**
	 * Método que devuelve el panel de fondo
	 *
	 * @return panel de fondo
	 */
	public JPanel getBackgroundPanel() {

		return mainPanel;
	}

	/**
	 * Método que devuelve la etiqueta del retrato
	 *
	 * @return etiqueta del retrato
	 */
	public JLabel getPortraitLabel() {

		return portraitLabel;
	}

	/**
	 * Método que devuelve la etiqueta del nombre
	 *
	 * @return etiqueta del nombre
	 */
	public JLabel getNameLabel() {

		return nameLabel;
	}

	/**
	 * Método que devuelve la etiqueta del nivel
	 *
	 * @return etiqueta del nivel
	 */
	public JLabel getLevelLabel() {

		return levelLabel;
	}
}
