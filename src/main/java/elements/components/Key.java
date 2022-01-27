package elements.components;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import elements.Position;

public class Key extends Components {
    private Position position;

    public Key(int x, int y) {
        super(x, y);
        this.position = super.getPosition();
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "k");
    }
}
