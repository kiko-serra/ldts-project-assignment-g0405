import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;

public class Princess extends Components implements Characters{
    private Position position;
    private Position jackPosition;

    public Princess(int x, int y) {
        super(x, y);
        this.position = getPosition();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "A");
    }

    public void move() {
        this.setPosition(jackPosition);
    }

    public void setJackPosition(Position pos){
        this.jackPosition = pos;
    }
}
