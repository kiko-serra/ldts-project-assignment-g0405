<<<<<<< HEAD:src/test/java/com/g0405/characters/TestPrincess.java
package com.g0405.characters;

import com.g0405.elements.components.characters.Princess;
import com.g0405.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrincess {

    Princess princess;
    Princess princess1;

    @BeforeEach
    public void princessConstructor(){
         princess  = Mockito.mock(Princess.class);
         princess1 = new Princess(10,20);
    }

    @Test
    public void testPrincessConstructor(){

        assertEquals(10, princess1.getPosition().getX());
        assertEquals(20, princess1.getPosition().getY());

    }

    @Test
    public void testPrincessSetJackPosition(){

        Position position = new Position(10,10);

        princess.setJackPosition(position);
        Mockito.verify(princess).setJackPosition(position);

    }


    @Test
    public void testPrincessGetJackPosition(){
        assertEquals(0,princess1.getJackPosition().getX());
        assertEquals(0,princess1.getJackPosition().getY());
    }
}
=======
package com.g0405.components.characters;

import com.g0405.elements.components.characters.Princess;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g0405.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrincess {

    Princess princess;
    Princess princess1;
    TextGraphics tg;
    TextColor tc;

    @BeforeEach
    public void setUp(){
         princess  = Mockito.mock(Princess.class);
         princess1 = new Princess(10,20);
         tc = TextColor.Factory.fromString("#171717");
         tg = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testPrincessConstructor(){

        assertEquals(10, princess1.getPosition().getX());
        assertEquals(20, princess1.getPosition().getY());

    }

    @Test
    public void testPrincessSetJackPosition(){

        Position position = new Position(10,10);

        princess.setJackPosition(position);
        Mockito.verify(princess).setJackPosition(position);

    }


    @Test
    public void testPrincessGetJackPosition(){
        assertEquals(0,princess1.getJackPosition().getX());
        assertEquals(0,princess1.getJackPosition().getY());
    }


    @Test
    public void testPrincessDrawSetBackgroundColor(){
        princess1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(tc);

    }

    @Test
    public void testPrincessDrawPutString(){
        princess1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"f");
    }
}
>>>>>>> pitest:src/test/java/com/g0405/components/characters/TestPrincess.java
