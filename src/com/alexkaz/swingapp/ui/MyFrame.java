package com.alexkaz.swingapp.ui;

import com.alexkaz.swingapp.util.Direction;
import com.alexkaz.swingapp.ui.panels.ContentPanel;
import com.alexkaz.swingapp.ui.panels.ControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.alexkaz.swingapp.util.Config.WINDOW_HEIGHT;
import static com.alexkaz.swingapp.util.Config.WINDOW_TITLE;
import static com.alexkaz.swingapp.util.Config.WINDOW_WIDTH;
import static java.awt.event.KeyEvent.*;

public class MyFrame extends JFrame{

    private ContentPanel contentPanel;
    private ControlPanel controlPanel;

    public MyFrame() {
        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        contentPanel = new ContentPanel();
        controlPanel = new ControlPanel(contentPanel);
        contentPanel.setMouseBtnStateListener(controlPanel);

        add(contentPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == VK_UP) {
                    contentPanel.move(Direction.UP);
                    controlPanel.showBtnPressed(Direction.UP, true);
                } else if (e.getKeyCode() == VK_DOWN){
                    contentPanel.move(Direction.DOWN);
                    controlPanel.showBtnPressed(Direction.DOWN, true);
                } else if (e.getKeyCode() == VK_LEFT){
                    contentPanel.move(Direction.LEFT);
                    controlPanel.showBtnPressed(Direction.LEFT, true);
                } else if (e.getKeyCode() == VK_RIGHT){
                    contentPanel.move(Direction.RIGHT);
                    controlPanel.showBtnPressed(Direction.RIGHT, true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if      (e.getKeyCode() == VK_UP)    controlPanel.showBtnPressed(Direction.UP, false);
                else if (e.getKeyCode() == VK_DOWN)  controlPanel.showBtnPressed(Direction.DOWN, false);
                else if (e.getKeyCode() == VK_LEFT)  controlPanel.showBtnPressed(Direction.LEFT, false);
                else if (e.getKeyCode() == VK_RIGHT) controlPanel.showBtnPressed(Direction.RIGHT, false);
            }
        });
    }

}
