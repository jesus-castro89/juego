package gui.events;

import gui.panels.DialogPanel;
import player.Player;
import util.managers.FileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButtonListener implements ActionListener {

	private final Player player;
	private final int slot;

	public SaveButtonListener(Player player, int slot) {

		this.player = player;
		this.slot = slot;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Save the game
		FileManager.saveGame(slot, player);
		// Agregamos un texto al panel de diálogo para indicar que la partida se guardó correctamente
		DialogPanel.getInstance().addText("""
					------------------------------------------------
					¡Partida guardada correctamente!
					------------------------------------------------
					""");
	}
}
