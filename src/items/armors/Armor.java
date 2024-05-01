package items.armors;

import items.Item;
import items.ItemType;
import player.Player;
import player.Stats;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Armor extends Item implements Serializable {

	protected HashMap<Stats, Integer> stats = new HashMap<>();
	protected ArmorType armorType;

	public Armor(String name, String description, int price) {

		super(name, description, price);
		initStats();
		type = ItemType.ARMOR;
	}

	public abstract String effect();

	protected abstract void initStats();

	public abstract void callEffect(Player player);

	public HashMap<Stats, Integer> getStats() {

		return stats;
	}

	public void setStats(HashMap<Stats, Integer> stats) {

		this.stats = stats;
	}

	public ArmorType getArmorType() {

		return armorType;
	}

	public void setArmorType(ArmorType armorType) {

		this.armorType = armorType;
	}
}
