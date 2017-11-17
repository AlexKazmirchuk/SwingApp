package com.alexkaz.swingapp.ui.panels;

import com.alexkaz.swingapp.util.Direction;
import com.alexkaz.swingapp.interfaces.MouseBtnStateListener;
import com.alexkaz.swingapp.interfaces.Moveable;
import com.alexkaz.swingapp.util.Utils;
import com.alexkaz.swingapp.ui.buttons.DirectionButton;
import com.alexkaz.swingapp.ui.buttons.MouseButton;

import javax.swing.*;
import java.awt.*;

import static com.alexkaz.swingapp.util.Config.*;

public class ControlPanel extends JPanel implements MouseBtnStateListener {

    private DirectionButton up = new DirectionButton(Direction.UP);
    private DirectionButton down = new DirectionButton(Direction.DOWN);
    private DirectionButton left = new DirectionButton(Direction.LEFT);
    private DirectionButton right = new DirectionButton(Direction.RIGHT);

    private MouseButton leftMBtn = new MouseButton(MouseButton.LEFT);
    private MouseButton rightMBtn = new MouseButton(MouseButton.RIGHT);

    private Image backgroundImage;

    public ControlPanel(Moveable moveable) {
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(getWidth(), CONTROL_PANEL_HEIGHT));
        setLayout(null);

        backgroundImage = Utils.getImageByName(CONTROL_PANEL_BG);

        up.setLocation(DIRECTION_BUTTONS_POSITION_X+60,DIRECTION_BUTTONS_POSITION_Y);
        down.setLocation(DIRECTION_BUTTONS_POSITION_X + 60, DIRECTION_BUTTONS_POSITION_Y + 60);
        left.setLocation(DIRECTION_BUTTONS_POSITION_X, DIRECTION_BUTTONS_POSITION_Y + 60);
        right.setLocation(DIRECTION_BUTTONS_POSITION_X + 120, DIRECTION_BUTTONS_POSITION_Y + 60);

        leftMBtn.setLocation(MOUSE_BUTTONS_POSITION_X + 33,MOUSE_BUTTONS_POSITION_Y + 2);
        rightMBtn.setLocation(MOUSE_BUTTONS_POSITION_X + 66, MOUSE_BUTTONS_POSITION_Y + 3);

        up.addActionListener(e -> moveable.move(Direction.UP));
        down.addActionListener(e -> moveable.move(Direction.DOWN));
        left.addActionListener(e -> moveable.move(Direction.LEFT));
        right.addActionListener(e -> moveable.move(Direction.RIGHT));

        add(up);
        add(down);
        add(left);
        add(right);
        add(leftMBtn);
        add(rightMBtn);
    }

    public void showBtnPressed(Direction direction, boolean isPressed){
        if (Direction.UP.equals(direction)) up.showPressed(isPressed);
        else if (Direction.DOWN.equals(direction)) down.showPressed(isPressed);
        else if (Direction.LEFT.equals(direction)) left.showPressed(isPressed);
        else right.showPressed(isPressed);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null){
            g.drawImage(backgroundImage,0,0, null);
        }
    }

    @Override
    public void mouseBtnStateChanged(String btnType, boolean isPressed) {
        if (MouseButton.LEFT.equals(btnType)) leftMBtn.showPressed(isPressed);
        else if (MouseButton.RIGHT.equals(btnType)) rightMBtn.showPressed(isPressed);
    }
}
