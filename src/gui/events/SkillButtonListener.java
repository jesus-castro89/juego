package gui.events;

import enemies.Enemy;
import gui.windows.GameWindow;
import player.Player;
import player.skills.Skill;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkillButtonListener implements ActionListener {

	private final Skill skill;
	private Player player;
	private Enemy enemy;

	public SkillButtonListener(Skill skill, Player player, Enemy enemy) {

		skill.setPlayer(player);
		skill.setEnemy(enemy);
		this.skill = skill;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		skill.setPlayer(GameWindow.getInstance().getPlayer());
		skill.setEnemy(GameWindow.getInstance().getEnemy());
		skill.activate();
	}
}
