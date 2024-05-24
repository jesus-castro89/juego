package player.skills;

import enemies.Enemy;
import gui.buttons.SkillButton;
import gui.panels.*;
import gui.windows.GameWindow;
import player.Player;

import java.io.Serializable;

public abstract class Skill implements Serializable {

	protected String name;
	protected String description;
	protected int level;
	protected int manaCost;
	protected SkillButton button;
	protected Player player;
	protected Enemy enemy;

	public Skill(String name, String description, int level, int manaCost, Player player, Enemy enemy) {

		this.name = name;
		this.description = description;
		this.level = level;
		this.manaCost = manaCost;
		this.player = player;
		this.enemy = enemy;
		this.button = new SkillButton(this, player, enemy);
	}

	protected void updatePanels() {

		// Actualizamos los paneles
		GameWindow.getInstance().repaint();
		StatusPanel.getInstance(0, player).update();
		MainPanel.getInstance(enemy, player).update(enemy);
		PlayerPanel.getInstance(player).update();
		EnemyPanel.getInstance(enemy).setEnemy(enemy);
		EnemyPanel.getInstance(enemy).update();
		InventoryPanel.getInstance(2, player).update();
	}

	protected abstract void skillAction();

	public void activate() {

		if (player.getMp() < manaCost) {

			DialogPanel.getInstance().addText("No tienes suficiente mana para usar esta habilidad\n");
		} else {
			skillAction();
		}
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public int getLevel() {

		return level;
	}

	public int getManaCost() {

		return manaCost;
	}

	public SkillDetail getSkillDetailPanel() {

		return new SkillDetail(this);
	}

	public SkillButton getButton() {

		return button;
	}

	public Player getPlayer() {

		return player;
	}

	public Enemy getEnemy() {

		return enemy;
	}

	public void setPlayer(Player player) {

		this.player = player;
	}

	public void setEnemy(Enemy enemy) {

		this.enemy = enemy;
	}
}
