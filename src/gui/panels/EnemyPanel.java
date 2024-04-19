package gui.panels;

import enemies.Enemy;
import gui.labels.HpLabel;
import gui.labels.RedTextLabel;
import player.Stats;

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
		update();
	}

	public void update() {

		enemyName.setText(enemy.getName());
		((HpLabel) hpLabel).updateCharacter(enemy);
		attackLabel.setText(String.format("%s: %d", Stats.ATTACK.getName(),
				enemy.getAdjustedAttack()));
		defenseLabel.setText(String.format("%s: %d", Stats.DEFENSE.getName(),
				enemy.getAdjustedDefense()));
		speedLabel.setText(String.format("%s: %d", Stats.SPEED.getName(),
				enemy.getAdjustedSpeed()));
		expLabel.setText(String.format("EXP: %d", enemy.getExperience()));
		goldLabel.setText(String.format("ORO: %d", enemy.getGold()));
		repaint();

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
				enemy.getAdjustedAttack()));
		//Agregamos la etiqueta de la defensa
		defenseLabel = new RedTextLabel(String.format("%s: %d", Stats.DEFENSE.getName(),
				enemy.getAdjustedDefense()));
		//Agregamos la etiqueta de la velocidad
		speedLabel = new RedTextLabel(String.format("%s: %d", Stats.SPEED.getName(),
				enemy.getAdjustedSpeed()));
		//Agregamos la etiqueta de la experiencia
		expLabel = new RedTextLabel(String.format("EXP: %d", enemy.getExperience()));
		//Agregamos la etiqueta del oro
		goldLabel = new RedTextLabel(String.format("ORO: %d", enemy.getGold()));
	}

	public void setEnemy(Enemy enemy) {

		this.enemy = enemy;
	}
}