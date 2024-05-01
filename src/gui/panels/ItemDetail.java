package gui.panels;

import gui.buttons.EquipButton;
import gui.buttons.SellButton;
import gui.buttons.ThrowButton;
import items.Item;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class ItemDetail extends BackGroundPanel {

	private JPanel mainPanel;
	private JButton equipButton;
	private JButton sellButton;
	private JButton throwButton;
	private JLabel itemName;
	private JTextArea itemDescription;

	public ItemDetail(Item item) {

		super(ImageManager.getInstance().getImage("itemHolder"), new Dimension(470, 135));
		add(mainPanel);
		itemName.setFont(FontManager.getInstance().getFont("Standard"));
		itemDescription.setFont(FontManager.getInstance().getFont("Standard"));
		itemName.setText(String.format("%s (%s - $%d)", item.getName(), item.getRarity(), item.getPrice()));
		itemDescription.setText(item.getDescription());
	}

	private void createUIComponents() {

		equipButton = new EquipButton();
		sellButton = new SellButton();
		throwButton = new ThrowButton();
	}
}
