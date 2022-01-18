package game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import elements.Position;

public class Button {
    private final String text;
    private final Position position;
    private String color;

    public Button( int width, String text, String color, int height) {
        this.text = text;
        this.color = color;

        this.position = new Position(width/2 - text.length()/2, height);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(position.getX(),position.getY(),text);
    }

    public void changeColor(String color){ this.color = color; }
}
