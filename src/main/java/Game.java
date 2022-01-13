import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
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
                    endGame("Game Over!");
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

        Font font = new Font("WenQuanYi Zen Hei Mono", Font.BOLD, 20);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
        TerminalSize terminalSize = new TerminalSize(width, height+1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).setTerminalEmulatorFontConfiguration(cfg);
        Terminal terminal = terminalFactory.createTerminal();
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
        else if(this.menuChoice == 1) {
            instructions();
        }
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
            if ((press.getKeyType() == KeyType.Character && press.getCharacter() == 'q') || press.getKeyType() == KeyType.EOF) {
                timer.cancel();
                timer.purge();
                screen.close();
                break;
            }
            else if(map.checkJackOnExitDoor()){
                endGame("Victory!");
                break;
            }

            map.keyStrokes(press);
        }
    }

    private void endGame(String msg) throws IOException {
        timer.cancel();
        timer.purge();
        screen.clear();
        new EndGameMsg(this, msg).run(screen);
        screen.close();
    }

    private void instructions() throws IOException {
        int helperGuy = instruction.run(screen);
        if(helperGuy == -1){
            timer.cancel();
            timer.purge();
            screen.close();
        }
        else if(helperGuy == 1) run();
    }

    public int getWidth(){ return this.width; }

    public int getHeight(){ return this.height; }

    private void setMenuChoice(int menuChoice){ this.menuChoice = menuChoice; }

}
