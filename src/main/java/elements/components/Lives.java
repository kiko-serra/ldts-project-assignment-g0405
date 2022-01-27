package elements.components;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import elements.Position;
<<<<<<< HEAD
import elements.components.Components;
=======
>>>>>>> pitestmeu

public class Lives extends Components {
    private final Position position;

<<<<<<< HEAD

    public Lives(int width, int height){
        super(width, height);
        position = new Position(width, height);

=======
    public Lives(int width, int height){
        super(width, height);
        position = new Position(width, height);
>>>>>>> pitestmeu
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#B00000"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "h");
    }
}
