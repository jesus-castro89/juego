package gui.panels;

import enemies.Enemy;
import gui.windows.GameWindow;
import gui.buttons.AttackButton;
import gui.buttons.ExitButton;
import gui.buttons.FleeButton;
import gui.buttons.SaveButton;
import gui.events.AttackButtonListener;
import player.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends BackGroundPanel {

	private static BattlePanel instance;
	private Enemy enemy;
	private Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private JPanel mainPanel;
	private JPanel skillsPanel;
	private JButton attackButton;
	private JButton fleeButton;
	private JButton saveButton;
	private JButton exitButton;
	private final int slot;

	public static BattlePanel getInstance(int tabIndex, Enemy enemy, Player player, int slot) {

		if (instance == null) {

			instance = new BattlePanel(tabIndex, enemy, player, slot);
		}
		return instance;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param tabIndex índice de la pestaña
	 */
	private BattlePanel(int tabIndex, Enemy enemy, Player player, int slot) {

		super(ImageManager.getInstance().getImage("battlePanel"), new Dimension(1019, 342));
		this.slot = slot;
		this.enemy = enemy;
		this.player=player;
		this.tabIndex = tabIndex;
		this.actionsPanel = ActionsPanel.getInstance();
		Dimension size = new Dimension(1019, 342);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		add(mainPanel);
		setOpaque(false);
		setBackground(null);
		setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
		setName("Batalla");
	}

	private boolean isActive() {

		return actionsPanel.getSelectedIndex() == tabIndex;
	}

	private void createUIComponents() {

		attackButton = new AttackButton(enemy, player);
		fleeButton = new FleeButton(enemy);
		saveButton = new SaveButton(getSlot(), player);
		exitButton = new ExitButton();
		skillsPanel = new SkillPanel(player);
	}

	public Enemy getEnemy() {

		return enemy;
	}

	public void setEnemy(Enemy enemy) {

		this.enemy = enemy;
		attackButton.removeActionListener(attackButton.getActionListeners()[0]);
		attackButton.addActionListener(new AttackButtonListener(enemy, player));
	}

	public int getSlot() {

		return slot;
	}
}