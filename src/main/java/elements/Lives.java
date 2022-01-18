package elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Lives {
    private final Position position;

    public Lives(int with, int height){
        position = new Position(with, height);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#B00000"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "h");
    }
}
