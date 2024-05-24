package gui.panels;

import player.Player;
import player.skills.Skill;
import util.interfaces.Dimensions;

import javax.swing.*;
import java.awt.*;

public class SkillPanel extends BackGroundPanel {


	private JPanel mainPanel;
	private JPanel skillList;
	private JScrollPane scrollPanel;

	public SkillPanel(Player player) {

		super();
		scrollPanel.getViewport().setOpaque(false);
		scrollPanel.getVerticalScrollBar().setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 6));
		add(mainPanel);
		setOpaque(false);
		initSkills(player);
	}

	private void initSkills(Player player) {

		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[]{Dimensions.SKILL_DETAIL_SIZE.width};
		layout.rowHeights = new int[]{Dimensions.SKILL_DETAIL_SIZE.height};
		skillList.setLayout(layout);
		skillList.setBorder(null);
		skillList.setOpaque(false);
		scrollPanel.setBorder(null);
		player.getSkillMap().forEach((k, v) -> addSkill(v));
	}

	private void addSkill(Skill skill) {

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = skillList.getComponentCount() % 2;
		c.gridy = skillList.getComponentCount() / 2;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1;
		c.weighty = 1;
		skillList.add(skill.getSkillDetailPanel(), c);
		skillList.revalidate();
		skillList.repaint();
	}
}
