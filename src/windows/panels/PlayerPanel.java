package windows.panels;

import player.Player;
import windows.GameWindow;
import windows.labels.HpLabel;
import windows.labels.MpLabel;
import windows.labels.PortraitLabel;
import windows.labels.RedTextLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el panel del jugador
 */
public class PlayerPanel extends JPanel {

	private static PlayerPanel instance;
	private final Player player;
	private JPanel backgroundPanel;
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

			instance = new PlayerPanel(player);
		}
		return instance;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param player jugador
	 */
	private PlayerPanel(Player player) {

		this.player = Player.getInstance();
		add(backgroundPanel);
	}

	/**
	 * Método que inicializa el panel
	 */
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Image image = new ImageIcon("img/ui/panels/playerPanel.png").getImage();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, 256, 384, null);
	}

	/**
	 * Método que inicializa los componentes del panel
	 */
	private void createUIComponents() {

		//Agregamos la etiqueta del retrato
		portraitLabel = new PortraitLabel();
		//Agregamos la etiqueta del nombre
		nameLabel = new RedTextLabel(Player.getInstance().getName());
		//Agregamos la etiqueta del nivel
		levelLabel = new RedTextLabel("Nivel: " + Player.getInstance().getLevel());
		//Agregamos la etiqueta de los puntos de vida
		hpLabel = new HpLabel(Player.getInstance());
		//Agregamos la etiqueta de los puntos de maná
		mpLabel = new MpLabel(Player.getInstance());
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

		return backgroundPanel;
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
