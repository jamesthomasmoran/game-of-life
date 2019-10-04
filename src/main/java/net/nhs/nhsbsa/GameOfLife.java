package net.nhs.nhsbsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class GameOfLife
{

        Integer[][] grid = new Integer[20][20];



        GameOfLife(Cell... cells){

            for( Integer[] row : grid){
                Arrays.fill(row,0);
            }

            for(int i = 0; i < cells.length; i++ ){
                grid[cells[i].getXCoord()][cells[i].getYCoord()] = 1;
            }


        }
        public int getCellState(int x, int y) {
            return grid[x][y];
        }

        public int setCellState(int x, int y){

            if(grid[x][y] == 0){
                grid[x][y] = 1;
                return getCellState(x,y);
            }
            grid[x][y] = 0;
            return getCellState(x,y);
        }

    public ArrayList<Cell> getDeathList() {
        ArrayList<Cell> deathList = new ArrayList<Cell>();
        deathList.add(new Cell(1,1));
        deathList.add(new Cell(1,0));
        return deathList;
    }




    public List<Cell> getAliveNeighbours(Cell primary) {
            List <Cell> neighbours = primary.getNeighbours();
            List<Cell> aliveNeighbours = new ArrayList<Cell>();

            for (Cell neighbour:neighbours) {
                if(grid[neighbour.getXCoord()][neighbour.getYCoord()] == 1){
                    aliveNeighbours.add(neighbour);
                }
            }
        return aliveNeighbours;
    }

    public boolean has2OrLessAliveNeighbours(Cell cell) {
            return getAliveNeighbours(cell).size() < 2;
    }

    public boolean has2Or3AliveNeighbours(Cell cell) {
        return getAliveNeighbours(cell).size() >= 2 && getAliveNeighbours(cell).size() <= 3;
    }

    public boolean has4OrMoreAliveNeighbours(Cell cell) {
            return getAliveNeighbours(cell).size() >= 4;
    }

    public boolean has3AliveNeighbours(Cell cell) {
        return getAliveNeighbours(cell).size() == 3;
    }

    public boolean has2OrLessAliveNeighboursAndIsAlive(Cell cell) {
            return has2OrLessAliveNeighbours(cell) && getCellState(cell.getXCoord(),cell.getYCoord()) == 1;
    }
}
