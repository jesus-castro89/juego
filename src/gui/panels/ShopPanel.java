package gui.panels;

import gui.events.HandCursorListener;
import gui.ui.InventoryTabUI;
import items.ItemType;
import player.Inventory;
import player.Player;
import util.interfaces.Dimensions;

import javax.swing.*;
import java.awt.*;

public class ShopPanel extends BackGroundPanel {

	private static ShopPanel instance;
	private final Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private JTabbedPane itemDisplayPanel;
	private JPanel weaponsPanel;
	private JPanel armorsPanel;
	private JPanel backgroundPanel;

	public static ShopPanel getInstance(int tabIndex, Player player) {

		if (instance == null) {

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

	public void initComponents() {

		weaponsPanel = new ItemPanel(ItemType.WEAPON, player);
		armorsPanel = new ItemPanel(ItemType.ARMOR, player);
	}
}
