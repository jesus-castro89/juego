package util.managers;

import util.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class ImageManager {

	private static ImageManager instance;

	private final ImageCache imageCache;

	private ImageManager() {

		imageCache = ImageCache.getInstance();
		initImages();
	}

	private void initImages() {

		addPanels();
		addHolders();
		addTabs();
		addPlayerElements();
		addButtons();
		//Characters
		imageCache.addImage("portrait",
				new ImageIcon("img/player/portrait.png").getImage());
	}

	private void addButtons() {
		//Buttons
		imageCache.addImage("button",
				new ImageIcon("img/ui/buttons/idleButton.png").getImage());
		imageCache.addImage("buttonHover",
				new ImageIcon("img/ui/buttons/hoverButton.png").getImage());
	}

	private void addPlayerElements() {
		//Player Elements
		imageCache.addImage("mp100", new ImageIcon("img/player/mp100.png").getImage());
		imageCache.addImage("mp80", new ImageIcon("img/player/mp80.png").getImage());
		imageCache.addImage("mp60", new ImageIcon("img/player/mp60.png").getImage());
		imageCache.addImage("mp40", new ImageIcon("img/player/mp40.png").getImage());
		imageCache.addImage("mp20", new ImageIcon("img/player/mp20.png").getImage());
		imageCache.addImage("mp0", new ImageIcon("img/player/mp0.png").getImage());
		imageCache.addImage("hp100", new ImageIcon("img/player/hp100.png").getImage());
		imageCache.addImage("hp80", new ImageIcon("img/player/hp80.png").getImage());
		imageCache.addImage("hp60", new ImageIcon("img/player/hp60.png").getImage());
		imageCache.addImage("hp40", new ImageIcon("img/player/hp40.png").getImage());
		imageCache.addImage("hp20", new ImageIcon("img/player/hp20.png").getImage());
		imageCache.addImage("hp0", new ImageIcon("img/player/hp0.png").getImage());
	}

	private void addTabs() {
		//Tabs
		imageCache.addImage("activeTab",
				new ImageIcon("img/ui/tabs/activeTab.png").getImage());
		imageCache.addImage("inactiveTab",
				new ImageIcon("img/ui/tabs/inactiveTab.png").getImage());
		imageCache.addImage("armorTab",
				new ImageIcon("img/ui/tabs/armorTabActive.png").getImage());
		imageCache.addImage("weaponTab",
				new ImageIcon("img/ui/tabs/weaponTabActive.png").getImage());
		imageCache.addImage("miscTab",
				new ImageIcon("img/ui/tabs/miscTabActive.png").getImage());
		imageCache.addImage("armorTabInactive",
				new ImageIcon("img/ui/tabs/armorTabInactive.png").getImage());
		imageCache.addImage("weaponTabInactive",
				new ImageIcon("img/ui/tabs/weaponTabInactive.png").getImage());
		imageCache.addImage("miscTabInactive",
				new ImageIcon("img/ui/tabs/miscTabInactive.png").getImage());
	}

	private void addHolders() {
		//Holders
		imageCache.addImage("statHolder",
				new ImageIcon("img/ui/holders/statHolder.png").getImage());
		imageCache.addImage("attackIcon",
				new ImageIcon("img/ui/holders/attackIcon.png").getImage());
		imageCache.addImage("expIcon",
				new ImageIcon("img/ui/holders/expIcon.png").getImage());
		imageCache.addImage("attackIcon",
				new ImageIcon("img/ui/holders/attackIcon.png").getImage());
		imageCache.addImage("defenseIcon",
				new ImageIcon("img/ui/holders/defenseIcon.png").getImage());
		imageCache.addImage("goldIcon",
				new ImageIcon("img/ui/holders/goldIcon.png").getImage());
		imageCache.addImage("dexterityIcon",
				new ImageIcon("img/ui/holders/dexterityIcon.png").getImage());
		imageCache.addImage("intelligenceIcon",
				new ImageIcon("img/ui/holders/intIcon.png").getImage());
		imageCache.addImage("luckIcon",
				new ImageIcon("img/ui/holders/lukIcon.png").getImage());
		imageCache.addImage("headArmorIcon",
				new ImageIcon("img/ui/holders/headArmorIcon.png").getImage());
		imageCache.addImage("chestArmorIcon",
				new ImageIcon("img/ui/holders/chestArmorIcon.png").getImage());
		imageCache.addImage("legArmorIcon",
				new ImageIcon("img/ui/holders/legArmorIcon.png").getImage());
		imageCache.addImage("feetArmorIcon",
				new ImageIcon("img/ui/holders/feetArmorIcon.png").getImage());
		imageCache.addImage("handArmorIcon",
				new ImageIcon("img/ui/holders/handArmorIcon.png").getImage());
		imageCache.addImage("resIcon",
				new ImageIcon("img/ui/holders/resIcon.png").getImage());
		imageCache.addImage("velIcon",
				new ImageIcon("img/ui/holders/velIcon.png").getImage());
		imageCache.addImage("weaponIcon",
				new ImageIcon("img/ui/holders/weaponIcon.png").getImage());
		imageCache.addImage("textHolder",
				new ImageIcon("img/ui/holders/textHolder.png").getImage());
		imageCache.addImage("equipHolder",
				new ImageIcon("img/ui/holders/equipHolder.png").getImage());
		imageCache.addImage("itemHolder",
				new ImageIcon("img/ui/holders/itemHolder.png").getImage());
	}

	private void addPanels() {
		//Paneles
		imageCache.addImage("statusPanel",
				new ImageIcon("img/ui/panels/statusPanel.png").getImage());
		imageCache.addImage("playerPanel",
				new ImageIcon("img/ui/panels/playerPanel.png").getImage());
		imageCache.addImage("enemyPanel",
				new ImageIcon("img/ui/panels/enemyPanel.png").getImage());
		imageCache.addImage("battlePanel",
				new ImageIcon("img/ui/panels/battlePanel.png").getImage());
		imageCache.addImage("charactersPanel",
				new ImageIcon("img/ui/panels/charactersPanel.png").getImage());
		imageCache.addImage("skillPanel",
				new ImageIcon("img/ui/panels/skillPanel.png").getImage());
		imageCache.addImage("dialogPanel",
				new ImageIcon("img/ui/panels/dialogPanel.png").getImage());
		imageCache.addImage("skillDetailPanel",
				new ImageIcon("img/ui/panels/skillDetailPanel.png").getImage());
		imageCache.addImage("inventoryPanel",
				new ImageIcon("img/ui/panels/inventoryPanel.png").getImage());
		imageCache.addImage("shopPanel",
				new ImageIcon("img/ui/panels/shopPanel.png").getImage());
	}

	public static ImageManager getInstance() {

		if (instance == null) {
			instance = new ImageManager();
		}
		return instance;
	}

	public Image getImage(String imageName) {

		return imageCache.getImage(imageName);
	}

	public Image getImage(String imageName, Image image) {

		if (imageCache.getImage(imageName) == null) {
			imageCache.addImage(imageName, image);
			return image;
		} else
			return imageCache.getImage(imageName);
	}
}
