import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Borders extends Components{
    private Position position;

    public Borders(int x, int y){
        super(x, y);
        this.position=super.getPosition();
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#B33F40"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "I");
    }
}
