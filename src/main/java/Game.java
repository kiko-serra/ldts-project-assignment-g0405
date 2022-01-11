import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private final int width = 40;
    private final int height = 20;
    private final TerminalScreen screen;
    public Map map = new Map(width, height);
    Timer timer;
    private final Menu menu;

    class Aux extends TimerTask
    {
        public void run()
        {
            if(map.movePirate()) {
                try{
                    screen.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Game(int width, int height) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        timer = new Timer();
        TimerTask moving = new Aux();
        timer.scheduleAtFixedRate(moving, 100, 100);

        menu = new Menu(this);

    }

    public void draw() throws IOException {
        screen.clear();
        menu.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        menu.menuRun(screen);

        while (true) {
            draw();
            KeyStroke press = screen.readInput();
            if ((press.getKeyType() == KeyType.Character && press.getCharacter() == 'q') || map.checkJackOnExitDoor() || map.getJack().checkIfDead()){
                timer.cancel();
                timer.purge();
                screen.close();
            }
            if (press.getKeyType() == KeyType.EOF) {
                timer.cancel();
                timer.purge();
                screen.close();
                break;
            }
            map.keyStrokes(press);
        }
    }

    public int getWidth(){ return this.width; }

    public int getHeight(){ return this.height; }

}
