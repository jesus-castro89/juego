package gui.panels;

import enemies.Enemy;
import gui.GameWindow;
import gui.buttons.AttackButton;
import gui.buttons.ExitButton;
import gui.buttons.FleeButton;
import gui.buttons.SaveButton;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BattlePanel extends JPanel {

	private static BattlePanel instance;
	private final Image img;
	private Enemy enemy;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private final ImageIcon activeIcon;
	private final ImageIcon inactiveIcon;
	private JPanel backgroundPanel;
	private JPanel buttonsPanel;
	private JPanel skillsPanel;
	private JButton attackButton;
	private JButton fleeButton;
	private JButton saveButton;
	private JButton exitButton;

	public static BattlePanel getInstance(int tabIndex, Enemy enemy) {

		if (instance == null) {

			instance = new BattlePanel(tabIndex, enemy);
		}
		return instance;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param tabIndex índice de la pestaña
	 */
	private BattlePanel(int tabIndex, Enemy enemy) {

		this.enemy = enemy;
		img = new ImageIcon("img/ui/panels/battlePanel.png").getImage();
		this.tabIndex = tabIndex;
		this.activeIcon = new ImageIcon("img/ui/tabs/battleTabActive.png");
		this.inactiveIcon = new ImageIcon("img/ui/tabs/battleTabInactive.png");
		this.actionsPanel = ActionsPanel.getInstance();
		Dimension size = new Dimension(1019, 342);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		add(backgroundPanel);
		setOpaque(false);
		setBackground(null);
		setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
		actionsPanel.addTab("Status", this);
		actionsPanel.setTabIcon(tabIndex, isActive() ? activeIcon : inactiveIcon);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				try {
					actionsPanel.setTabIcon(tabIndex, activeIcon);
				} catch (Exception ex) {

				}
			}

			@Override
			public void componentHidden(ComponentEvent e) {

				try {
					actionsPanel.setTabIcon(tabIndex, inactiveIcon);
				} catch (Exception ex) {

				}
			}
		});
	}

	private boolean isActive() {

		return actionsPanel.getSelectedIndex() == tabIndex;
	}

	/**
	 * Método que inicializa el panel
	 */
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(img, 0, 0, 1019, 342, null);
	}

	private void createUIComponents() {

		attackButton = new AttackButton(enemy);
		fleeButton = new FleeButton(enemy);
		saveButton = new SaveButton(Player.getInstance());
		exitButton = new ExitButton();
	}

	public Enemy getEnemy() {

		return enemy;
	}

	public void setEnemy(Enemy enemy) {

		this.enemy = enemy;
	}
}