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
    private Borders border2Fail;

    private Biscuits biscuit;
    private Biscuits biscuit1;
    private Biscuits biscuitPrisonFail;
    private Biscuits biscuitPirateFail;
    private Biscuits biscuitBomberFail;

    private Borders prisonBombers;
    private Borders prison1;
    private Borders prison2;
    private Borders prison3Fail;

    private Pirates pirate;
    private Pirates pirate1;
    private Pirates pirate3;
    private Pirates pirate2Fail;
    private Pirates pirateJackFail;

    private Bombers bomber;
    private Bombers bomber1;
    private Bombers bomber2Fail;
    private Bombers bomberJackFail;

    @BeforeEach
    public void setUp(){
       prison = new ArrayList<>();

       border = new Borders(1,30);
       border1 = new Borders(2,30);
       border2Fail = new Borders(4,25);

       biscuit = new Biscuits(10,10);
       biscuit1 = new Biscuits(5,26);
       biscuitPrisonFail = new Biscuits(17,4);
       biscuitPirateFail = new Biscuits(10,10);
       biscuitBomberFail = new Biscuits(7,10);

       prisonBombers = new Borders(17,4);
       prison1 = new Borders(13,4);
       prison2 = new Borders(13,1);
       prison3Fail = new Borders(7,10);

       pirate = new Pirates(10,10,"p",'P');
       pirate1 = new Pirates(4,11,"q",'P');
       pirate3 = new Pirates(6,14,"q",'P');
       pirateJackFail = new Pirates(11,10,"p",'P');
       pirate2Fail = new Pirates(15,2,"q",'P');

       bomber = new Bombers(5,10,"l",'M',30);
       bomber1 = new Bombers(7,10,"m",'M',30);
       bomber2Fail = new Bombers(4,25,"m",'M',30);
       bomberJackFail = new Bombers(11,10,"m",'M',30);

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
        boolean bordersDone = true;
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
            bordersDone = false;
        }

        assertTrue(bordersDone);
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
        borders1.add(border2Fail);

        map.setBorders(borders1);

        assertEquals(borders1,map.getBorders());
    }

    @Test
    public void testCreateBiscuits(){
        boolean biscuitsDone = true;
        List<Biscuits> aux = map.getBiscuits();

        for(Biscuits biscuit : aux){
            if(map.checkPosition(biscuit,aux)){
                biscuitsDone = false;
                break;
            }
        }

        assertTrue(biscuitsDone);
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
        biscuits1.add(biscuitPrisonFail);
        biscuits1.add(biscuitPirateFail);

        map.setBiscuits(biscuits1);

        assertEquals(biscuits1,map.getBiscuits());
    }

    @Test
    public void testCreatePrison(){
        boolean prisonDone = true;
        int counter = 0;

        for(Borders prison : map.getPrison()){
            if((prison.getPosition().getX() > 17 && prison.getPosition().getX() < 13) ||
                    (prison.getPosition().getY() > 4 || prison.getPosition().getY() < 0)){
                prisonDone = false;
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
            prisonDone = false;
        }

        assertTrue(prisonDone);

    }

    @Test
    public void testGetPrison(){
        List<Borders> prison1 = map.getPrison();

        assertEquals(prison1, map.getPrison());
    }

    @Test
    public void testSetPrison(){
        List<Borders> prison1 = new ArrayList<>();

        prison1.add(prisonBombers);
        prison1.add(prison2);
        prison1.add(prison3Fail);

        map.setPrison(prison1);

        assertEquals(prison1, map.getPrison());
    }

    @Test
    public void testCreateKey(){
        boolean keyDone = true;
        Key aux = map.getKey();

        if(!map.checkPosition(aux,map.getBiscuits())){
            keyDone = false;
        }

        assertTrue(keyDone);
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
        boolean piratesDone = true;
        List<Pirates> aux = map.getPirates();

        for(Pirates pirate : aux){
            if(!map.checkPosition(pirate,map.getBiscuits())){
                piratesDone = false;
                break;
            }
        }


        assertTrue(piratesDone);
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
        pirates1.add(pirate2Fail);
        pirates1.add(pirate3);

        map.setPirates(pirates1);

        assertEquals(pirates1,map.getPirates());
    }

    @Test
    public void testCreateBombers(){
        boolean bombersDone = true;
        List<Bombers> aux = map.getBombers();

        for(Bombers bomber : aux){
            if(!map.checkPosition(bomber,map.getBiscuits())){
                bombersDone = false;
            }
        }

        assertTrue(bombersDone);
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
        bombers1.add(bomber2Fail);


        map.setBombers(bombers1);

        assertEquals(bombers1, map.getBombers());
    }

    @Test
    public void testCreateLives(){
        boolean livesDone = true;
        for(Lives live : map.getLives()){
            if(live != null) continue;
            livesDone = false;
        }
        assertEquals(3,map.getLives().size());
        assertTrue(livesDone);
    }

    @Test
    public void testCheckPositionPrisonTrue() {
        boolean checkPos = true;
        prison.add(prisonBombers);
        prison.add(prison1);
        prison.add(prison2);

        for (Borders border : prison) {
            if (map.checkPosition(border, map.getBiscuits())) {
                checkPos = false;
                break;
            }
        }

        assertTrue(checkPos);
    }

    @Test
    public void testCheckPositionPrisonFalse() {
        List<Biscuits> auxBiscuits = map.getBiscuits();
        auxBiscuits.add(biscuitPrisonFail);

        boolean checkPos = true;
        prison.add(prisonBombers);
        prison.add(prison1);
        prison.add(prison2);

        for (Borders border : prison) {
            if (!map.checkPosition(border, auxBiscuits)) {
                checkPos = false;
                break;
            }
        }

        assertFalse(checkPos);
    }

    @Test
    public void testCheckPositionPirateTrue(){
        boolean checkPos = true;

        for(Pirates pirate : map.getPirates()){
            if(!map.checkPosition(pirate,map.getBiscuits())){
                checkPos = false;
                break;
            }
        }
        assertTrue(checkPos);
    }

    @Test
    public void testCheckPositionPirateFalse(){
        boolean checkPos = true;

        List<Biscuits> auxBiscuits = map.getBiscuits();
        auxBiscuits.add(biscuitPirateFail);

        List<Pirates> auxPirates = map.getPirates();

        auxPirates.add(pirate);

        map.setPirates(auxPirates);

        for(Pirates pirate : auxPirates){
            if(map.checkPosition(pirate,auxBiscuits)){
                checkPos = false;
                break;
            }
        }
        assertFalse(checkPos);
    }

    @Test
    public void testCheckPositionBomberTrue(){
        boolean checkPos = true;

        for(Bombers bomber : map.getBombers()){
            if(!map.checkPosition(bomber,map.getBiscuits())){
                checkPos = false;
                break;
            }
        }
        assertTrue(checkPos);
    }

    @Test
    public void testCheckPositionBomberFalse(){
        boolean checkPos = true;

        List<Biscuits> auxBiscuits = map.getBiscuits();
        auxBiscuits.add(biscuitBomberFail);

        List<Bombers> auxBombers = map.getBombers();
        auxBombers.add(bomber1);

        for(Bombers bomber : map.getBombers()){
            if(!map.checkPosition(bomber,map.getBiscuits())){
                checkPos = false;
                break;
            }
        }
        assertFalse(checkPos);
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

        boolean checkJack = map.moveEnemies();

        assertTrue(checkJack);
    }

    @Test
    public void testMoveEnemiesBomberActions(){
        map.getJack().setPosition(new Position(11,10));

        bomberJackFail.setBomb(new Bombs(10,10,"g"));
        bomberJackFail.setCounter(9);

        List<Bombers> auxBombers = map.getBombers();
        auxBombers.add(bomberJackFail);
        map.setBombers(auxBombers);

        map.moveEnemies();

        assertEquals(2,map.getLives().size());
        assertEquals(2,map.getJack().getLives());
    }

    @Test
    public void testCheckJackColisionPirate(){
        map.getJack().setPosition(new Position(11,10));
        map.checkJackColision(pirateJackFail);
        assertEquals(2,map.getLives().size());
        assertEquals(2,map.getJack().getLives());
    }

    @Test
    public void testCheckJackColisionBomber(){
        map.getJack().setPosition(new Position(11,10));
        map.checkJackColision(bomberJackFail);
        assertEquals(2,map.getLives().size());
        assertEquals(2,map.getJack().getLives());
    }

    @Test
    public void testJackAround(){
        map.getJack().setPosition(new Position(10,10));
        Bombs bomb = new Bombs(10,10,"d");
        boolean checkJackAround = map.checkJackAround(bomb);

        assertTrue(checkJackAround);

        map.getJack().setPosition(new Position(8,10));
        checkJackAround = map.checkJackAround(bomb);

        assertFalse(checkJackAround);
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
        Position openPrison = new Position(15,4);
        boolean checkOpenPrison = true;
        map.getJack().setPosition(new Position(10,10));
        map.setKey(new Key(10,10));

        for(Borders prison : map.getPrison()){
            if(prison.getPosition() == openPrison){
                checkOpenPrison = false;
                break;
            }
        }

        assertTrue(checkOpenPrison);
    }

    @Test
    public void testOpenExit(){
        Position openExit = new Position(15,29);
        boolean checkOpenExit = true;
        map.getJack().setPosition(new Position(15,3));

        map.openExit();

        for (Borders border : map.getBorders()){
            if(border.getPosition() == openExit){
                checkOpenExit = false;
                break;
            }
        }

        assertEquals(map.getExit().getPosition().getX(),openExit.getX());
        assertEquals(map.getExit().getPosition().getY(),openExit.getY());
        assertTrue(checkOpenExit);
    }

    @Test
    public void testCheckJackOnExitDoorTrue(){
        map.getJack().setPosition(new Position(15,29));
        map.setExit(new Exit(15,29));

        boolean checkJackExitDoor = map.checkJackOnExitDoor();

        assertTrue(checkJackExitDoor);

    }

    @Test
    public void testCheckJackOnExitDoorFalse(){
        boolean checkJackExitDoor = map.checkJackOnExitDoor();

        map.setExit(null);

        assertFalse(checkJackExitDoor);
    }
}