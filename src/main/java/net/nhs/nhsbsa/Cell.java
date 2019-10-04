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

        neighbourCells.add(new Cell(x-1 ,y-1));
        neighbourCells.add(new Cell(x-1, y));
        neighbourCells.add(new Cell(x-1,y+1));
        neighbourCells.add(new Cell(x,y-1));
        neighbourCells.add(new Cell(x,y+1));
        neighbourCells.add(new Cell(x+1,y-1));
        neighbourCells.add(new Cell(x+1,y));
        neighbourCells.add(new Cell(x+1,y+1));

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
