import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;


public class Pirates extends Components implements Characters{
    private int state;
    private Position position;
    private final int size;
    private String icon;

    public Pirates(int x, int y) {
        super(x, y);
        this.position = super.getPosition();
        //this.state= new Random().nextInt(2);
        this.state=0;
        this.size= new Random().nextInt(3);
        this.icon = " ";
    }

    public void setState(int state){
        if(state == 0 || state == 1)
            this.state=state;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#B00000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), icon);
    }

    public void move() {
        switch (state) {
            case 0:
                setPosition(position.moveRight());
                this.icon = "P";
                break;

            case 1:
                setPosition(position.moveLeft());
                //this.icon = "ꟼ";
                this.icon = "ᕋ";
                break;
        }
    }

    public void canPirateMove(int width){
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();

        if ((x==1 || (x==(width/2)+3 && y<=4)) && this.state==1) setState(0);

        if ((x==width-2 || (x==(width/2)-3 && y<=4))&& this.state==0) setState(1);
    }

    public int getState(){
        return state;
    }

    public int getSize(){return size;}

}

