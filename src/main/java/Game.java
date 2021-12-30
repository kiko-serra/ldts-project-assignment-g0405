import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
public class Game {
    private final TerminalScreen screen;
    private Map map = new Map(40, 20);

    public Game(int width, int height) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

    }
    public void draw() throws IOException {
        screen.clear();
        map.draw(screen.newTextGraphics());
        screen.refresh();
    }
    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke press = screen.readInput();
            if (press.getKeyType() == KeyType.Character && press.getCharacter() == 'q')
                screen.close();
            if (press.getKeyType() == KeyType.EOF)
                break;
            keyStrokes(press);
        }
    }
    private void keyStrokes(KeyStroke press){
        map.keyStrokes(press);
    }
}
