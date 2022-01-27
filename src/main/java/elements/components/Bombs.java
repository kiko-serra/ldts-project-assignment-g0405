package elements.components;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import elements.Position;

public class Bombs extends Components {
    private Position position;
    private String icon;

    public Bombs(int x, int y, String icon) {
        super(x, y);
        this.icon = icon;
        this.position = super.getPosition();
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#EDD94C"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), icon);
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon(){
        return icon;
    }
}
