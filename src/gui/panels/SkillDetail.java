package gui.panels;

import gui.buttons.SkillButton;
import player.skills.Skill;
import util.managers.FontManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SkillDetail extends BackGroundPanel {


	private JLabel skillNameLabel;
	private JLabel manaCostLabel;
	private JLabel skillDetailLabel;
	private JButton useSkillButton;
	private JPanel mainPanel;
	private final Skill skill;

	public SkillDetail(Skill skill) {

		super();
		this.skill = skill;
		mainPanel.setPreferredSize(getPreferredSize());
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(mainPanel);
		skillNameLabel.setText(skill.getName());
		skillNameLabel.setFont(FontManager.getInstance().getFont("Player"));
		manaCostLabel.setText(String.format("(MP: %d)", skill.getManaCost()));
		manaCostLabel.setFont(FontManager.getInstance().getFont("Player"));
		manaCostLabel.setForeground(Color.BLUE);
		skillDetailLabel.setText(skill.getDescription());
		skillDetailLabel.setFont(FontManager.getInstance().getFont("Player"));
	}

	private void createUIComponents() {

		useSkillButton = new SkillButton(skill, skill.getPlayer(), skill.getEnemy());
	}

	public JButton getUseSkillButton() {

		return useSkillButton;
	}
}
