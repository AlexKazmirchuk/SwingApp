package com.alexkaz.swingapp.ui.panels;

import com.alexkaz.swingapp.characters.Character;
import com.alexkaz.swingapp.interfaces.MouseBtnStateListener;
import com.alexkaz.swingapp.interfaces.Moveable;
import com.alexkaz.swingapp.ui.buttons.MouseButton;
import com.alexkaz.swingapp.util.Direction;
import com.alexkaz.swingapp.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.alexkaz.swingapp.util.Utils.isInBounds;

public class ContentPanel extends JPanel implements Moveable {

    private Character character;
    private MouseBtnStateListener mBtnListener;

    private Image backgroundImage;

    public ContentPanel() {
        setBackground(Color.GREEN);
        character = new Character();
        backgroundImage = Utils.getImageByName("content_panel_bg.png");
        setMouseClickListener();
        setMouseDragListener();
    }

    private void setMouseClickListener(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3){
                    if (isInBounds(e.getX(), e.getY(), character)){
                        character.setRandomColor();
                        repaint();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (mBtnListener != null){
                    if (e.getButton() == MouseEvent.BUTTON1) mBtnListener.mouseBtnStateChanged(MouseButton.LEFT, true);
                    else if (e.getButton() == MouseEvent.BUTTON3) mBtnListener.mouseBtnStateChanged(MouseButton.RIGHT, true);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (mBtnListener != null){
                    if (e.getButton() == MouseEvent.BUTTON1) mBtnListener.mouseBtnStateChanged(MouseButton.LEFT, false);
                    else if (e.getButton() == MouseEvent.BUTTON3) mBtnListener.mouseBtnStateChanged(MouseButton.RIGHT, false);
                }
            }
        });
    }

    private void setMouseDragListener(){
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.getModifiers() == MouseEvent.BUTTON1_MASK){
                    if (isInBounds(e.getX(), e.getY(), character)){
                        character.move(e.getX(), e.getY());
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    public void move(Direction direction) {
        character.move(direction);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null){
            g.drawImage(backgroundImage,0,0, null);
        }
        character.draw((Graphics2D) g);
    }

    public void setMouseBtnStateListener(MouseBtnStateListener mBtnListener) {
        this.mBtnListener = mBtnListener;
    }
}
