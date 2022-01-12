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
    private final int width;
    private final int height;
    private final TerminalScreen screen;
    public Map map;

    private final Menu menu;
    private int menuChoice;

    private final Instructions instruction;

    Timer timer;
    TimerTask moving;

    class Aux extends TimerTask {
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
        this.width = width;
        this.height = height;

        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        map = new Map(width, height);

        timer = new Timer();
        moving = new Aux();

        menu = new Menu(this);
        this.menuChoice = -1;

        instruction = new Instructions(this);
    }

    public void draw() throws IOException {
        screen.clear();
        map.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        setMenuChoice(menu.menuRun(screen));

        if (this.menuChoice == 0) {
            timer.scheduleAtFixedRate(moving, 100, 100);
            newGame();
        }
        else if(this.menuChoice == 1) instructions();
        else if(this.menuChoice == 2) {
            timer.cancel();
            timer.purge();
            screen.close();
        }
    }

    private void newGame() throws IOException {
        while (true) {
            draw();

            KeyStroke press = screen.readInput();
            if ((press.getKeyType() == KeyType.Character && press.getCharacter() == 'q') || map.checkJackOnExitDoor() || map.getJack().checkIfDead()) {
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

    private void instructions() throws IOException {
        screen.clear();
        instruction.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public int getWidth(){ return this.width; }

    public int getHeight(){ return this.height; }

    private void setMenuChoice(int menuChoice){ this.menuChoice = menuChoice; }

}
