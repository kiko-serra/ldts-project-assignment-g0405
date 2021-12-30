import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Jack_The_Sparrow extends Components implements Characters{
    private Position position;

    public Jack_The_Sparrow(int x, int y){
        super(x, y);

        this.position = super.getPosition();
    }


    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

    public void move(Position position) {

    }

}
