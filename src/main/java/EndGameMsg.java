import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class EndGameMsg {
    private final Game game;
    private final Position position;
    private final String msg;
    private final Button button;

    public EndGameMsg(Game game, String msg){
        this.game = game;
        this.msg = msg;

        position = new Position((game.getWidth()/2 - msg.length()/2), game.getHeight()/2 - 1);

        this.button = new Button(game.getWidth(), "QUIT GAME", "#ffff00", 14);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(game.getWidth(), game.getHeight()+1), ' ');

        graphics.putString(new TerminalPosition(position.getX(), position.getY()), msg);

        button.draw(graphics);
    }

    public void run(TerminalScreen screen) throws IOException {
        int helper_guy = 0;

        screen.clear();
        draw(screen.newTextGraphics());
        screen.refresh();

        System.out.println("ola");
        do {
            KeyStroke press = screen.readInput();
            switch (press.getKeyType()) {
                case Enter:
                case EOF:
                    helper_guy = -1;
                    break;
            }
        } while (helper_guy != -1);
    }
}
