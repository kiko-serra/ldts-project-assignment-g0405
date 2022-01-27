<<<<<<< HEAD
package game;

import com.googlecode.lanterna.input.KeyStroke;
import elements.components.Lives;
import elements.components.Points;
import elements.Position;
import elements.components.*;
import elements.components.characters.JackTheSparrow;
import elements.components.characters.Princess;
import elements.components.characters.enemies.Bombers;
import elements.components.characters.enemies.Pirates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.lanterna.input.KeyType.ArrowDown;
import static org.junit.jupiter.api.Assertions.*;

public class TestMap {


    private List<Biscuits> biscuits;
    private List<Borders> prison;
    private List<Pirates> pirates;
    private List<Bombers> bombers;
    private Key key;
    private Exit exit;
    private Points points;
    private JackTheSparrow jack1;
    private Princess princess1;
    private Map map;


    private Borders border;
    private Borders border1;
    private Borders border2fail;

    private Biscuits biscuit;
    private Biscuits biscuit1;
    private Biscuits biscuit2fail;
    private Biscuits biscuit3fail;

    private Borders prisonb;
    private Borders prison1;
    private Borders prison2;
    private Borders prison3fail;

    private Pirates pirate;
    private Pirates pirate1;
    private Pirates pirate3;
    private Pirates pirate2fail;

    private Bombers bomber;
    private Bombers bomber1;
    private Bombers bomber2fail;


    @BeforeEach
    public void setUp(){

       prison = new ArrayList<>();
       pirates = new ArrayList<>();
       bombers = new ArrayList<>();
       biscuits = new ArrayList<>();

       border = new Borders(1,30);
       border1 = new Borders(2,30);
       border2fail = new Borders(4,25);

       biscuit = new Biscuits(10,10);
       biscuit1 = new Biscuits(5,26);
       biscuit2fail = new Biscuits(1,30);
       biscuit3fail = new Biscuits(4,25);

       prisonb = new Borders(17,4);
       prison1 = new Borders(13,4);
       prison2 = new Borders(13,1);
       prison3fail = new Borders(7,10);

       pirate = new Pirates(10,10,"p",'P');
       pirate1 = new Pirates(4,11,"q",'P');
       pirate3 = new Pirates(6,14,"q",'P');
       pirate2fail = new Pirates(15,2,"q",'P');

       bomber = new Bombers(5,10,"l",'M',30);
       bomber1 = new Bombers(7,10,"m",'M',30);
       bomber2fail = new Bombers(4,25,"m",'M',30);

       key = new Key(10,10);
       exit = new Exit(15,29);

       jack1 = new JackTheSparrow(15,28);
       princess1 = new Princess(15,17);

       map = new Map(30,30);

    }

    @Test
    public void testMapConstructor(){
        assertEquals(15,map.jack.getPosition().getX());
        assertEquals(28,map.jack.getPosition().getY());
    }


