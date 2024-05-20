package gui.panels;

import enemies.Enemy;
import player.Player;
import gui.labels.SpriteLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

		if (instance == null)
			instance = new MainPanel(enemy, player);
		return instance;
	}

	private MainPanel(Enemy enemy, Player player) {

		super();
		this.enemy = enemy;
		this.player = player;
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
}
