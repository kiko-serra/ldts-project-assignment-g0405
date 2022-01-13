import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class EndGameMsg {
    private final Game game;
    private final Position position;
    private final String msg;

    public EndGameMsg(Game game, String msg){
        this.game = game;
        this.msg = msg;

        position = new Position((game.getWidth()/2 - msg.length()/2)-1, game.getHeight()/2 - 1);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(game.getWidth(), game.getHeight()), ' ');

        graphics.putString(new TerminalPosition(position.getX(), position.getY()), msg);
    }
}