    @Test
    public void testCreateBorders(){
        boolean bordersdone = true;

        for(Borders bord : map.getBorders()){
            Position bordpos = new Position(0,0);
            Position oldpos = bord.getPosition();
            if(oldpos == bordpos){
                bordersdone = false;
                break;
            }
            bordpos.setY(bord.getPosition().getY());
            bordpos.setX(bord.getPosition().getX());

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
        biscuits1.add(biscuit2fail);
        biscuits1.add(biscuit3fail);

        map.setBiscuits(biscuits1);

        assertEquals(biscuits1,map.getBiscuits());
    }

    @Test
    public void testCreatePrison(){
        boolean prisondone = true;

        for(Borders prison : map.getPrison()){
            Position prisonpos = new Position(0,0);
            Position oldpos = prison.getPosition();
            if(oldpos == prisonpos){
                prisondone = false;
                break;
            }
            prisonpos.setY(prison.getPosition().getY());
            prisonpos.setX(prison.getPosition().getX());

            if((oldpos.getX() > 17 && oldpos.getX() < 13) || (oldpos.getY() > 4 || oldpos.getY() < 0)){
                prisondone = false;
                break;
            }

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
            if(live instanceof Lives) continue;
            livesdone = false;
        }
        assertEquals(3,map.getLives().size());
        assertTrue(livesdone);
    }

    @Test
    public void testCheckPosition(){

       List<Biscuits> auxbiscuits = map.getBiscuits();

       boolean checkpos = true;
       prison.add(prisonb);
       prison.add(prison1);
       prison.add(prison2);

       for(Borders border : prison){
           if(!map.checkPosition(border,map.getBiscuits())){
               checkpos = false;
               break;
           }
       }

       //assertTrue(checkpos);


       checkpos = true;
       pirates.add(pirate);
       pirates.add(pirate1);
       pirates.add(pirate3);

        for(Pirates pirate : pirates){
            if(!map.checkPosition(pirate,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertTrue(checkpos);

        pirates.add(pirate2fail);

        for(Pirates pirate : pirates){
            if(!map.checkPosition(pirate,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertFalse(checkpos);


        checkpos = true;

        biscuits.add(biscuit);
        biscuits.add(biscuit1);
        map.setBiscuits(biscuits);

        bombers.add(bomber);
        bombers.add(bomber1);

        for(Bombers bomber : bombers){
            if(!map.checkPosition(bomber,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertTrue(checkpos);


        bombers.add(bomber2fail);

        for(Bombers bomber : bombers){
            if(map.checkPosition(bomber,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertFalse(checkpos);

        checkpos = true;
        map.setBiscuits(auxbiscuits);
        biscuits.add(biscuit2fail);
        biscuits.add(biscuit3fail);

        for(Biscuits biscuit : biscuits){
            if(map.checkPosition(biscuit,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertFalse(checkpos);

    }

    @Test
    public void testKeyStrokes(){

        KeyStroke stroke = new KeyStroke(ArrowDown);
        map.jack.setPosition(new Position(10,10));
        map.keyStrokes(stroke);

        assertEquals(10,map.princess.getJackPosition().getX());
        assertEquals(10,map.princess.getJackPosition().getY());
        assertEquals(ArrowDown,map.jack.getDirection());
        assertNotEquals(9,map.jack.getPosition().getY());


    }

    @Test
    public void testMoveJack(){
        map.jack.setPosition(new Position(10,10));
        map.jack.setJackDirection(ArrowDown);
        map.moveJack(ArrowDown);
        assertFalse(map.jack.canJackMove(map.getBorders(),map.getPrison()));
        assertEquals(11,map.jack.getPosition().getY());
    }


    @Test
    public void testMoveEnemies(){

        map.jack.setPosition(new Position(10,10));
        map.setBombers(bombers);

        map.getLives().remove(0);
        map.getLives().remove(0);
        map.getLives().remove(0);

        map.jack.setLives();
        map.jack.setLives();
        map.jack.setLives();

        boolean checkjack = map.moveEnemies();

        assertTrue(checkjack);


    }


    @Test
    public void testCheckJackColision(){
        map.jack.setPosition(new Position(10,10));
        map.checkJackColision(pirate);
        assertEquals(2,map.getLives().size());
        assertEquals(2,map.jack.getLives());
    }

    @Test
    public void testJackAround(){
        map.jack.setPosition(new Position(10,10));
        Bombs bomb = new Bombs(10,10,"d");
        boolean checkjackaround = map.checkJackAround(bomb);

        assertTrue(checkjackaround);

        map.jack.setPosition(new Position(8,10));
        checkjackaround = map.checkJackAround(bomb);

        assertFalse(checkjackaround);

    }


    @Test

    public void testEatBiscuits(){
        map.jack.setPosition(new Position(10,10));
        List<Biscuits> aux = map.getBiscuits();

        aux.add(new Biscuits(10,10));
        map.setBiscuits(aux);

        map.eatBiscuits();

        assertEquals(5,map.getBiscuits().size());
        assertEquals(1,map.getPoints().getPoints());
        assertEquals(1,map.jack.getPoints());
    }

    @Test
    public void testCollectKey(){

        Position openprison = new Position(15,4);
        boolean checkopenprison = true;
        map.jack.setPosition(new Position(10,10));
        map.setKey(new Key(10,10));

        map.collectKey();

        assertNull(map.getKey());


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
        map.jack.setPosition(new Position(15,3));


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
    public void testCheckJackOnExitDoor(){
        map.jack.setPosition(new Position(15,29));
        map.setExit(new Exit(15,29));

        boolean checkjackexitdoor = map.checkJackOnExitDoor();

        assertTrue(checkjackexitdoor);


        map.setExit(null);
        checkjackexitdoor = map.checkJackOnExitDoor();

        assertFalse(checkjackexitdoor);
    }

}
=======
package game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import elements.Lives;
import elements.Points;
import elements.Position;
import elements.components.*;
import elements.components.characters.JackTheSparrow;
import elements.components.characters.Princess;
import elements.components.characters.enemies.Bombers;
import elements.components.characters.enemies.Pirates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;

import static com.googlecode.lanterna.input.KeyType.ArrowDown;
import static org.junit.jupiter.api.Assertions.*;

public class TestMap {


    private List<Biscuits> biscuits;
    private List<Borders> prison;
    private List<Pirates> pirates;
    private List<Bombers> bombers;
    private Key key;
    private Exit exit;
    private Points points;
    private JackTheSparrow jack1;
    private Princess princess1;
    private Map map;


    private Borders border;
    private Borders border1;
    private Borders border2fail;

    private Biscuits biscuit;
    private Biscuits biscuit1;
    private Biscuits biscuit2fail;
    private Biscuits biscuit3fail;

    private Borders prisonb;
    private Borders prison1;
    private Borders prison2;
    private Borders prison3fail;

    private Pirates pirate;
    private Pirates pirate1;
    private Pirates pirate3;
    private Pirates pirate2fail;

    private Bombers bomber;
    private Bombers bomber1;
    private Bombers bomber2fail;


    @BeforeEach
    public void setUp(){

       prison = new ArrayList<>();
       pirates = new ArrayList<>();
       bombers = new ArrayList<>();
       biscuits = new ArrayList<>();

       border = new Borders(1,30);
       border1 = new Borders(2,30);
       border2fail = new Borders(4,25);

       biscuit = new Biscuits(10,10);
       biscuit1 = new Biscuits(5,26);
       biscuit2fail = new Biscuits(1,30);
       biscuit3fail = new Biscuits(4,25);

       prisonb = new Borders(17,4);
       prison1 = new Borders(13,4);
       prison2 = new Borders(13,1);
       prison3fail = new Borders(7,10);

       pirate = new Pirates(10,10,"p",'P');
       pirate1 = new Pirates(4,11,"q",'P');
       pirate3 = new Pirates(6,14,"q",'P');
       pirate2fail = new Pirates(15,2,"q",'P');

       bomber = new Bombers(5,10,"l",'M',30);
       bomber1 = new Bombers(7,10,"m",'M',30);
       bomber2fail = new Bombers(4,25,"m",'M',30);

       key = new Key(10,10);
       exit = new Exit(15,29);

       jack1 = new JackTheSparrow(15,28);
       princess1 = new Princess(15,17);

       map = new Map(30,30);

    }

    @Test
    public void testMapConstructor(){
        assertEquals(15,map.jack.getPosition().getX());
        assertEquals(28,map.jack.getPosition().getY());
    }


    @Test
    public void testCreateBorders(){
        boolean bordersdone = true;

        for(Borders bord : map.getBorders()){
            Position bordpos = new Position(0,0);
            Position oldpos = bord.getPosition();
            if(oldpos == bordpos){
                bordersdone = false;
                break;
            }
            bordpos.setY(bord.getPosition().getY());
            bordpos.setX(bord.getPosition().getX());

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
        biscuits1.add(biscuit2fail);
        biscuits1.add(biscuit3fail);

        map.setBiscuits(biscuits1);

        assertEquals(biscuits1,map.getBiscuits());
    }

    @Test
    public void testCreatePrison(){
        boolean prisondone = true;

        for(Borders prison : map.getPrison()){
            Position prisonpos = new Position(0,0);
            Position oldpos = prison.getPosition();
            if(oldpos == prisonpos){
                prisondone = false;
                break;
            }
            prisonpos.setY(prison.getPosition().getY());
            prisonpos.setX(prison.getPosition().getX());

            if((oldpos.getX() > 17 && oldpos.getX() < 13) || (oldpos.getY() > 4 || oldpos.getY() < 0)){
                prisondone = false;
                break;
            }

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
            if(live instanceof Lives) continue;
            livesdone = false;
        }
        assertEquals(3,map.getLives().size());
        assertTrue(livesdone);
    }

    @Test
    public void testCheckPosition(){

       List<Biscuits> auxbiscuits = map.getBiscuits();

       boolean checkpos = true;
       prison.add(prisonb);
       prison.add(prison1);
       prison.add(prison2);

       for(Borders border : prison){
           if(!map.checkPosition(border,map.getBiscuits())){
               checkpos = false;
               break;
           }
       }

       //assertTrue(checkpos);


       checkpos = true;
       pirates.add(pirate);
       pirates.add(pirate1);
       pirates.add(pirate3);

        for(Pirates pirate : pirates){
            if(!map.checkPosition(pirate,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertTrue(checkpos);

        pirates.add(pirate2fail);

        for(Pirates pirate : pirates){
            if(!map.checkPosition(pirate,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertFalse(checkpos);


        checkpos = true;

        biscuits.add(biscuit);
        biscuits.add(biscuit1);
        map.setBiscuits(biscuits);

        bombers.add(bomber);
        bombers.add(bomber1);

        for(Bombers bomber : bombers){
            if(!map.checkPosition(bomber,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertTrue(checkpos);


        bombers.add(bomber2fail);

        for(Bombers bomber : bombers){
            if(map.checkPosition(bomber,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertFalse(checkpos);

        checkpos = true;
        map.setBiscuits(auxbiscuits);
        biscuits.add(biscuit2fail);
        biscuits.add(biscuit3fail);

        for(Biscuits biscuit : biscuits){
            if(map.checkPosition(biscuit,map.getBiscuits())){
                checkpos = false;
                break;
            }
        }
        assertFalse(checkpos);

    }

    @Test
    public void testKeyStrokes(){

        KeyStroke stroke = new KeyStroke(ArrowDown);
        map.jack.setPosition(new Position(10,10));
        map.keyStrokes(stroke);

        assertEquals(10,map.princess.getJackPosition().getX());
        assertEquals(10,map.princess.getJackPosition().getY());
        assertEquals(ArrowDown,map.jack.getDirection());
        assertNotEquals(9,map.jack.getPosition().getY());


    }

    @Test
    public void testMoveJack(){
        map.jack.setPosition(new Position(10,10));
        map.jack.setJackDirection(ArrowDown);
        map.moveJack(ArrowDown);
        assertFalse(map.jack.canJackMove(map.getBorders(),map.getPrison()));
        assertEquals(11,map.jack.getPosition().getY());
    }


    @Test
    public void testMoveEnemies(){

        map.jack.setPosition(new Position(10,10));
        map.setBombers(bombers);

        map.getLives().remove(0);
        map.getLives().remove(0);
        map.getLives().remove(0);

        map.jack.setLives();
        map.jack.setLives();
        map.jack.setLives();

        boolean checkjack = map.moveEnemies();

        assertTrue(checkjack);


    }


    @Test
    public void testCheckJackColision(){
        map.jack.setPosition(new Position(10,10));
        map.checkJackColision(pirate);
        assertEquals(2,map.getLives().size());
        assertEquals(2,map.jack.getLives());
    }

    @Test
    public void testJackAround(){
        map.jack.setPosition(new Position(10,10));
        Bombs bomb = new Bombs(10,10,"d");
        boolean checkjackaround = map.checkJackAround(bomb);

        assertTrue(checkjackaround);

        map.jack.setPosition(new Position(8,10));
        checkjackaround = map.checkJackAround(bomb);

        assertFalse(checkjackaround);

    }


    @Test

    public void testEatBiscuits(){
        map.jack.setPosition(new Position(10,10));
        List<Biscuits> aux = map.getBiscuits();

        aux.add(new Biscuits(10,10));
        map.setBiscuits(aux);

        map.eatBiscuits();

        assertEquals(5,map.getBiscuits().size());
        assertEquals(1,map.getPoints().getPoints());
        assertEquals(1,map.jack.getPoints());
    }

    @Test
    public void testCollectKey(){

        Position openprison = new Position(15,4);
        boolean checkopenprison = true;
        map.jack.setPosition(new Position(10,10));
        map.setKey(new Key(10,10));

        map.collectKey();

        assertNull(map.getKey());


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
        map.jack.setPosition(new Position(15,3));


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
    public void testCheckJackOnExitDoor(){
        map.jack.setPosition(new Position(15,29));
        map.setExit(new Exit(15,29));

        boolean checkjackexitdoor = map.checkJackOnExitDoor();

        assertTrue(checkjackexitdoor);


        map.setExit(null);
        checkjackexitdoor = map.checkJackOnExitDoor();

        assertFalse(checkjackexitdoor);
    }

}
>>>>>>> pitestmeu
