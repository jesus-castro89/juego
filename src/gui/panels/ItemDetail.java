package gui.panels;

import gui.buttons.EquipButton;
import gui.buttons.SellButton;
import gui.buttons.ThrowButton;
import items.Item;
import util.interfaces.Dimensions;
import util.managers.FontManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ItemDetail extends BackGroundPanel {

	private JPanel mainPanel;
	private JButton equipButton;
	private JButton sellButton;
	private JButton throwButton;
	private JTextPane itemDescription;
	private final Item item;

	public ItemDetail(Item item) {

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
		switch (item.getType()) {
			case WEAPON, ARMOR -> {

				description = String.format("%s (%s - $%d)", item.getName(), item.getRarity(), item.getPrice());
				((CenteredTextPane) itemDescription).appendText(description, true);
				equipButton.setVisible(true);
				sellButton.setVisible(true);
				throwButton.setVisible(false);
			}
			case MISC -> {

				description = String.format("%s (%s)", item.getName(), item.getRarity());
				((CenteredTextPane) itemDescription).appendText(description, true);
				equipButton.setVisible(false);
				sellButton.setVisible(true);
				throwButton.setVisible(true);
			}
		}
		((CenteredTextPane) itemDescription).appendText(item.getDescription(), false);
	}

	private void createUIComponents() {

		equipButton = new EquipButton(item);
		sellButton = new SellButton(item);
		throwButton = new ThrowButton(item);
		itemDescription = new CenteredTextPane();
	}
}
