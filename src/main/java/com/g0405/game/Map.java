package com.g0405.game;

import com.g0405.elements.components.*;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import com.g0405.elements.components.Lives;
import com.g0405.elements.components.Points;
import com.g0405.elements.Position;
import com.g0405.elements.components.characters.*;
import com.g0405.elements.components.characters.enemies.Bombers;
import com.g0405.elements.components.characters.enemies.Enemies;
import com.g0405.elements.components.characters.enemies.Pirates;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private final int width;
    private final int height;

    JackTheSparrow jack;
    Princess princess;

    private List<Borders> borders;
    private List<Biscuits> biscuits;
    private List<Borders> prison;
    private List<Pirates> pirates;
    private List<Bombers> bombers;
    private Key key;
    private Exit exit;
    private List<Lives> lives;
    private Points points;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        this.jack = new JackTheSparrow(width/2, height-2);
        this.princess = new Princess(width/2, 2);

        this.borders = createBorders();
        this.prison = createPrison();
        this.biscuits = createBiscuits();
        this.pirates = createPirates();
        this.bombers = createBombers();
        this.key = createKey();
        this.exit = null;

        this.lives = createLives();
        this.points = new Points(width - 1, height, "POINTS: ");
    }

    public void draw(TextGraphics graphics) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            jack.draw(graphics);
            princess.draw(graphics);
            points.draw(graphics);
            for (Lives life : lives) life.draw(graphics);

            for (Borders border : borders) border.draw(graphics);
            for (Biscuits biscuit : biscuits) biscuit.draw(graphics);
            for (Borders border : prison) border.draw(graphics);

            if(key != null) key.draw(graphics);
            for (Pirates pirate : pirates) pirate.draw(graphics);
            for (Bombers bomber : bombers) {
                if(bomber.getBomb() != null) bomber.getBomb().draw(graphics);
                bomber.draw(graphics);
            }
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

    public void setBorders(List<Borders> borders1){
        borders = borders1;
    }

    public List<Borders> getBorders(){

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

    public List<Biscuits> getBiscuits(){
        return biscuits;
    }

    public void setBiscuits(List<Biscuits> biscuits1){
        biscuits = biscuits1;
    }

    private List<Borders> createPrison() {
        List<Borders> prison = new ArrayList<>();

        for (int c = princess.getPosition().getX()-2; c <= princess.getPosition().getX()+2; c++) {
            prison.add(new Borders(c, princess.getPosition().getY()+2));
        }

        for (int r = princess.getPosition().getY()-1; r <= princess.getPosition().getY()+1; r++) {
            prison.add(new Borders(princess.getPosition().getX()-2, r));
            prison.add(new Borders(princess.getPosition().getX()+2, r));
        }

        return prison;
    }

    public List<Borders> getPrison(){
        return prison;
    }

    public void setPrison(List<Borders> prison1){
        prison = prison1;
    }

    private Key createKey(){
        Key k;
        do {
            Random random = new Random();
            k = new Key(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
        } while (!checkPosition(k, biscuits));
        return k;
    }

    public Key getKey(){
        return key;
    }

    public void setKey(Key key1){
        key = key1;
    }

    private List<Pirates> createPirates(){
        Random random = new Random();
        List<Pirates> p = new ArrayList<>();
        Pirates pirate;

        for (int i = 0; i < 9; i++) {
            pirate = new Pirates(random.nextInt(width - 2) + 1, random.nextInt(height - 3) + 1, "p", 'P');
            if(checkPosition(pirate, biscuits)){
                p.add(pirate);
            }
            else{
                i--;
            }
        }
        return p;
    }

    public List<Pirates> getPirates(){
        return pirates;
    }

    public void setPirates(List<Pirates> pirates1){
        pirates = pirates1;
    }

    private List<Bombers> createBombers(){
        Random random = new Random();
        List<Bombers> b = new ArrayList<>();
        Bombers bomber;

        for (int i = 0; i < 3; i++) {
            bomber = new Bombers(random.nextInt(width - 2) + 1, random.nextInt(height - 7) + 5, "m", 'M', width);
            if(checkPosition(bomber, biscuits)){
                b.add(bomber);
            }
            else{
                i--;
            }
        }
        return b;
    }

    public List<Bombers> getBombers(){
        return bombers;
    }

    public void setBombers(List<Bombers> bombers1){
        bombers = bombers1;
    }

    private List<Lives> createLives(){
        int k = 0;
        List<Lives> l = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            l.add(new Lives(1 + k, height));
            k += 2;
        }

        return l;
    }

    public List<Lives> getLives(){
        return lives;
    }

    //verifica se o objeto esta dentro da prisao ou se esta coincidente com as paredes da mesma
    public boolean checkPosition (Components component, List<Biscuits> biscuits){
        for (int i=-1; i<3; i++){
            if (comparePositions(component.getPosition(), princess.getPosition(), -2, i)) return false;
            if (comparePositions(component.getPosition(), princess.getPosition(), -1, i)) return false;
            if (comparePositions(component.getPosition(), princess.getPosition(), 0, i)) return false;
            if (comparePositions(component.getPosition(), princess.getPosition(), +1, i)) return false;
            if (comparePositions(component.getPosition(), princess.getPosition(), +2, i)) return false;
        }
        if(component.getPosition().equals(jack.getPosition())) return false;

        for(Biscuits biscuit : biscuits){
            if(component.getPosition().equals(biscuit.getPosition())) return false;
        }
        return true;
    }

    public void keyStrokes (KeyStroke press){
        princess.setJackPosition(jack.getPosition());
        jack.setJackDirection(press.getKeyType());
        moveJack(press.getKeyType());
    }

    public void moveJack(KeyType press){
        princess.setJackPosition(jack.getPosition());
        jack.move();
        if(jack.canJackMove(borders, prison)){
            switch (press) {
                case ArrowUp:
                    jack.setPosition(jack.getPosition().moveDown());
                    break;
                case ArrowDown:
                    jack.setPosition(jack.getPosition().moveUp());
                    break;
                case ArrowRight:
                    jack.setPosition(jack.getPosition().moveLeft());
                    break;
                case ArrowLeft:
                    jack.setPosition(jack.getPosition().moveRight());
                    break;
            }
        }
        else if(this.exit != null) princess.move();

        eatBiscuits();
        if(this.key != null) collectKey();
        this.openExit();
    }

    public boolean moveEnemies(){
        for(Pirates pirate: pirates){
            moveEnemy(pirate);
            checkJackColision(pirate);
        }
        for(Bombers bomber: bombers){
            moveEnemy(bomber);
            checkJackColision(bomber);

            bomber.bombActions();
            if(bomber.getBomb() != null && bomber.getCounter() == 10){
                if(checkJackAround(bomber.getBomb())){
                    jack.setLives();
                    lives.remove(lives.get(lives.size()-1));
                }
            }
        }

        return jack.checkIfDead();
    }

    private void moveEnemy(Enemies enemy){
        enemy.move();
        enemy.canEnemyMove(width);
    }

    public void checkJackColision (Enemies enemy){
        if (jack.getPosition().equals(enemy.getPosition())){
            jack.setLives();
            lives.remove(lives.get(lives.size()-1));
        }
    }

    public boolean checkJackAround(Bombs bomb){
        for(int i = -1; i <= 1; i++){
            for(int k = -1; k <= 1; k++){
                if(comparePositions(jack.getPosition(), bomb.getPosition(), i, k)) return true;
            }
        }
        return false;
    }

    public void eatBiscuits (){
        for (Biscuits biscuit: biscuits){
            if (jack.getPosition().equals(biscuit.getPosition())){
                biscuits.remove(biscuit);
                jack.setPoints();
                points.setPoints();
                break;
            }
        }
    }

    public void collectKey(){
        if (jack.getPosition().equals(key.getPosition())){
            key = null;
            for (Borders border: prison){
                if (comparePositions(border.getPosition(), princess.getPosition(), 0, 2)){
                    prison.remove(border);
                    break;
                }
            }
        }
    }

    public void openExit(){
        if(comparePositions(jack.getPosition(), princess.getPosition(), 0, 1)){
            for(Borders border: borders){
                if(border.getPosition().getX() == (width/2) && border.getPosition().getY() == height-1){
                    this.exit = new Exit(border.getPosition().getX(), border.getPosition().getY());
                    borders.remove(border);
                    break;
                }
            }
        }
    }

    private boolean comparePositions(Position pos1, Position pos2, int increX, int increY){
        int x = pos2.getX() + increX;
        int y = pos2.getY() + increY;
        Position posAux = new Position(x, y);
        return pos1.equals(posAux);
    }

    public boolean checkJackOnExitDoor(){
        if(this.exit != null)
            return comparePositions(this.jack.getPosition(), this.exit.getPosition(), 0, 0);
        else return false;
    }

    public Points getPoints(){
        return points;
    }

    public Exit getExit(){
        return exit;
    }

    public void setExit(Exit exit1){
        exit = exit1;
    }
}
