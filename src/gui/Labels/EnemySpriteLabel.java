package gui.Labels;

import gui.ui.EnemyLabelUI;
import rpg.entities.enemies.Enemy;

import javax.swing.*;
import java.awt.*;

public class EnemySpriteLabel extends JLabel {

    private ImageIcon icon;
    private Enemy enemy;

    public EnemySpriteLabel(Enemy enemy) {
        this.enemy = enemy;
        initComponents();
        setUI(new EnemyLabelUI(icon));
    }

    private void initComponents() {
        icon = enemy.getSprite();
        setPreferredSize(getMinDimension());
        setSize(getMinDimension());
        setIcon(icon);
    }

    private Dimension getMinDimension() {
        if (icon.getIconWidth() > 350 || icon.getIconHeight() > 184) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(450, 250, Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }
}
