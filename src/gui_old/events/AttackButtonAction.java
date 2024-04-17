package gui_old.events;

import enemies.Enemy;
import game.exceptions.EnemyDeadException;
import game.exceptions.PlayerDeathException;
import gui_old.game.GameWindow;
import gui_old.panels.*;
import player.Player;
import player.Stats;
import util.enemies.EnemyFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackButtonAction implements ActionListener {

	private final Player player;
	private Enemy enemy;
	private GameWindow window;

	public AttackButtonAction(Player player, Enemy enemy, GameWindow window) {

		this.player = player;
		this.enemy = enemy;
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		CharactersPanel charactersPanel = CharactersPanel.getInstance(player, enemy, window);
		this.enemy = GameWindow.getInstance().getEnemy();
		if (player.getSpeed() > enemy.getStats().get(Stats.SPEED)) {

			try {

				player.attack(enemy);
				if (!enemy.isDead()) {

					enemy.attack();
				}
			} catch (PlayerDeathException | EnemyDeadException ex) {

				throw new RuntimeException(ex);
			}
		} else {
			try {

				enemy.attack();
				if (!player.isDead() && !enemy.isDead()) {

					player.attack(enemy);
				}
			} catch (PlayerDeathException | EnemyDeadException ex) {
				throw new RuntimeException(ex);
			}
		}
		if (enemy.isDead()) {

			enemy = EnemyFactory.generateRegularEnemy(player);
			GameWindow.getInstance().setEnemy(enemy);
			CharactersPanel.getInstance(player, enemy, window).updateEnemy(enemy);
			EnemyPanel.getInstance(enemy).updateEnemy(enemy);
		}else {
			EnemyPanel.getInstance(enemy).updateEnemy();
		}
		PlayerPanel.getInstance(player).updatePlayer(player);

	}
}
