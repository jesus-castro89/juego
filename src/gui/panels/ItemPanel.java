package gui.panels;

import items.Item;
import items.ItemType;
import player.Inventory;
import player.Player;
import util.interfaces.Dimensions;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class ItemPanel extends BackGroundPanel {

	protected JPanel mainPanel;
	protected JScrollPane scrollPanel;
	protected JPanel displayPanel;
	private final ItemType type;
	private final Player player;

	public ItemPanel(ItemType type, Player player) {

		super();
		mainPanel.setPreferredSize(getPreferredSize());
		this.player = player;
		this.type = type;
		add(mainPanel);
		initComponents();
	}

	public ItemPanel(ItemType type, Player player, List<Item> items) {

		super();
		mainPanel.setPreferredSize(getPreferredSize());
		this.player = player;
		this.type = type;
		add(mainPanel);
		initComponents(items);
	}

	public void initComponents(List<Item> items){

		setLayouts();
		items.forEach(this::addItem);
		// Colocamos el scroll en la parte superior
		scrollPanel.getViewport().setViewPosition(new Point(0, 0));
	}

	public void initComponents() {

		setLayouts();
		Inventory inventory = player.getInventory();
		switch (type) {
			case WEAPON:
				inventory.getItems().filterWeapons().forEach(this::addItem);
				break;
			case ARMOR:
				inventory.getItems().filterArmors().forEach(this::addItem);
				break;
			case MISC:
				inventory.getItems().filterMiscItems().forEach(this::addItem);
				break;
		}
		// Colocamos el scroll en la parte superior
		scrollPanel.getViewport().setViewPosition(new Point(0, 0));
	}

	private void setLayouts() {

		GridBagLayout layout = new GridBagLayout();
		setBorder(BorderFactory.createEmptyBorder(6, 8, 8, 8));
		layout.columnWidths = new int[]{Dimensions.ITEM_DETAIL_SIZE.width};
		layout.rowHeights = new int[]{Dimensions.ITEM_DETAIL_SIZE.height};
		displayPanel.removeAll();
		displayPanel.setLayout(layout);
		displayPanel.setOpaque(false);
		scrollPanel.setOpaque(false);
		scrollPanel.setBorder(BorderFactory.createEmptyBorder());
		scrollPanel.getViewport().setOpaque(false);
		scrollPanel.getVerticalScrollBar().setOpaque(false);
		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}

	protected void addShopItem(Item item) {

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = displayPanel.getComponentCount() % 3;
		c.gridy = displayPanel.getComponentCount() / 3;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1;
		c.weighty = 1;
		displayPanel.add(new ShopItemDetail(item), c);
		displayPanel.revalidate();
		displayPanel.repaint();
	}

	protected void addItem(Item item) {

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = displayPanel.getComponentCount() % 3;
		c.gridy = displayPanel.getComponentCount() / 3;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1;
		c.weighty = 1;
		displayPanel.add(new ItemDetail(item), c);
		displayPanel.revalidate();
		displayPanel.repaint();
	}
}
