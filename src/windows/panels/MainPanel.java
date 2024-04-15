package windows.panels;

import enemies.Enemy;
import player.Player;
import windows.GameWindow;
import windows.labels.SpriteLabel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	private static MainPanel instance;
	private Enemy enemy;
	private JPanel backgroundPanel;
	private JPanel spritesPanel;
	private JPanel dialogPanel;
	private JLabel enemySprite;
	private JLabel playerSprite;

	public static MainPanel getInstance(Enemy enemy) {

		if (instance == null) {
			instance = new MainPanel(enemy);
		}
		return instance;
	}

	private MainPanel(Enemy enemy) {

		this.enemy = enemy;
		add(backgroundPanel);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Image image = new ImageIcon("img/ui/panels/charactersPanel.png").getImage();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, 512, 384, null);
	}

	private void createUIComponents() {

		dialogPanel = DialogPanel.getInstance();
		playerSprite = new SpriteLabel(Player.getInstance().getImage());
		enemySprite = new SpriteLabel(enemy.getImage());
	}

	public void updateEnemy(Enemy enemy) {

		this.enemy = enemy;
	}
}
