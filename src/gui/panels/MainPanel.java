package gui.panels;

import enemies.Enemy;
import player.Player;
import gui.labels.SpriteLabel;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends BackGroundPanel {

	private static MainPanel instance;
	private Enemy enemy;
	private final Player player;
	private JPanel mainPanel;
	private JPanel spritesPanel;
	private JPanel dialogPanel;
	private JLabel enemySprite;
	private JLabel playerSprite;

	public static MainPanel getInstance(Enemy enemy, Player player) {

		if (instance == null) {
			instance = new MainPanel(enemy, player, ImageManager.getInstance().getImage("charactersPanel"),
					new Dimension(512, 360));
		}
		return instance;
	}

	private MainPanel(Enemy enemy, Player player, Image image, Dimension dimension) {

		super(image, dimension);
		this.enemy = enemy;
		this.player=player;
		add(mainPanel);
	}

	public void update(Enemy enemy) {

		((SpriteLabel) enemySprite).updateImage(enemy.getImage());
		repaint();
	}

	private void createUIComponents() {

		dialogPanel = DialogPanel.getInstance();
		playerSprite = new SpriteLabel(player.getImage());
		enemySprite = new SpriteLabel(enemy.getImage());
	}

	public void setEnemy(Enemy enemy) {

		this.enemy = enemy;
	}

	public JPanel getSpritesPanel() {

		return spritesPanel;
	}

	public JPanel getDialogPanel() {

		return dialogPanel;
	}

	public JLabel getPlayerSprite() {

		return playerSprite;
	}
}
