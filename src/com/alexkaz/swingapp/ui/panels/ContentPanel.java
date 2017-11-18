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

    private java.util.List<Character> charList;
    private MouseBtnStateListener mBtnListener;

    private Image backgroundImage;

    public ContentPanel() {
        setBackground(Color.GREEN);
        charList = Utils.getRandomCharacters();
        backgroundImage = Utils.getImageByName("content_panel_bg.png");
        setMouseClickListener();
        setMouseDragListener();
    }

    private void setMouseClickListener(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3){
                    charList.forEach(character -> character.setActive(false));
                    for (Character character : charList){
                        if (isInBounds(e.getX(), e.getY(), character)){
                            character.setActive(true);
                            character.setRandomColor();
                            break;
                        }
                    }
                } else if (e.getButton() == MouseEvent.BUTTON1){
                    charList.forEach(character -> character.setActive(false));
                    for (Character character : charList){
                        if (isInBounds(e.getX(), e.getY(), character)){
                            character.setActive(true);
                            break;
                        }
                    }
                }
                repaint();
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
                    charList.forEach(character -> character.setActive(false));
                    for (Character character : charList){
                        if (isInBounds(e.getX(), e.getY(), character)){
                            character.setActive(true);
                            character.move(e.getX(), e.getY());
                            break;
                        }
                    }
                    repaint();
                }
            }
        });
    }

    @Override
    public void move(Direction direction) {
        for (Character character : charList){
            if (character.isActive()){
                character.move(direction);
                repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null)g.drawImage(backgroundImage,0,0, null);
        charList.forEach(character -> character.draw((Graphics2D) g));
    }

    public void setMouseBtnStateListener(MouseBtnStateListener mBtnListener) {
        this.mBtnListener = mBtnListener;
    }
}
