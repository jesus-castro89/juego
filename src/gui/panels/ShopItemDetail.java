package gui.panels;

import gui.buttons.BuyButton;
import items.Item;
import util.managers.FontManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ShopItemDetail extends BackGroundPanel {

	private final Item item;
	private JTextPane itemDescription;
	private JButton buyButton;
	private JPanel mainPanel;

	public ShopItemDetail(Item item) {

		super();
		this.item = item;
		add(mainPanel);
		mainPanel.setPreferredSize(getPreferredSize());
		mainPanel.setMaximumSize(getPreferredSize());
		mainPanel.setMinimumSize(getPreferredSize());
		mainPanel.setBorder(new EmptyBorder(12, 15, 12, 15));
		//mainPanel.setBorder(new LineBorder(Color.BLACK, 5));
		itemDescription.setFont(FontManager.getInstance().getFont("Player"));
		String description;
		description = String.format("%s (%s - $%d)", item.getName(), item.getRarity(), item.getPrice());
		((CenteredTextPane) itemDescription).appendText(description, true);
		((CenteredTextPane) itemDescription).appendText(item.getDescription(), false);
	}

	private void createUIComponents() {

		buyButton = new BuyButton(item);
		itemDescription = new CenteredTextPane();
	}
}
