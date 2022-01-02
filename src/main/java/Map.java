import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

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

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        this.Jack = new Jack_The_Sparrow(width/2, height-2);
        this.Princess = new Princess(width/2, 2);

        this.borders = createBorders();
        this.biscuits = createBiscuits();
        this.prison = createPrison();
        this.pirates = createPirates();
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
            if(checkPositionPrison(biscuit)){
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

    private List<Pirates> createPirates(){
        Random random = new Random();
        List<Pirates> pirates = new ArrayList<>();
        Pirates pirate;

        for (int i = 0; i < 8; i++) {
            pirate = new Pirates(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);

            if(checkPositionPrison(pirate)){
                pirates.add(pirate);
            }
            else{
                i--;
            }
        }
        return pirates;
    }

    //verifica se o objeto esta dentro da prisao ou se esta coincidente com as paredes da mesma
    public boolean checkPositionPrison (Components component){

        for (int i=-1; i<3; i++){
            if (component.getPosition().getX()==Princess.getPosition().getX()-2 && component.getPosition().getY()==Princess.getPosition().getY()+i){
                return false;
            }
            if (component.getPosition().getX()==Princess.getPosition().getX()-1 && component.getPosition().getY()==Princess.getPosition().getY()+i){
                return false;
            }
            if (component.getPosition().getX()==Princess.getPosition().getX() && component.getPosition().getY()==Princess.getPosition().getY()+i){
                return false;
            }
            if (component.getPosition().getX()==Princess.getPosition().getX()+1 && component.getPosition().getY()==Princess.getPosition().getY()+i){
                return false;
            }
            if (component.getPosition().getX()==Princess.getPosition().getX()+2 && component.getPosition().getY()==Princess.getPosition().getY()+i){
                return false;
            }
        }
        return true;
    }

    public void keyStrokes (KeyStroke press){
        Jack.setJackDirection(press.getKeyType());
        moveJack();
        movePirate();
    }

    public void moveJack(){
        //canJackMove();
        Jack.move();
    }

    public boolean canJackMove(){
        return true;
    }

    public void movePirate(){
        for (Pirates pirate : pirates){
            pirate.move();
            pirate.canIMove(pirate, width);
        }
    }

//    public boolean canPirateMove (Position position){
//        if (position.getX()==0)
//    }
}
