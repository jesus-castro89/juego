package gui.panels;

import enemies.Enemy;
import gui.labels.PlayerSpriteLabel;
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
	private JPanel playerSpritePanel;
	private JPanel enemySpritePanel;

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
		Dimension spritePanelSize = new Dimension(getPreferredSize().width / 2, getPreferredSize().height/2);
		playerSpritePanel.setPreferredSize(spritePanelSize);
		enemySpritePanel.setPreferredSize(spritePanelSize);
	}

	public void update(Enemy enemy) {

		((SpriteLabel) enemySprite).updateImage(enemy.getImage());
		repaint();
	}

	private void createUIComponents() {

		dialogPanel = DialogPanel.getInstance();
		playerSprite = new PlayerSpriteLabel(player.getImage());
		enemySprite = new SpriteLabel(enemy.getImage());
	}

	public void setEnemy(Enemy enemy) {

		this.enemy = enemy;
	}
}
