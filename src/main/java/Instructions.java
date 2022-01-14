import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TerminalTextUtils;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class Instructions {
    private final Game game;
    private final Position position;
    private final String text;
    private final Button button;

    public Instructions(Game game){
        this.game = game;
        position = new Position(2, 2);
        text = " For the player to win the game with the highest score, " +
                "it needs to catch all the biscuits, which represents the score, " +
                "and the special key to open the prison door where the Princess is being kept." +
                "\n" +
                "After rescuing the Princess is opened and Jack needs to leave the map through that door.";

        TerminalTextUtils util;
        button = new Button(game.getWidth(), "GO BACK", "#ffff00", 25);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(game.getWidth(), game.getHeight()+1), ' ');
        graphics.putString(position.getX(),position.getY(),text);
        button.draw(graphics);
    }

    public int run(TerminalScreen screen) throws IOException {
        int helper_guy = 0;
        int res = 0;

        screen.clear();
        draw(screen.newTextGraphics());
        screen.refresh();

        do {
            KeyStroke press = screen.readInput();
            switch (press.getKeyType()) {
                case Enter:
                    res = 1;
                    helper_guy = -1;
                    break;
                case EOF:
                    res = -1;
                    helper_guy = -1;
                    break;
            }
        } while (helper_guy != -1);

        return res;
    }
}
