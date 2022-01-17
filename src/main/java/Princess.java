
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Princess extends Components implements Characters {
    private Position position;
    private Position jackPosition;

    public Princess(int x, int y) {
        super(x, y);
        this.position = super.getPosition();
        this.jackPosition = new Position(0, 0);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "f");
    }

    public void move() {
        this.setPosition(jackPosition);
    }

    public void setJackPosition(Position pos){
        this.jackPosition.setX(pos.getX());
        this.jackPosition.setY(pos.getY());
    }

    public Position getJackPosition(){
        return jackPosition;
    }
}
