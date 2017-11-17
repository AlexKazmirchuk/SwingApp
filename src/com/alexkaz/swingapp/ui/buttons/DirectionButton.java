package com.alexkaz.swingapp.ui.buttons;

import com.alexkaz.swingapp.util.Direction;
import com.alexkaz.swingapp.util.Utils;

import javax.swing.*;

public class DirectionButton extends BaseButton{

    private Direction direction;

    public DirectionButton(Direction dir) {
        this.direction = dir;
        setSize(85,85);
        setIcon(Utils.getIconByName("btn_" + dir.toString().toLowerCase() + ".png"));
        setPressedIcon(Utils.getIconByName("btn_" + dir.toString().toLowerCase() + "_pressed.png"));
    }

    @Override
    public void showPressed(boolean isPressed){
        if (isPressed) setIcon(Utils.getIconByName("btn_" + direction.toString().toLowerCase() + "_pressed.png"));
        else setIcon(Utils.getIconByName("btn_" + direction.toString().toLowerCase() + ".png"));
    }
}
