package gui_old.labels;

import items.Item;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class ItemLabel extends JPanel {

	private final Image background;
	private JPanel backgroundPanel;
	private JTextArea itemInfo;
	private JButton button1;
	private JButton button2;
	private JButton button3;


	public ItemLabel(Item item) {

		background = ImageManager.getInstance().getImage("itemHolder");
		String message = String.format("%s - %s\n", item.getName(), item.getRarity());
		message += String.format("Precio: %d", item.getPrice());
		message += String.format("\nDescripción: %s", item.getDescription());
		itemInfo.setFont(FontManager.getInstance().getFont("Player"));
		itemInfo.setText(message);
		add(backgroundPanel);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}
}
