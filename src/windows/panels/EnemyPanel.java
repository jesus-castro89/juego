package windows.panels;

import enemies.Enemy;
import player.Player;
import player.Stats;
import windows.labels.HpLabel;
import windows.labels.RedTextLabel;

import javax.swing.*;
import java.awt.*;

public class EnemyPanel extends JPanel {

	private static EnemyPanel instance;
	private JPanel backgroundPanel;
	private JLabel enemyName;
	private JLabel hpLabel;
	private JLabel attackLabel;
	private JLabel defenseLabel;
	private JLabel speedLabel;
	private JLabel expLabel;
	private JLabel goldLabel;
	private Enemy enemy;

	public static EnemyPanel getInstance(Enemy enemy) {

		if (instance == null) {
			instance = new EnemyPanel(enemy);
		}
		return instance;
	}

	private EnemyPanel(Enemy enemy) {

		this.enemy = enemy;
		add(backgroundPanel);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Image image = new ImageIcon("img/ui/panels/enemyPanel.png").getImage();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, 256, 384, null);
	}

	private void createUIComponents() {
		//Agregamos la etiqueta del nombre
		enemyName = new RedTextLabel(enemy.getName());
		//Agregamos la etiqueta de los puntos de vida
		hpLabel = new HpLabel(enemy);
		//Agregamos la etiqueta del ataque
		attackLabel = new RedTextLabel(String.format("%s: %d", Stats.ATTACK.getName(),
				enemy.getStats().get(Stats.ATTACK)));
		//Agregamos la etiqueta de la defensa
		defenseLabel = new RedTextLabel(String.format("%s: %d", Stats.DEFENSE.getName(),
				enemy.getStats().get(Stats.DEFENSE)));
		//Agregamos la etiqueta de la velocidad
		speedLabel = new RedTextLabel(String.format("%s: %d", Stats.SPEED.getName(),
				enemy.getStats().get(Stats.SPEED)));
		//Agregamos la etiqueta de la experiencia
		expLabel = new RedTextLabel(String.format("EXP: %d", enemy.getExperience()));
		//Agregamos la etiqueta del oro
		goldLabel = new RedTextLabel(String.format("ORO: %d", enemy.getGold()));
	}
}