package gui.panels;

import gui.events.HandCursorListener;
import gui.ui.InventoryTabUI;
import items.Item;
import items.ItemType;
import items.armors.head.IronHelmet;
import items.armors.head.WoodHelmet;
import items.weapons.blades.WoodBlade;
import player.Player;
import util.interfaces.Dimensions;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShopPanel extends BackGroundPanel {

	private static ShopPanel instance;
	private final Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private static ArrayList<Item> weapons;
	private static ArrayList<Item> armors;
	private JTabbedPane itemDisplayPanel;
	private JPanel weaponsPanel;
	private JPanel armorsPanel;
	private JPanel backgroundPanel;

	public static ShopPanel getInstance(int tabIndex, Player player) {

		if (instance == null) {

			weapons = new ArrayList<>();
			weapons.add(new WoodBlade());
			weapons.add(new WoodBlade());
			armors = new ArrayList<>();
			armors.add(new IronHelmet());
			armors.add(new WoodHelmet());
			instance = new ShopPanel(tabIndex, player);
		}
		return instance;
	}

	private ShopPanel(int tabIndex, Player player) {

		super();
		this.player = player;
		itemDisplayPanel.setUI(new InventoryTabUI());
		this.tabIndex = tabIndex;
		this.actionsPanel = ActionsPanel.getInstance();
		Dimension size = Dimensions.TAB_SIZE;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		add(backgroundPanel);
		setOpaque(false);
		setBackground(null);
		setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
		setName("Tienda");
		itemDisplayPanel.addMouseMotionListener(new HandCursorListener(itemDisplayPanel));
	}

	private void createUIComponents() {

		//Iniciamos los paneles con las listas de objetos
		weaponsPanel = new ItemPanel(ItemType.WEAPON, player, weapons);
		armorsPanel = new ItemPanel(ItemType.ARMOR, player, armors);
	}

	public void update() {

		((ItemPanel) weaponsPanel).initComponents(weapons);
		((ItemPanel) armorsPanel).initComponents(armors);
	}
}
