package net.nhs.nhsbsa;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int x;
    private int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXCoord() {
        return x;
    }

    public int getYCoord() {
        return y;
    }

    public List<Cell> getNeighbours(){
        ArrayList<Cell> neighbourCells = new ArrayList<Cell>();

        neighbourCells.add(new Cell(1 ,1));
        neighbourCells.add(new Cell(1, 2));
        neighbourCells.add(new Cell(1,3));
        neighbourCells.add(new Cell(2,1));
        neighbourCells.add(new Cell(2,3));
        neighbourCells.add(new Cell(3,1));
        neighbourCells.add(new Cell(3,2));
        neighbourCells.add(new Cell(3,3));

        return neighbourCells;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
