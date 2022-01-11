import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private final Game game;
    private final List<Button> buttons;

    public Menu(Game game){
        this.game = game;

        this.buttons = Arrays.asList(new Button(game.getWidth(), "NEW GAME", "#ffff00", 5),
                                     new Button(game.getWidth(), "INSTRUCTIONS", "#FFFFFF", 10),
                                     new Button(game.getWidth(), "QUIT GAME", "#FFFFFF", 15));
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(game.getWidth(), game.getHeight()), ' ');
        for(Button button: buttons){
            button.draw(graphics);
        }
    }

    public void menuRun(TerminalScreen screen) throws IOException {
        while (true) {
            KeyStroke press = screen.readInput();
            /*if (){
            }*/
            break;
        }
    }
}
