package com.alexkaz.swingapp.ui.buttons;

import com.alexkaz.swingapp.util.Utils;

public class MouseButton extends BaseButton {

    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    private String btnType;

    public MouseButton(String btnType) {
        this.btnType = btnType;
        setSize(74,88);
        setIcon(Utils.getIconByName("m_" + btnType + ".png"));
        setPressedIcon(Utils.getIconByName("m_" + btnType + "_pressed.png"));
    }

    @Override
    public void showPressed(boolean isPressed){
        if (isPressed)setIcon(Utils.getIconByName("m_" + btnType + "_pressed.png"));
        else setIcon(Utils.getIconByName("m_" + btnType + ".png"));
    }
}
