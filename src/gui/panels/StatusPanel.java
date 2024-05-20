package gui.panels;

import gui.labels.EquipLabel;
import player.Player;
import gui.labels.StatLabel;
import util.interfaces.Dimensions;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends BackGroundPanel {

	private static StatusPanel instance;
	private final Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
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

	public static StatusPanel getInstance(int tabIndex, Player player) {

		if (instance == null) {

			instance = new StatusPanel(tabIndex, player);
		}
		return instance;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param tabIndex índice de la pestaña
	 * @param player   jugador
	 */
	private StatusPanel(int tabIndex, Player player) {

		super();
		this.player = player;
		this.tabIndex = tabIndex;
		this.actionsPanel = ActionsPanel.getInstance();
		Dimension size = Dimensions.TAB_SIZE;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		backgroundPanel.setSize(size);
		backgroundPanel.setPreferredSize(size);
		backgroundPanel.setMinimumSize(size);
		backgroundPanel.setMaximumSize(size);
		add(backgroundPanel);
		setOpaque(false);
		setBackground(null);
		setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
		setName("Estado");
		update();
	}

	public void update() {

		levelLabel.setText("EXP: " + player.getExperience());
		attackLabel.setText(player.getDisplayAttack());
		defenseLabel.setText(player.getDisplayDefense());
		goldLabel.setText("ORO: " + player.getGold());
		intLabel.setText(player.getDisplayIntelligence());
		resLabel.setText(player.getDisplayResistance());
		luckLabel.setText(player.getDisplayLuck());
		desLabel.setText(player.getDisplayDexterity());
		speedLabel.setText(player.getDisplaySpeed());
		weaponLabel.setText(player.getWeapon() != null ? player.getWeapon().getName() : "No equipado");
		headArmorLabel.setText(player.getHeadArmor() != null ? player.getHeadArmor().getName() : "No equipado");
		chestArmorLabel.setText(player.getChestArmor() != null ? player.getChestArmor().getName() : "No equipado");
		feetArmorLabel.setText(player.getFootArmor() != null ? player.getFootArmor().getName() : "No equipado");
		legArmorLabel.setText(player.getLegArmor() != null ? player.getLegArmor().getName() : "No equipado");
		handArmorLabel.setText(player.getHandArmor() != null ? player.getHandArmor().getName() : "No equipado");
		repaint();
	}

	private void createUIComponents() {

		ImageManager imageManager = ImageManager.getInstance();
		levelLabel = new StatLabel("EXP: " + player.getExperience(),
				imageManager.getImage("expIcon"));
		attackLabel = new StatLabel(player.getDisplayAttack(),
				imageManager.getImage("attackIcon"));
		defenseLabel = new StatLabel(player.getDisplayDefense(),
				imageManager.getImage("defenseIcon"));
		goldLabel = new StatLabel("ORO: " + player.getGold(),
				imageManager.getImage("goldIcon"));
		intLabel = new StatLabel(player.getDisplayIntelligence(),
				imageManager.getImage("intelligenceIcon"));
		resLabel = new StatLabel(player.getDisplayResistance(),
				imageManager.getImage("resIcon"));
		luckLabel = new StatLabel(player.getDisplayLuck(),
				imageManager.getImage("luckIcon"));
		desLabel = new StatLabel(player.getDisplayDexterity(),
				imageManager.getImage("dexterityIcon"));
		speedLabel = new StatLabel(player.getDisplaySpeed(),
				imageManager.getImage("velIcon"));
		weaponLabel = new EquipLabel(player.getWeapon() != null ? player.getWeapon().getName() : "No equipado",
				imageManager.getImage("weaponIcon"));
		headArmorLabel = new EquipLabel(player.getHeadArmor() != null ? player.getHeadArmor().getName() : "No equipado",
				imageManager.getImage("headArmorIcon"));
		chestArmorLabel = new EquipLabel(player.getChestArmor() != null ? player.getChestArmor().getName() : "No equipado",
				imageManager.getImage("chestArmorIcon"));
		feetArmorLabel = new EquipLabel(player.getFootArmor() != null ? player.getFootArmor().getName() : "No equipado",
				imageManager.getImage("feetArmorIcon"));
		legArmorLabel = new EquipLabel(player.getLegArmor() != null ? player.getLegArmor().getName() : "No equipado",
				imageManager.getImage("legArmorIcon"));
		handArmorLabel = new EquipLabel(player.getHandArmor() != null ? player.getHandArmor().getName() : "No equipado",
				imageManager.getImage("handArmorIcon"));
	}
}
