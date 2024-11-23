package gui.Buttons;

import gui.ui.UserHoverUI;
import gui.windows.MainWindow;

public class FleeButton extends UserButton {

    public FleeButton(MainWindow game) {
        super("Huir");
        this.setUI(new UserHoverUI()); // Aplicar estilo visual
        this.setOpaque(false); // Quitar opacidad
        this.addActionListener(new FleeEvent(game)); // Asignar evento de huida
    }
}
