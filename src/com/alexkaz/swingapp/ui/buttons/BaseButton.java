package com.alexkaz.swingapp.ui.buttons;

import javax.swing.*;

public abstract class BaseButton extends JButton {

    public BaseButton() {
        setFocusable(false);
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
    }

    public abstract void showPressed(boolean isPressed);
}
