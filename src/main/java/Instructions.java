import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Instructions {
    private final Position position;
    private final String text;
    private final Button button;

    public Instructions(Game game){
        position = new Position(2, 2);
        text = """
                For the player to win the game with the highest score, 
                it needs to catch all the biscuits, which represents the score, 
                and the special key to open the prison door where the Princess is being kept.

                After rescuing the Princess is opened and Jack needs to leave the map through that door.
                """;
        button = new Button(game.getWidth(), "GO BACK", "#ffff00", 25);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.putString(position.getX(),position.getY(),text);
        button.draw(graphics);
    }
}
