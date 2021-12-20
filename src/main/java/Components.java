public abstract class Components {
    private final Position position;

    public Components(int x, int y){
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }
}
