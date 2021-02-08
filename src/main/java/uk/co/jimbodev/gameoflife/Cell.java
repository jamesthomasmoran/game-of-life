package uk.co.jimbodev.gameoflife;

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
        if(x > 0 && y > 0){
            neighbourCells.add(new Cell(x-1 ,y-1));
        }

        if(x > 0) {
            neighbourCells.add(new Cell(x - 1, y));
        }
        if(x > 0 && y <= 20) {
            neighbourCells.add(new Cell(x - 1, y + 1));
        }
        if(y > 0 ) {
            neighbourCells.add(new Cell(x, y - 1));
        }
        if(y <= 20) {
            neighbourCells.add(new Cell(x, y + 1));
        }
        if(x <= 20 && y > 0){
            neighbourCells.add(new Cell(x+1,y-1));
        }
        if(x <= 20) {
            neighbourCells.add(new Cell(x + 1, y));
        }
        if(x <= 20 && y <= 20)
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
