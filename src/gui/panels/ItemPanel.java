package gui.panels;

import items.Item;
import items.ItemType;
import player.Inventory;
import player.Player;

import javax.swing.*;
import java.awt.*;

public class ItemPanel extends BackGroundPanel {

	protected JPanel mainPanel;
	protected JScrollPane scrollPanel;
	protected JPanel displayPanel;
	private final ItemType type;
	private final Player player;

	public ItemPanel(ItemType type, Player player) {

		super();
		this.player = player;
		this.type = type;
		add(mainPanel);
		initComponents();
	}

	public void initComponents() {

		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[]{400, 400, 400};
		displayPanel.removeAll();
		displayPanel.setLayout(layout);
		displayPanel.setOpaque(false);
		displayPanel.setBorder(BorderFactory.createEmptyBorder());
		scrollPanel.setBorder(BorderFactory.createEmptyBorder());
		scrollPanel.setOpaque(false);
		scrollPanel.getViewport().setOpaque(false);
		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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

	protected void addItem(Item item) {

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = displayPanel.getComponentCount() % 3;
		c.gridy = displayPanel.getComponentCount() / 3;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 0, 5, 0);
		displayPanel.add(new ItemDetail(item), c);
		displayPanel.revalidate();
		displayPanel.repaint();
	}
}
