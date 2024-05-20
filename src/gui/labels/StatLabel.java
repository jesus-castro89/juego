package gui.labels;

import gui.ui.StatLabelUI;
import util.interfaces.Dimensions;
import util.managers.FontManager;

import javax.swing.*;
import java.awt.*;

public class StatLabel extends JLabel {


	public StatLabel(String displayText, Image image) {

		Dimension size = Dimensions.STAT_LABEL_SIZE;
		setIcon(new ImageIcon(image));
		super.setText(displayText);
		setForeground(Color.BLACK);
		setFont(FontManager.getInstance().getFont("Player"));
		setIconTextGap(10);
		setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setUI(new StatLabelUI());
	}

	@Override
	public void setText(String displayText) {

		super.setText(displayText);
		repaint();
	}
}
