package com.alexkaz.swingapp.util;

import com.alexkaz.swingapp.Main;
import com.alexkaz.swingapp.characters.Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

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

    public static List<Character> getRandomCharacters(){
        List<Character> characters = new ArrayList<>();

        Character character = new Character("John");
        character.setActive(true);
        character.move(getRandomInt(30, 500), getRandomInt(30, 400));
        characters.add(character);

        character = new Character("Mike");
        character.move(getRandomInt(30, 500), getRandomInt(30, 400));
        characters.add(character);

        character = new Character("Hank");
        character.move(getRandomInt(30, 500), getRandomInt(30, 400));
        characters.add(character);

        character = new Character("Kurt");
        character.move(getRandomInt(30, 500), getRandomInt(30, 400));
        characters.add(character);

        return characters;
    }

    private static int getRandomInt(int low, int high){
        return rand.nextInt(high-low) + low;
    }

}
