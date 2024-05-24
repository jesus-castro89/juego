package gui.buttons;

import enemies.Enemy;
import gui.events.SkillButtonListener;
import player.Player;
import player.skills.Skill;

public class SkillButton extends ActionButton {


	public SkillButton(Skill skill, Player player, Enemy enemy) {

		super("Usar");
		addActionListener(new SkillButtonListener(skill, player, enemy));
	}
}
