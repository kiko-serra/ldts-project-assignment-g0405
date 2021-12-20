public class Jack_The_Sparrow extends Components implements Characters{
    private Position position;

    public Jack_The_Sparrow(int x, int y){
        super(x, y);

        this.position = super.getPosition();
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public void draw() {

    }
}
