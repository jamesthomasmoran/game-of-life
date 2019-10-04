package net.nhs.nhsbsa;

import java.util.ArrayList;
import java.util.Arrays;

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
}
