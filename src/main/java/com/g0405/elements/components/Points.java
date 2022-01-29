package com.g0405.elements.components;

import com.g0405.elements.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Points extends Components {
    private final Position position;
    private int points;
    private final String text;


    public Points(int width, int height, String text){
        super(width, height);

        this.text = text;
        points = 0;
        position = new Position(width - (text.length()+1), height);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), text + points);
    }

    public void setPoints() {
        this.points++;
    }

    public int getPoints(){
        return points;
    }
}
