package uk.co.jimbodev.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameOfLife
{

        int[][] grid = new int[20][20];



        GameOfLife(Cell... cells){

            for( int[] row : grid){
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

    public List<Cell> getDeathList() {
            List<Cell> deathList = new ArrayList<>();
        for (int i = 0; i < 19; i++){
            for(int j = 0; j < 19;j++){
                Cell next= new Cell(i,j);
                 if(has2OrLessAliveNeighboursAndIsAlive(next) || has4OrMoreAliveNeighboursAndIsAlive(next)){
                    deathList.add(next);
                }
            }
        }
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

    public boolean has2Or3AliveNeighboursandAlive(Cell cell) {
        return has2Or3AliveNeighbours(cell) && getCellState(cell.getXCoord(),cell.getYCoord()) == 1;
    }

    public boolean has4OrMoreAliveNeighboursAndIsAlive(Cell cell) {
        return has4OrMoreAliveNeighbours(cell) && getCellState(cell.getXCoord(),cell.getYCoord()) == 1;
    }

    public boolean has3AliveNeighboursAndIsDead(Cell cell) {
        return has3AliveNeighbours(cell) && getCellState(cell.getXCoord(),cell.getYCoord()) == 0;
    }

    public List<Cell> getBirthList() {
        List<Cell> birthList = new ArrayList<>();
        for (int i = 0; i < 19; i++){
            for(int j = 0; j < 19;j++){
                Cell next= new Cell(i,j);
                if(has3AliveNeighboursAndIsDead(next)){

                    birthList.add(next);
                }
            }
        }
        return birthList;
    }

    public int[][] nextTick(List<Cell> births, List<Cell> deaths) {
            List<Cell> changedStates = births;
            changedStates.addAll(deaths);

        for (Cell state : changedStates){
            setCellState(state.getXCoord(),state.getYCoord());
        }
            return this.grid;
        }




}
