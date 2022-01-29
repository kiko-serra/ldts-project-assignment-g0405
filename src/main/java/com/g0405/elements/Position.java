package com.g0405.elements;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }

    public Position moveUp() {
        return new Position(getX(), getY() - 1);
    }
    public Position moveDown() {
        return new Position(getX(), getY() + 1);
    }
    public Position moveLeft() {
        return new Position(getX() - 1, getY());
    }
    public Position moveRight() {
        return new Position(getX() + 1, getY());
    }

    public boolean equals(Position pos) {
        if (this == pos) return true;
        if (pos == null) return false;
        if (getClass() != pos.getClass()) return false;

        return x == pos.getX() && y == pos.getY();
    }
}
