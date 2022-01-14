import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
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

    Timer timer1;
    TimerTask moving1;

    Timer timer2;
    TimerTask moving2;

    Timer timer3;
    TimerTask moving3;

    class Aux extends TimerTask {
        public void run()
        {
            //pirates only move if Jack is alive
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

    class Aux2 extends TimerTask {
        public void run()
        {
            //pirates only move if Jack is alive
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

    class Aux3 extends TimerTask {
        public void run()
        {
            //pirates only move if Jack is alive
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

        Font font = new Font("Courier", Font.BOLD, 20);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
        TerminalSize terminalSize = new TerminalSize(width, height+1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize)
                .setTerminalEmulatorFontConfiguration(cfg)
                .setForceAWTOverSwing(true)
                .setTerminalEmulatorTitle("Cross the Map");

        Terminal terminal = terminalFactory.createTerminal();
        ((AWTTerminalFrame)terminal).setResizable(false);
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        map = new Map(width, height);

        timer1 = new Timer();
        moving1 = new Aux();

        timer2 = new Timer();
        moving2 = new Aux2();

        timer3 = new Timer();
        moving3 = new Aux3();

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
            timer1.scheduleAtFixedRate(moving1, 100, 100);
            newGame();
        }
        else if(this.menuChoice == 1) {
            instructions();
        }
        else if(this.menuChoice == 2) {
            timer1.cancel();
            timer1.purge();
            screen.close();
        }
    }

    private void newGame() throws IOException {
        while (true) {
            draw();

            KeyStroke press = screen.readInput();
            if ((press.getKeyType() == KeyType.Character && press.getCharacter() == 'q') || press.getKeyType() == KeyType.EOF) {
                timer1.cancel();
                timer1.purge();
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
        timer1.cancel();
        timer1.purge();
        screen.clear();
        new EndGameMsg(this, msg).run(screen);
        screen.close();
    }

    private void instructions() throws IOException {
        int helperGuy = instruction.run(screen);
        if(helperGuy == -1){
            timer1.cancel();
            timer1.purge();
            screen.close();
        }
        else if(helperGuy == 1) run();
    }

    public int getWidth(){ return this.width; }

    public int getHeight(){ return this.height; }

    private void setMenuChoice(int menuChoice){ this.menuChoice = menuChoice; }

}
