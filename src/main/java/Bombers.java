import java.util.Random;

public class Bombers extends Enemies{
    private final int width;
    private Bombs bomb;
    private int counter;
    private Position bombPos;

    public Bombers(int x, int y, String icon, char type, int width) {
        super(x, y, icon, type);
        this.counter = 0;
        this.width = width;

        this.bombPos = new Position(new Random().nextInt(width - 1) + 1, super.getPosition().getY());
    }

    public void bombActions(){
        checkBomb();
        if(getBomb() != null) setCounter(getCounter() + 1);
        if(getCounter() == 10) {
            getBomb().setIcon("g");
        }
        if(getCounter() == 14){
            setBombNull();
            setCounter(0);
            createBombPosition();
        }
    }

    public Bombs getBomb() {
        return bomb;
    }

    public void setBombNull() {
        this.bomb = null;
    }

    public void checkBomb(){
        if(this.getPosition().equals(bombPos)){
            bomb = new Bombs(bombPos.getX(), bombPos.getY(), "d");
        }
    }

    public void createBombPosition(){
        bombPos = new Position(new Random().nextInt(width - 1) + 1, this.getPosition().getY());
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public int getCounter(){ return counter; }
}
