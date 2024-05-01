package player;

import gui.panels.DialogPanel;
import items.Item;
import items.armors.Armor;
import items.weapons.Weapon;
import util.FixedArrayList;
import util.interfaces.Interactive;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

/**
 * Inventory es una clase que representa el inventario del jugador.
 *
 * @version 1.0
 */
public class Inventory implements Serializable {

	/**
	 * La lista de elementos en el inventario.
	 */
	private final FixedArrayList<Item> items;

	/**
	 * Construye un nuevo inventario con una capacidad fija de 15.
	 */
	public Inventory() {

		items = new FixedArrayList<>(15);
	}

	/**
	 * Agrega un elemento al inventario.
	 *
	 * @param item el elemento a agregar
	 */
	public void addItem(Item item) {

		String addMessage = String.format("%s se ha agregado al Inventario!\n", item.getName());
		DialogPanel.getInstance().addText(items.add(item) ? addMessage : "Inventario Lleno.\n");
	}

	/**
	 * Remueve un elemento del inventario.
	 *
	 * @param item el elemento a remover
	 */
	public void removeItem(Item item) {

		items.remove(item);
	}

	/**
	 * Obtiene la lista de elementos en el inventario.
	 *
	 * @return la lista de elementos en el inventario
	 */
	public FixedArrayList<Item> getItems() {

		return items;
	}
}
