package com.g0405.game;

import com.g0405.elements.Position;
import com.g0405.elements.components.*;
import com.g0405.elements.components.characters.enemies.Bombers;
import com.g0405.elements.components.characters.enemies.Pirates;
import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.lanterna.input.KeyType.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestMap {
    private List<Borders> prison;
    private Key key;
    private Map map;

    private Borders border;
    private Borders border1;
    private Borders border2fail;

    private Biscuits biscuit;
    private Biscuits biscuit1;
    private Biscuits biscuitprisonfail;
    private Biscuits biscuitpiratefail;
    private Biscuits biscuitbomberfail;

    private Borders prisonb;
    private Borders prison1;
    private Borders prison2;
    private Borders prison3fail;

    private Pirates pirate;
    private Pirates pirate1;
    private Pirates pirate3;
    private Pirates pirate2fail;
    private Pirates piratejackfail;

    private Bombers bomber;
    private Bombers bomber1;
    private Bombers bomber2fail;
    private Bombers bomberjackfail;

    @BeforeEach
    public void setUp(){
       prison = new ArrayList<>();

       border = new Borders(1,30);
       border1 = new Borders(2,30);
       border2fail = new Borders(4,25);

       biscuit = new Biscuits(10,10);
       biscuit1 = new Biscuits(5,26);
       biscuitprisonfail = new Biscuits(17,4);
       biscuitpiratefail = new Biscuits(10,10);
       biscuitbomberfail = new Biscuits(7,10);

       prisonb = new Borders(17,4);
       prison1 = new Borders(13,4);
       prison2 = new Borders(13,1);
       prison3fail = new Borders(7,10);

       pirate = new Pirates(10,10,"p",'P');
       pirate1 = new Pirates(4,11,"q",'P');
       pirate3 = new Pirates(6,14,"q",'P');
       piratejackfail = new Pirates(11,10,"p",'P');
       pirate2fail = new Pirates(15,2,"q",'P');

       bomber = new Bombers(5,10,"l",'M',30);
       bomber1 = new Bombers(7,10,"m",'M',30);
       bomber2fail = new Bombers(4,25,"m",'M',30);
       bomberjackfail = new Bombers(11,10,"m",'M',30);

       key = new Key(10,10);

       map = new Map(30,30);
    }

    @Test
    public void testMapConstructor(){
        assertEquals(15,map.getJack().getPosition().getX());
        assertEquals(28,map.getJack().getPosition().getY());
    }


    @Test
    public void testCreateBorders(){
        boolean bordersdone = true;
        int counter = 0;

        for(Borders bord : map.getBorders()){
            for(Borders bord1 : map.getBorders()){
                if(bord.getPosition().getY() == bord1.getPosition().getY()
                && bord.getPosition().getX() == bord1.getPosition().getX()){
                    ++ counter;
                }
            }
        }
        if(counter > map.getBorders().size()){
            bordersdone = false;
        }

        assertTrue(bordersdone);
    }

    @Test
    public void testGetBorders(){
        List<Borders> borders1 = map.getBorders();

        assertEquals(borders1,map.getBorders());
    }

    @Test
    public void testSetBorders(){

        List<Borders> borders1 = new ArrayList<>();

        borders1.add(border1);
        borders1.add(border);
        borders1.add(border2fail);

        map.setBorders(borders1);

        assertEquals(borders1,map.getBorders());
    }

    @Test
    public void testCreateBiscuits(){
        boolean biscuitsdone = true;
        List<Biscuits> aux = map.getBiscuits();

        for(Biscuits biscuit : aux){
            if(map.checkPosition(biscuit,aux)){
                biscuitsdone = false;
                break;
            }
        }


        assertTrue(biscuitsdone);
    }

    @Test
    public void testGetBiscuits(){
        List<Biscuits> biscuits1 = map.getBiscuits();

        assertEquals(biscuits1,map.getBiscuits());
    }

    @Test
    public void testSetBiscuits(){
        List<Biscuits> biscuits1 = new ArrayList<>();

        biscuits1.add(biscuit);
        biscuits1.add(biscuit1);
        biscuits1.add(biscuitprisonfail);
        biscuits1.add(biscuitpiratefail);

        map.setBiscuits(biscuits1);

        assertEquals(biscuits1,map.getBiscuits());
    }

    @Test
    public void testCreatePrison(){
        boolean prisondone = true;
        int counter = 0;

        for(Borders prison : map.getPrison()){
            if((prison.getPosition().getX() > 17 && prison.getPosition().getX() < 13) ||
                    (prison.getPosition().getY() > 4 || prison.getPosition().getY() < 0)){
                prisondone = false;
                break;
            }
            for(Borders prison1 : map.getPrison()){
                if(prison.getPosition().getY() == prison1.getPosition().getY()
                        && prison.getPosition().getX() == prison1.getPosition().getX()){
                    ++ counter;
                }
            }
        }
        if(counter > map.getPrison().size()){
            prisondone = false;
        }

        assertTrue(prisondone);

    }

    @Test
    public void testGetPrison(){
        List<Borders> prison1 = map.getPrison();

        assertEquals(prison1, map.getPrison());
    }

    @Test
    public void testSetPrison(){
        List<Borders> prison1 = new ArrayList<>();

        prison1.add(prisonb);
        prison1.add(prison2);
        prison1.add(prison3fail);

        map.setPrison(prison1);

        assertEquals(prison1, map.getPrison());
    }


    @Test
    public void testCreateKey(){
        boolean keydone = true;
        Key aux = map.getKey();

        if(!map.checkPosition(aux,map.getBiscuits())){
            keydone = false;
        }

        assertTrue(keydone);
    }


    @Test
    public void testGetKey(){
        Key key1 = map.getKey();

        assertEquals(key1, map.getKey());
    }

    @Test
    public void testSetKey(){
        Key key1 = key;

        map.setKey(key1);

        assertEquals(key1,map.getKey());
    }

    @Test
    public void testCreatePirates(){

        boolean piratesdone = true;
        List<Pirates> aux = map.getPirates();

        for(Pirates pirate : aux){
            if(!map.checkPosition(pirate,map.getBiscuits())){
                piratesdone = false;
                break;
            }
        }


        assertTrue(piratesdone);

    }

    @Test
    public void testGetPirates(){
        List<Pirates> pirates1 = map.getPirates();

        assertEquals(pirates1,map.getPirates());
    }

    @Test
    public void testSetPirates(){
        List<Pirates> pirates1 = new ArrayList<>();

        pirates1.add(pirate);
        pirates1.add(pirate1);
        pirates1.add(pirate2fail);
        pirates1.add(pirate3);

        map.setPirates(pirates1);

        assertEquals(pirates1,map.getPirates());
    }


    @Test
    public void testCreateBombers(){
        boolean bombersdone = true;
        List<Bombers> aux = map.getBombers();

        for(Bombers bomber : aux){
            if(!map.checkPosition(bomber,map.getBiscuits())){
                bombersdone = false;
            }
        }


        assertTrue(bombersdone);

    }

    @Test
    public void testGetBombers(){
        List<Bombers> bombers1 = map.getBombers();

        assertEquals(bombers1,map.getBombers());
    }

    @Test
    public void testSetBombers(){
        List<Bombers> bombers1 = new ArrayList<>();

        bombers1.add(bomber);
        bombers1.add(bomber1);
        bombers1.add(bomber2fail);


        map.setBombers(bombers1);

        assertEquals(bombers1, map.getBombers());
    }

    @Test
    public void testCreateLives(){
        boolean livesdone = true;
        for(Lives live : map.getLives()){
            if(live != null) continue;
            livesdone = false;
        }
        assertEquals(3,map.getLives().size());
        assertTrue(livesdone);
    }

    @Test
    public void testCheckPositionPrisonTrue() {
        boolean checkpos = true;
        prison.add(prisonb);
        prison.add(prison1);
        prison.add(prison2);

        for (Borders border : prison) {
            if (map.checkPosition(border, map.getBiscuits())) {
                checkpos = false;
                break;
            }
        }

        assertTrue(checkpos);
    }

    @Test
    public void testCheckPositionPrisonFalse() {
        List<Biscuits> auxbiscuits = map.getBiscuits();
        auxbiscuits.add(biscuitprisonfail);

        boolean checkpos = true;
        prison.add(prisonb);
        prison.add(prison1);
        prison.add(prison2);


        for (Borders border : prison) {
            if (!map.checkPosition(border, auxbiscuits)) {
                checkpos = false;
                break;
            }
        }

        assertFalse(checkpos);
    }

    @Test
    public void testCheckPositionPirateTrue(){
        boolean checkpos = true;

        for(Pirates pirate : map.getPirates()){
            if(!map.checkPosition(pirate,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertTrue(checkpos);
    }

    @Test
    public void testCheckPositionPirateFalse(){
        boolean checkpos = true;

        List<Biscuits> auxbiscuits = map.getBiscuits();
        auxbiscuits.add(biscuitpiratefail);

        List<Pirates> auxpirates = map.getPirates();

        auxpirates.add(pirate);

        map.setPirates(auxpirates);

        for(Pirates pirate : auxpirates){
            if(map.checkPosition(pirate,auxbiscuits)){
                checkpos = false;
                break;
            }
        }
        assertFalse(checkpos);
    }

    @Test
    public void testCheckPositionBomberTrue(){
        boolean checkpos = true;

        for(Bombers bomber : map.getBombers()){
            if(!map.checkPosition(bomber,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertTrue(checkpos);
    }

    @Test
    public void testCheckPositionBomberFalse(){
        boolean checkpos = true;

        List<Biscuits> auxbiscuits = map.getBiscuits();
        auxbiscuits.add(biscuitbomberfail);

        List<Bombers> auxbombers = map.getBombers();
        auxbombers.add(bomber1);

        for(Bombers bomber : map.getBombers()){
            if(!map.checkPosition(bomber,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertFalse(checkpos);
    }

    @Test
    public void testKeyStrokesPrincessGetJackPosition(){
        KeyStroke stroke = new KeyStroke(ArrowDown);
        map.getJack().setPosition(new Position(10,10));
        map.keyStrokes(stroke);

        assertEquals(10,map.getPrincess().getJackPosition().getX());
        assertEquals(10,map.getPrincess().getJackPosition().getY());

    }

    @Test
    public void testKeyStrokesMapJackGetDirection(){

        KeyStroke stroke = new KeyStroke(ArrowDown);
        map.getJack().setPosition(new Position(10,10));
        map.keyStrokes(stroke);

        assertEquals(ArrowDown,map.getJack().getDirection());

    }


    @Test
    public void testKeyStrokesMapJackGetPosition(){

        KeyStroke stroke = new KeyStroke(ArrowDown);
        map.getJack().setPosition(new Position(10,10));
        map.keyStrokes(stroke);

        assertNotEquals(9,map.getJack().getPosition().getY());

    }

    @Test
    public void testCanJackMovePrisonTrue(){
        map.getJack().setPosition(new Position(16,5));
        map.getJack().setJackDirection(ArrowUp);
        map.getJack().move();

        assertEquals(4,map.getJack().getPosition().getY());
        assertTrue(map.getJack().canJackMove(map.getBorders(),map.getPrison()));
    }

    @Test
    public void testCanJackMovePrisonFalse(){
        map.getJack().setPosition(new Position(16,5));
        map.getJack().setJackDirection(ArrowLeft);
        map.getJack().move();

        assertEquals(15,map.getJack().getPosition().getX());
        assertFalse(map.getJack().canJackMove(map.getBorders(),map.getPrison()));
    }

    @Test
    public void testCanJackMoveBordersTrue(){
        map.getJack().setPosition(new Position(15,28));
        map.getJack().setJackDirection(ArrowDown);
        map.getJack().move();

        assertEquals(29,map.getJack().getPosition().getY());
        assertTrue(map.getJack().canJackMove(map.getBorders(),map.getPrison()));
    }

    @Test
    public void testCanJackMoveBordersFalse(){
        map.getJack().setPosition(new Position(15,28));
        map.getJack().setJackDirection(ArrowUp);
        map.getJack().move();

        assertEquals(27,map.getJack().getPosition().getY());
        assertFalse(map.getJack().canJackMove(map.getBorders(),map.getPrison()));
    }

    @Test
    public void testMoveJackArrowUp(){
        map.getJack().setPosition(new Position(15,1));
        map.getJack().setJackDirection(ArrowUp);
        map.moveJack(ArrowUp);


        assertEquals(1,map.getJack().getPosition().getY());
    }


    @Test
    public void testMoveJackArrowDown(){
        map.getJack().setPosition(new Position(15,28));
        map.getJack().setJackDirection(ArrowDown);
        map.moveJack(ArrowDown);

        assertEquals(28,map.getJack().getPosition().getY());
    }


    @Test
    public void testMoveJackArrowLeft(){
        map.getJack().setPosition(new Position(1,2));
        map.getJack().setJackDirection(ArrowLeft);
        map.moveJack(ArrowLeft);


        assertEquals(1,map.getJack().getPosition().getX());

    }


    @Test
    public void testMoveJackArrowRight(){
        map.getJack().setPosition(new Position(28,2));
        map.getJack().setJackDirection(ArrowRight);
        map.moveJack(ArrowRight);


        assertEquals(28,map.getJack().getPosition().getX());

    }
    @Test
    public void testMoveEnemiesCheckJackDead(){
        map.getJack().setPosition(new Position(10,10));


        map.getLives().remove(0);
        map.getLives().remove(0);
        map.getLives().remove(0);

        map.getJack().setLives();
        map.getJack().setLives();
        map.getJack().setLives();

        boolean checkjack = map.moveEnemies();

        assertTrue(checkjack);
    }

    @Test
    public void testMoveEnemiesBomberActions(){
        map.getJack().setPosition(new Position(11,10));

        bomberjackfail.setBomb(new Bombs(10,10,"g"));
        bomberjackfail.setCounter(9);

        List<Bombers> auxbombers = map.getBombers();
        auxbombers.add(bomberjackfail);
        map.setBombers(auxbombers);

        map.moveEnemies();

        assertEquals(2,map.getLives().size());
        assertEquals(2,map.getJack().getLives());
    }


    @Test
    public void testCheckJackColisionPirate(){
        map.getJack().setPosition(new Position(11,10));
        map.checkJackColision(piratejackfail);
        assertEquals(2,map.getLives().size());
        assertEquals(2,map.getJack().getLives());
    }


    @Test
    public void testCheckJackColisionBomber(){
        map.getJack().setPosition(new Position(11,10));
        map.checkJackColision(bomberjackfail);
        assertEquals(2,map.getLives().size());
        assertEquals(2,map.getJack().getLives());
    }

    @Test
    public void testJackAround(){
        map.getJack().setPosition(new Position(10,10));
        Bombs bomb = new Bombs(10,10,"d");
        boolean checkjackaround = map.checkJackAround(bomb);

        assertTrue(checkjackaround);

        map.getJack().setPosition(new Position(8,10));
        checkjackaround = map.checkJackAround(bomb);

        assertFalse(checkjackaround);

    }


    @Test
    public void testEatBiscuitsSize(){
        map.getJack().setPosition(new Position(10,10));
        List<Biscuits> aux = map.getBiscuits();

        aux.add(new Biscuits(10,10));
        map.setBiscuits(aux);

        map.eatBiscuits();

        assertEquals(5,map.getBiscuits().size());

    }


    @Test
    public void testEatBiscuitsPoints(){
        map.getJack().setPosition(new Position(10,10));
        List<Biscuits> aux = map.getBiscuits();

        aux.add(new Biscuits(10,10));
        map.setBiscuits(aux);

        map.eatBiscuits();

        assertEquals(1,map.getPoints().getPoints());
        assertEquals(1,map.getJack().getPoints());
    }

    @Test
    public void testCollectKeyNULLKey(){

        map.getJack().setPosition(new Position(10,10));
        map.setKey(new Key(10,10));

        map.collectKey();

        assertNull(map.getKey());


    }


    @Test
    public void testCollectKeyPrisonOpen(){

        Position openprison = new Position(15,4);
        boolean checkopenprison = true;
        map.getJack().setPosition(new Position(10,10));
        map.setKey(new Key(10,10));

        for(Borders prison : map.getPrison()){
            if(prison.getPosition() == openprison){
                checkopenprison = false;
                break;
            }
        }

        assertTrue(checkopenprison);
    }

    @Test
    public void testOpenExit(){
        Position openexit = new Position(15,29);
        boolean checkopenexit = true;
        map.getJack().setPosition(new Position(15,3));


        map.openExit();


        for (Borders border : map.getBorders()){
            if(border.getPosition() == openexit){
                checkopenexit = false;
                break;
            }
        }

        assertEquals(map.getExit().getPosition().getX(),openexit.getX());
        assertEquals(map.getExit().getPosition().getY(),openexit.getY());
        assertTrue(checkopenexit);


    }

    @Test
    public void testCheckJackOnExitDoorTrue(){
        map.getJack().setPosition(new Position(15,29));
        map.setExit(new Exit(15,29));

        boolean checkjackexitdoor = map.checkJackOnExitDoor();

        assertTrue(checkjackexitdoor);



    }


    @Test
    public void testCheckJackOnExitDoorFalse(){
        boolean checkjackexitdoor = map.checkJackOnExitDoor();

        map.setExit(null);

        assertFalse(checkjackexitdoor);
    }
}