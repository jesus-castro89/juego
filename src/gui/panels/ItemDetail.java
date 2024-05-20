package gui.panels;

import gui.buttons.EquipButton;
import gui.buttons.SellButton;
import gui.buttons.ThrowButton;
import items.Item;
import util.interfaces.Dimensions;
import util.managers.FontManager;

import javax.swing.*;
import java.awt.*;

public class ItemDetail extends BackGroundPanel {

	private JPanel mainPanel;
	private JButton equipButton;
	private JButton sellButton;
	private JButton throwButton;
	private JLabel itemName;
	private JTextArea itemDescription;
	private final Item item;

	public ItemDetail(Item item) {

		super();
		this.item = item;
		Dimension size = Dimensions.ITEM_DETAIL_SIZE;
		mainPanel.setSize(size);
		mainPanel.setPreferredSize(size);
		mainPanel.setMinimumSize(size);
		mainPanel.setMaximumSize(size);
		add(mainPanel);
		itemName.setFont(FontManager.getInstance().getFont("Standard"));
		itemDescription.setFont(FontManager.getInstance().getFont("Standard"));
		itemDescription.setText(item.getDescription());
		switch (item.getType()) {
			case WEAPON, ARMOR -> {
				itemName.setText(String.format("%s (%s - $%d)", item.getName(), item.getRarity(), item.getPrice()));
				equipButton.setVisible(true);
				sellButton.setVisible(true);
				throwButton.setVisible(false);
			}
			case MISC -> {
				itemName.setText(String.format("%s ($%d)", item.getName(), item.getPrice()));
				equipButton.setVisible(false);
				sellButton.setVisible(true);
				throwButton.setVisible(true);
			}
		}
	}

	private void createUIComponents() {

		equipButton = new EquipButton(item);
		sellButton = new SellButton(item);
		throwButton = new ThrowButton(item);
	}
}
