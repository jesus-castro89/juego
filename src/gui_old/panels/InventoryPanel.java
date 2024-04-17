package gui_old.panels;

import gui_old.labels.ItemLabel;
import items.Item;
import player.Inventory;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class InventoryPanel extends JPanel {

	private final Image img;
	private final Inventory inventory;
	private static InventoryPanel instance;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private final ImageIcon activeIcon;
	private final ImageIcon inactiveIcon;
	private JPanel backgroundPanel;
	private JScrollPane itemsPanel;
	private JPanel itemsList;

	private InventoryPanel(ActionsPanel actionsPanel, int tabIndex, Inventory inventory) {

		ImageManager imageManager = ImageManager.getInstance();
		img = imageManager.getImage("inventoryPanel");
		this.inventory = inventory;
		this.tabIndex = tabIndex;
		this.activeIcon = new ImageIcon(imageManager.getImage("inventoryTabActive"));
		this.inactiveIcon = new ImageIcon(imageManager.getImage("inventoryTabInactive"));
		this.actionsPanel = actionsPanel;
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
				initLabels();
			}

			@Override
			public void componentHidden(ComponentEvent e) {

				actionsPanel.setTabIcon(tabIndex, inactiveIcon);
			}
		});
	}

	public void initLabels() {

		itemsList.removeAll();
		if (inventory.getItems().isEmpty()) {

			itemsList.add(new JLabel("No hay items en el inventario"));
			itemsList.setFont(FontManager.getInstance().getFont("Player"));
		} else {
			for (Item item : inventory.getItems()) {

				itemsList.add(new ItemLabel(item));
			}
		}
		itemsList.revalidate();
		itemsList.repaint();
	}

	public static InventoryPanel getInstance(ActionsPanel actionsPanel, int tabIndex, Inventory inventory) {

		if (instance == null) {
			instance = new InventoryPanel(actionsPanel, tabIndex, inventory);
		}
		return instance;
	}

	public void update() {

		initLabels();
	}

	private boolean isActive() {

		return actionsPanel.getSelectedIndex() == tabIndex;
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

	private void createUIComponents() {

		backgroundPanel = new JPanel();
		backgroundPanel.setOpaque(false);
		backgroundPanel.setBackground(null);
		backgroundPanel.setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
		itemsList = new JPanel();
		Dimension size = new Dimension(1239, 278);
		itemsList.setSize(size);
		itemsList.setPreferredSize(size);
		itemsList.setMaximumSize(size);
		itemsList.setMinimumSize(size);
		itemsPanel = new JScrollPane();
		itemsPanel.setBackground(null);
		itemsPanel.setBorder(null);
		itemsPanel.setOpaque(false);
		itemsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		itemsPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		itemsPanel.setViewportView(itemsList);
		itemsPanel.getViewport().setOpaque(false);
	}
}
