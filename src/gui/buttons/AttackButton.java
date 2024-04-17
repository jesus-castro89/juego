package gui.buttons;

import enemies.Enemy;
import gui.GameWindow;
import gui.panels.MainPanel;
import player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackButton extends ActionButton {

	private Enemy enemy;

	public AttackButton(Enemy enemy) {

		super("Atacar");
		this.enemy = enemy;

	}
}
