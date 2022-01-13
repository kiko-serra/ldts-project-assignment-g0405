import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Lives {
    private Position position;

    public Lives(int with, int height){
        position = new Position(with, height);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "V");
    }
}
