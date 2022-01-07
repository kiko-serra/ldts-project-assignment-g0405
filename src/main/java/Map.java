import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private int width;
    private int height;

    Jack_The_Sparrow Jack;
    Princess Princess;

    private List<Borders> borders;
    private List<Biscuits> biscuits;
    private List<Borders> prison;
    private List<Pirates> pirates;
    private Key key;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        this.Jack = new Jack_The_Sparrow(width/2, height-2);
        this.Princess = new Princess(width/2, 2);

        this.borders = createBorders();
        this.prison = createPrison();
        this.biscuits = createBiscuits();
        this.pirates = createPirates();
        this.key = createKey();
    }

    public void draw(TextGraphics graphics) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            Jack.draw(graphics);
            Princess.draw(graphics);

            for (Borders border : borders) border.draw(graphics);
            for (Biscuits biscuit : biscuits) biscuit.draw(graphics);
            for (Borders border : prison) border.draw(graphics);
            for (Pirates pirate : pirates) pirate.draw(graphics);
            if(key != null) key.draw(graphics);
    }

    private List<Borders> createBorders() {
        List<Borders> borders = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            borders.add(new Borders(c, 0));
            borders.add(new Borders(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            borders.add(new Borders(0, r));
            borders.add(new Borders(width - 1, r));
        }

        return borders;
    }

    private List<Biscuits> createBiscuits(){
        Random random = new Random();
        List<Biscuits> biscuits = new ArrayList<>();
        Biscuits biscuit;

        for (int i = 0; i < 5; i++) {
            biscuit = new Biscuits(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            if(checkPosition(biscuit, biscuits)){
                biscuits.add(biscuit);
            }
            else{
                i--;
            }
        }
        return biscuits;
    }

    private List<Borders> createPrison() {
        List<Borders> prison = new ArrayList<>();

        for (int c = Princess.getPosition().getX()-2; c <= Princess.getPosition().getX()+2; c++) {
            prison.add(new Borders(c, Princess.getPosition().getY()+2));
        }

        for (int r = Princess.getPosition().getY()-1; r <= Princess.getPosition().getY()+1; r++) {
            prison.add(new Borders(Princess.getPosition().getX()-2, r));
            prison.add(new Borders(Princess.getPosition().getX()+2, r));
        }

        return prison;
    }

    private Key createKey(){
        Key k;
        do {
            Random random = new Random();
            k = new Key(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
        } while (!checkPosition(k, biscuits));
        return k;
    }

    private List<Pirates> createPirates(){
        Random random = new Random();
        List<Pirates> pirates = new ArrayList<>();
        Pirates pirate;

        for (int i = 0; i < 8; i++) {
            pirate = new Pirates(random.nextInt(width - 2) + 1, random.nextInt(height - 3) + 1);

            if(checkPosition(pirate, biscuits)){
                for(Pirates p : pirates){
                    if(p.getPosition().equals(pirate.getPosition())){
                        i--;
                    }
                }
                pirates.add(pirate);
            }
            else{
                i--;
            }
        }
        return pirates;
    }

    //verifica se o objeto esta dentro da prisao ou se esta coincidente com as paredes da mesma
    private boolean checkPosition (Components component, List<Biscuits> biscuits){
        for (int i=-1; i<3; i++){
            if (component.getPosition().getX()==Princess.getPosition().getX()-2 && component.getPosition().getY()==Princess.getPosition().getY()+i) return false;
            if (component.getPosition().getX()==Princess.getPosition().getX()-1 && component.getPosition().getY()==Princess.getPosition().getY()+i) return false;
            if (component.getPosition().getX()==Princess.getPosition().getX() && component.getPosition().getY()==Princess.getPosition().getY()+i) return false;
            if (component.getPosition().getX()==Princess.getPosition().getX()+1 && component.getPosition().getY()==Princess.getPosition().getY()+i) return false;
            if (component.getPosition().getX()==Princess.getPosition().getX()+2 && component.getPosition().getY()==Princess.getPosition().getY()+i) return false;
        }
        if(component.getPosition().equals(Jack.getPosition())) return false;

        for(Biscuits biscuit : biscuits){
            if(component.getPosition().equals(biscuit.getPosition())) return false;
        }
        return true;
    }

    public void keyStrokes (KeyStroke press){
        Jack.setJackDirection(press.getKeyType());
        moveJack(press.getKeyType());
    }
    private void moveJack(KeyType press){
        Jack.move();
        eatBiscuits();
        if(key != null) collectKey();
        this.openExit();
        if(Jack.canJackMove(borders, prison)){
            switch (press) {
                case ArrowUp -> Jack.setPosition(Jack.getPosition().moveDown());
                case ArrowDown -> Jack.setPosition(Jack.getPosition().moveUp());
                case ArrowRight -> Jack.setPosition(Jack.getPosition().moveLeft());
                case ArrowLeft -> Jack.setPosition(Jack.getPosition().moveRight());
            }
        }

    }

    public boolean movePirate(){
        for (Pirates pirate : pirates){
            pirate.move();
            pirate.canPirateMove(pirate, width);
        }
        checkJackColision();
        return Jack.checkIfDead();
    }

    private void eatBiscuits (){
        for (Biscuits biscuit: biscuits){
            if (Jack.getPosition().equals(biscuit.getPosition())){
                biscuits.remove(biscuit);
                Jack.setPoints();
                break;
            }
        }
    }

    private void checkJackColision (){
        for (Pirates pirate: pirates){
            if (Jack.getPosition().equals(pirate.getPosition())){
                Jack.setLives();
                System.out.println(Jack.lives);
            }
        }
    }

    private void collectKey(){
        if (Jack.getPosition().equals(key.getPosition())){
            key = null;
            for (Borders border: prison){
                if ((border.getPosition().getX() == Princess.getPosition().getX()) && (border.getPosition().getY() == (Princess.getPosition().getY() + 2))){
                    prison.remove(border);
                    break;
                }
            }
        }
    }

    private void openExit(){
        if(Jack.getPosition().getX() == Princess.getPosition().getX() && Jack.getPosition().getY() == Princess.getPosition().getY()+1){
            for(Borders border: borders){
                if(border.getPosition().getX() == (width/2) && border.getPosition().getY() == height-1){
                    borders.remove(border);
                    break;
                }
            }
        }
    }
}
