package gui.labels;

import gui.ui.EquipLabelUI;
import util.interfaces.Dimensions;

import java.awt.*;

public class EquipLabel extends StatLabel{
	public EquipLabel(String displayText, Image image) {

		super(displayText, image);
		Dimension size = Dimensions.EQUIP_LABEL_SIZE;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setUI(new EquipLabelUI());
	}
}
