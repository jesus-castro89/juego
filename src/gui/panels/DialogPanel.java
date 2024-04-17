package gui.panels;

import javax.swing.*;
import java.awt.*;

public class DialogPanel extends JPanel {

	private static DialogPanel instance;
	private JPanel backgroundPanel;
	private JTextArea dialogBox;
	private JScrollPane scrollPanel;

	public static DialogPanel getInstance() {

		if (instance == null) {
			instance = new DialogPanel();
		}
		return instance;
	}

	private DialogPanel() {

		add(backgroundPanel);
		scrollPanel.getViewport().setOpaque(false);
		scrollPanel.setOpaque(false);
		scrollPanel.setBorder(null);
		scrollPanel.getVerticalScrollBar().setOpaque(false);
		dialogBox.setOpaque(false);
		dialogBox.setLineWrap(true);
		dialogBox.setWrapStyleWord(true);
		dialogBox.setFont(new Font("Arial", Font.BOLD, 15));
		dialogBox.setForeground(Color.WHITE);
		dialogBox.setBorder(null);
		dialogBox.setBackground(null);
		dialogBox.setMargin(new Insets(10, 10, 10, 10));
		dialogBox.setEditable(false);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Image image = new ImageIcon("img/ui/panels/dialogPanel.png").getImage();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(image, 0, 0, 500, 182, null);
	}

	public JPanel getBackgroundPanel() {

		return backgroundPanel;
	}

	public JTextArea getDialogBox() {

		return dialogBox;
	}

	public JScrollPane getScrollPanel() {

		return scrollPanel;
	}
}
