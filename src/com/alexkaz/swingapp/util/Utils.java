package com.alexkaz.swingapp.util;

import com.alexkaz.swingapp.Main;
import com.alexkaz.swingapp.characters.Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import static com.alexkaz.swingapp.util.Config.RESOURCE_DIRECTORY;

public class Utils {

    private static Random rand = new Random();

    public static Color getRandomColor(){
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        return new Color(red, green, blue);
    }

    public static boolean isInBounds(int x, int y, Character character){
        if (x >= character.getX() && x <= character.getX() + character.getWidth()){
            if (y >= character.getY() && y <= character.getY() + character.getHeight()){
                return true;
            }
        }
        return false;
    }

    public static Icon getIconByName(String fileName){
        return new ImageIcon(Main.class.getResource(RESOURCE_DIRECTORY + fileName));
    }

    public static Image getImageByName(String fileName){
        try {
            return ImageIO.read(new File(Main.class.getResource(RESOURCE_DIRECTORY + fileName).toURI()));
        } catch (IOException | URISyntaxException e) {
            return null;
        }
    }

}
