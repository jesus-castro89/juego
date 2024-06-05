package gui.events;

import gui.panels.DialogPanel;
import gui.panels.InventoryPanel;
import gui.panels.PlayerPanel;
import gui.panels.StatusPanel;
import gui.windows.GameWindow;
import items.Item;
import player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyButtonListener implements ActionListener {

	private final Item item;

	public BuyButtonListener(Item item) {

		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Player player = GameWindow.getInstance().getPlayer();
		//Determinar si el jugador tiene el dinero suficiente para comprar el Item
		if (player.getGold() >= item.getPrice()) {
			//Se agrega el item a su inventario
			player.getInventory().addItem(item);
			//Reducimos su cantidad en la cantidad de compra
			player.setGold(player.getGold() - item.getPrice());
			//Mostramos un mensaje en el panel de que se compró X artículo
			DialogPanel.getInstance().addText(
					String.format("Compraste %s por %d.\n", item.getName(), item.getPrice()));
		} else {
			//Si no se cuenta en el dinero suficiente se muestra un mensaje en el panel
			DialogPanel.getInstance().addText("No tienes suficiente oro para comprar este objeto.\n");
		}
		updatePanels();
	}

	/**
	 * Método que actualiza los paneles de la interfaz gráfica.
	 */
	private void updatePanels() {

		Player player = GameWindow.getInstance().getPlayer();
		// Actualizamos los paneles
		StatusPanel.getInstance(0, player).update();
		PlayerPanel.getInstance(player).update();
		InventoryPanel.getInstance(2, player).update();
	}
}