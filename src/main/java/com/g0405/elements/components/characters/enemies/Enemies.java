package com.g0405.elements.components.characters.enemies;

import com.g0405.elements.components.Components;
import com.g0405.elements.components.characters.Characters;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g0405.elements.Position;

import java.util.Random;

public abstract class Enemies extends Components implements Characters {
    private int state;
    private final Position position;
    private String icon;
    private final char type;

    public Enemies(int x, int y, String icon, char type) {
        super(x, y);
        this.position = super.getPosition();
        this.state = new Random().nextInt(2);
        this.icon = icon;
        this.type = type;
    }

    public void setState(int state){
        if(state == 0 || state == 1)
            this.state=state;
    }

    public int getState(){
        return state;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#6577B3"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), icon);
    }

    public void move() {
        switch (state) {
            case 0:
                setPosition(position.moveRight());
                if(type == 'P') setIcon("p");
                else setIcon("m");
                break;

            case 1:
                setPosition(position.moveLeft());
                if(type == 'P') setIcon("q");
                else setIcon("l");
                break;
        }
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public char getType(){
        return type;
    }

    public void canEnemyMove(int width){
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();

        if ((x==1 || (x==(width/2)+3 && y<=4)) && this.state==1) {
            setState(0);
        }

        if ((x==width-2 || (x==(width/2)-3 && y<=4))&& this.state==0) {
            setState(1);
        }
    }
}
