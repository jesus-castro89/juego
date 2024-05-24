package gui.labels;

import gui.ui.FileLabelUI;

public class FileLabel extends RedTextLabel{
	/**
	 * Constructor de la clase
	 *
	 * @param text texto a mostrar
	 */
	public FileLabel(String text) {

		super(text);
		setUI(new FileLabelUI());
	}
}
