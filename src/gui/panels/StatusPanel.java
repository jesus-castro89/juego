package gui.panels;

import player.Player;
import gui.labels.StatLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StatusPanel extends JPanel {

	private static StatusPanel instance;
	private final Image img;
	private final Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private final ImageIcon activeIcon;
	private final ImageIcon inactiveIcon;
	private JPanel backgroundPanel;
	private JLabel levelLabel;
	private JLabel attackLabel;
	private JLabel defenseLabel;
	private JLabel goldLabel;
	private JLabel intLabel;
	private JLabel resLabel;
	private JLabel luckLabel;
	private JLabel desLabel;
	private JLabel speedLabel;
	private JLabel weaponLabel;
	private JLabel headArmorLabel;
	private JLabel chestArmorLabel;
	private JLabel feetArmorLabel;
	private JLabel legArmorLabel;
	private JLabel handArmorLabel;

	public static StatusPanel getInstance(int tabIndex) {

		if (instance == null) {

			instance = new StatusPanel(tabIndex, Player.getInstance());
		}
		return instance;
	}

	@Override
	public void update(Graphics g) {

		super.update(g);
	}

	/**
	 * Constructor de la clase
	 *
	 * @param tabIndex índice de la pestaña
	 * @param player   jugador
	 */
	private StatusPanel(int tabIndex, Player player) {

		this.player = player;
		img = new ImageIcon("img/ui/panels/statusPanel.png").getImage();
		this.tabIndex = tabIndex;
		this.activeIcon = new ImageIcon("img/ui/tabs/statusTabActive.png");
		this.inactiveIcon = new ImageIcon("img/ui/tabs/statusTabInactive.png");
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

				actionsPanel.setTabIcon(tabIndex, activeIcon);
			}

			@Override
			public void componentHidden(ComponentEvent e) {

				actionsPanel.setTabIcon(tabIndex, inactiveIcon);
			}
		});
		update();
	}

	public void update(){

		levelLabel.setText("EXP: " + player.getExperience());
		attackLabel.setText(player.getTotalAttack());
		defenseLabel.setText(player.getTotalDefense());
		goldLabel.setText("ORO: " + player.getGold());
		intLabel.setText(player.getTotalIntelligence());
		resLabel.setText(player.getTotalResistance());
		luckLabel.setText(player.getTotalLuck());
		desLabel.setText(player.getTotalDexterity());
		speedLabel.setText(player.getTotalSpeed());
		weaponLabel.setText(player.getWeapon() != null ? player.getWeapon().getName() : "No equipado");
		headArmorLabel.setText(player.getHeadArmor() != null ? player.getHeadArmor().getName() : "No equipado");
		chestArmorLabel.setText(player.getChestArmor() != null ? player.getChestArmor().getName() : "No equipado");
		feetArmorLabel.setText(player.getFootArmor() != null ? player.getFootArmor().getName() : "No equipado");
		legArmorLabel.setText(player.getLegArmor() != null ? player.getLegArmor().getName() : "No equipado");
		handArmorLabel.setText(player.getHandArmor() != null ? player.getHandArmor().getName() : "No equipado");
		repaint();
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

		levelLabel = new StatLabel("EXP: " + player.getExperience(),
				new ImageIcon("img/ui/holders/expHolder.png").getImage());
		attackLabel = new StatLabel(player.getTotalAttack(),
				new ImageIcon("img/ui/holders/attackHolder.png").getImage());
		defenseLabel = new StatLabel(player.getTotalDefense(),
				new ImageIcon("img/ui/holders/defenseHolder.png").getImage());
		goldLabel = new StatLabel("ORO: " + player.getGold(),
				new ImageIcon("img/ui/holders/goldHolder.png").getImage());
		intLabel = new StatLabel(player.getTotalIntelligence(),
				new ImageIcon("img/ui/holders/intHolder.png").getImage());
		resLabel = new StatLabel(player.getTotalResistance(),
				new ImageIcon("img/ui/holders/resHolder.png").getImage());
		luckLabel = new StatLabel(player.getTotalLuck(),
				new ImageIcon("img/ui/holders/lukHolder.png").getImage());
		desLabel = new StatLabel(player.getTotalDexterity(),
				new ImageIcon("img/ui/holders/dexterityHolder.png").getImage());
		speedLabel = new StatLabel(player.getTotalSpeed(),
				new ImageIcon("img/ui/holders/velHolder.png").getImage());
		weaponLabel = new StatLabel(player.getWeapon() != null ? player.getWeapon().getName() : "No equipado",
				new ImageIcon("img/ui/holders/weaponHolder.png").getImage());
		headArmorLabel = new StatLabel(player.getHeadArmor() != null ? player.getHeadArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/headArmorHolder.png").getImage());
		chestArmorLabel = new StatLabel(player.getChestArmor() != null ? player.getChestArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/chestArmorHolder.png").getImage());
		feetArmorLabel = new StatLabel(player.getFootArmor() != null ? player.getFootArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/feetArmorHolder.png").getImage());
		legArmorLabel = new StatLabel(player.getLegArmor() != null ? player.getLegArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/legArmorHolder.png").getImage());
		handArmorLabel = new StatLabel(player.getHandArmor() != null ? player.getHandArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/handArmorHolder.png").getImage());
	}
}
