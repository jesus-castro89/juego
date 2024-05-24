package gui.panels;

import javax.swing.*;
import javax.swing.text.*;

public class CenteredTextPane extends JTextPane {

	public CenteredTextPane() {

		super();
		StyledDocument doc = this.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}

	public void appendText(String text, boolean newLine) {

		String currentText = this.getText();
		this.setText(newLine ? currentText + text + "\n" : currentText + text);
	}
}
