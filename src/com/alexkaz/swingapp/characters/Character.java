package com.alexkaz.swingapp.characters;

import com.alexkaz.swingapp.util.Direction;
import com.alexkaz.swingapp.util.Utils;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.alexkaz.swingapp.util.Config.*;
import static com.alexkaz.swingapp.util.Config.SHEAR;

public class Character {

    private int width = CHARACTER_WIDTH;
    private int height = CHARACTER_HEIGHT;
    private int x = DEFAULT_CHARACTER_POSITION_X;
    private int y = DEFAULT_CHARACTER_POSITION_Y;
    private Color color = SHAPE_COLOR;
    private Map<String,Image> sprites;
    private Direction charDirection = Direction.DOWN;

    public Character() {
        sprites = new HashMap<>();

        for(Direction direction : Direction.values()){
            sprites.put(direction.name().toLowerCase(), Utils.getImageByName("char_" + direction.name().toLowerCase() + ".png"));
        }
    }

    public void move(Direction direction){
        charDirection = direction;
        if (direction.equals(Direction.UP)) y -= SHEAR;
        else if (direction.equals(Direction.DOWN)) y += SHEAR;
        else if (direction.equals(Direction.LEFT)) x -= SHEAR;
        else x += SHEAR;
    }

    public void move(int x, int y){
        this.x = x - width/2;
        this.y = y - height/2;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(x,y-18, width, 5);
        g.setColor(Color.WHITE);
        g.drawString("Mark", x+20, y);
        g.drawImage(sprites.get(charDirection.name().toLowerCase()),x,y,width,height, null);
    }

    public void setRandomColor() {
        this.color = Utils.getRandomColor();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
