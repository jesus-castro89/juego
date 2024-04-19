package gui.events;

import enemies.Enemy;
import game.exceptions.EnemyDeadException;
import game.exceptions.PlayerDeathException;
import gui.GameWindow;
import gui.panels.*;
import player.Player;
import util.enemies.EnemyFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FleeButtonListener implements ActionListener {

	private Enemy enemy;

	public FleeButtonListener(Enemy enemy) {

		this.enemy = enemy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Player player = Player.getInstance();
		try {

			if (player.getSpeed() > enemy.getAdjustedSpeed()) {

				player.tryToFlee();
				enemy.attack();
				if (enemy.isDead()) throw new EnemyDeadException();
			} else {
				enemy.attack();
				if (enemy.isDead()) throw new EnemyDeadException();
				player.tryToFlee();
			}
			updatePanels(player);
		} catch (EnemyDeadException ex) {

			enemy = EnemyFactory.generateRegularEnemy(player);
			GameWindow.getInstance(player).setEnemy(enemy);
			updatePanels(player);
		}
	}

	private void updatePanels(Player player) {

		GameWindow.getInstance(player).repaint();
		StatusPanel.getInstance(0).update();
		MainPanel.getInstance(enemy).update(enemy);
		PlayerPanel.getInstance(player).update();
		EnemyPanel.getInstance(enemy).setEnemy(enemy);
		EnemyPanel.getInstance(enemy).update();
	}
}
