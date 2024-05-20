package gui.panels;

import util.interfaces.Dimensions;
import util.managers.FontManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DialogPanel extends BackGroundPanel {

	private static DialogPanel instance;
	private JPanel mainPanel;
	private JTextArea dialogBox;
	private JScrollPane scrollPanel;

	public static DialogPanel getInstance() {

		if (instance == null) {

			instance = new DialogPanel(
			);
		}
		return instance;
	}

	private DialogPanel() {

		super();
		add(mainPanel);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(3, 10, 0, 10));
		scrollPanel.getViewport().setOpaque(false);
		scrollPanel.setOpaque(false);
		scrollPanel.setBorder(null);
		scrollPanel.getVerticalScrollBar().setOpaque(false);
		scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.setSize(Dimensions.DIALOG_SCROLL_SIZE);
		scrollPanel.setPreferredSize(Dimensions.DIALOG_SCROLL_SIZE);
		scrollPanel.setMaximumSize(Dimensions.DIALOG_SCROLL_SIZE);
		scrollPanel.setMinimumSize(Dimensions.DIALOG_SCROLL_SIZE);
		dialogBox.setOpaque(false);
		dialogBox.setLineWrap(true);
		dialogBox.setWrapStyleWord(true);
		dialogBox.setFont(FontManager.getInstance().getFont("Depixel"));
		dialogBox.setForeground(Color.WHITE);
		dialogBox.setBorder(null);
		dialogBox.setBackground(null);
		dialogBox.setMargin(new Insets(10, 10, 10, 10));
		dialogBox.setEditable(false);
		dialogBox.setAutoscrolls(true);
		scrollPanel.setAutoscrolls(true);
	}

	public void addText(String text) {

		SwingUtilities.invokeLater(() -> {
			dialogBox.append(text);
			dialogBox.setCaretPosition(dialogBox.getDocument().getLength());
		});
	}

	public JPanel getBackgroundPanel() {

		return mainPanel;
	}
}
