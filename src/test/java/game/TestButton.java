package game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.io.IOException;

public class TestButton {

    Button button;


    @BeforeEach
    public void setUp()  {
        button = new Button(10, "abc", "#171717", 10);

    }

    @Test
    public void testButtonChangeColor(){
        button.changeColor("#000000");
        assertEquals("#000000",button.getColor());
    }
}
