package Org;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private int x; //Максимальное значение поля: 287
    private Double y; //Максимальное значение поля: 864, Поле не может быть null

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

