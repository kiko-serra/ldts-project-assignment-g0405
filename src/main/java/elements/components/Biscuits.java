package elements.components;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import elements.Position;

public class Biscuits extends Components {
    private final Position position;

    public Biscuits(int x, int y) {
        super(x, y);
        this.position = super.getPosition();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#E6CEA0"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "c");
    }
}
