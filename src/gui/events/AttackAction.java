package gui.events;

import enemies.Enemy;
import game.exceptions.EnemyDeadException;
import game.exceptions.PlayerDeathException;
import gui.panels.DialogPanel;
import player.Player;
import player.Stats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackAction implements ActionListener {

	private Enemy enemy;

	public AttackAction(Enemy enemy) {

		this.enemy = enemy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		DialogPanel dialogPanel = DialogPanel.getInstance();
		Player player = Player.getInstance();

		if (player.getSpeed() > enemy.getStats().get(Stats.SPEED)) {

			try {
				player.attack(enemy);
			} catch (PlayerDeathException ex) {
				throw new RuntimeException(ex);
			}
			if (!enemy.isDead()) {

				try {
					enemy.attack();
				} catch (EnemyDeadException ex) {
					throw new RuntimeException(ex);
				}
			}
		} else {

			try {
				enemy.attack();
			} catch (EnemyDeadException ex) {
				throw new RuntimeException(ex);
			}
			if (!player.isDead() && !enemy.isDead()) {

				try {
					player.attack(enemy);
				} catch (PlayerDeathException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
	}
}
