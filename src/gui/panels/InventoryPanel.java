package gui.panels;

import gui.events.HandCursorListener;
import gui.ui.InventoryTabUI;
import items.ItemType;
import player.Player;
import util.interfaces.Dimensions;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends BackGroundPanel {

	private static InventoryPanel instance;
	private final Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private JPanel backgroundPanel;
	private JTabbedPane itemDisplayPanel;
	private JPanel weaponsPanel;
	private JPanel armorsPanel;
	private JPanel miscsPanel;

	public static InventoryPanel getInstance(int tabIndex, Player player) {

		if (instance == null) {

			instance = new InventoryPanel(tabIndex, player);
		}
		return instance;
	}

	@Override
	public void update(Graphics g) {

		super.update(g);
		revalidate();
		repaint();
	}

	private InventoryPanel(int tabIndex, Player player) {

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
		setName("Inventario");
		itemDisplayPanel.addMouseMotionListener(new HandCursorListener(itemDisplayPanel));
	}

	private void createUIComponents() {

		weaponsPanel = new ItemPanel(ItemType.WEAPON, player);
		armorsPanel = new ItemPanel(ItemType.ARMOR, player);
		miscsPanel = new ItemPanel(ItemType.MISC, player);
	}

	public void update() {

		((ItemPanel) weaponsPanel).initComponents();
		((ItemPanel) armorsPanel).initComponents();
		((ItemPanel) miscsPanel).initComponents();
	}
}
