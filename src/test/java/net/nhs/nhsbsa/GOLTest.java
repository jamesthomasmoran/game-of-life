package net.nhs.nhsbsa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GOLTest
{
    @Test
    public void cellCanBeAliveOrDead(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0), new Cell(5,8));

        assertThat(gOL.getCellState(0,0),is(1));
        assertThat(gOL.getCellState(0,1), is(0));
        assertThat(gOL.getCellState(5,8),is(1));

    }

    @Test
    public void getCellCoords(){
        Cell testCell = new Cell(2,5);

        assertThat(testCell.getXCoord(), is(2));
        assertThat(testCell.getYCoord(), is(5));
    }

    @Test
    public void getNeighbourCoords(){
        Cell Primarycell = new Cell(2, 2);
        Cell Primarycell2 = new Cell(3, 2);
        Cell Primarycell3 = new Cell(0, 2);

        List<Cell> neighbours = new ArrayList<Cell>(8);
        neighbours.add(new Cell(1 ,1));
        neighbours.add(new Cell(1, 2));
        neighbours.add(new Cell(1,3));
        neighbours.add(new Cell(2,1));
        neighbours.add(new Cell(2,3));
        neighbours.add(new Cell(3,1));
        neighbours.add(new Cell(3,2));
        neighbours.add(new Cell(3,3));


        List<Cell> neighbours2 = new ArrayList<Cell>(8);
        neighbours2.add(new Cell(2 ,1));
        neighbours2.add(new Cell(2, 2));
        neighbours2.add(new Cell(2,3));
        neighbours2.add(new Cell(3,1));
        neighbours2.add(new Cell(3,3));
        neighbours2.add(new Cell(4,1));
        neighbours2.add(new Cell(4,2));
        neighbours2.add(new Cell(4,3));


        List<Cell> neighbours3 = new ArrayList<Cell>(8);
        neighbours3.add(new Cell(0,1));
        neighbours3.add(new Cell(0,3));
        neighbours3.add(new Cell(1,1));
        neighbours3.add(new Cell(1,2));
        neighbours3.add(new Cell(1,3));

        assertThat(
                Primarycell.getNeighbours().toString(),is(neighbours.toString()));
        assertThat(
                Primarycell2.getNeighbours().toString(), is(neighbours2.toString()));
        assertThat(
                Primarycell3.getNeighbours().toString(), is(neighbours3.toString()));
    }

    @Test
    public void addCellToGameGrid(){
        GameOfLife gOL = new GameOfLife(new Cell(6,7));

        assertThat(gOL.getCellState(6,7), is(1));
    }

    @Test
    public void changeCellState(){
        GameOfLife gOL = new GameOfLife((new Cell(7,2)));

        assertThat(gOL.setCellState(7, 2), is(0));
    }

    @Test
    public void getDeathList(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0), new Cell(0,1), new Cell(1,0),
                new Cell(1,1), new Cell(2,2));

        ArrayList<Cell> deathList = new ArrayList<Cell>();
        deathList.add(new Cell(1,1));
        deathList.add(new Cell(2,2));

        GameOfLife gOL2 = new GameOfLife(new Cell(0,1), new Cell(0,3), new Cell(1,0),
                new Cell(1,1), new Cell(2,3));

        ArrayList<Cell> deathList2 = new ArrayList<Cell>();
        deathList2.add(new Cell(0,3));
        deathList2.add(new Cell(2,3));

        assertThat(gOL.getDeathList().toString(), is(deathList.toString()));
        assertThat(gOL2.getDeathList().toString(), is(deathList2.toString()));
    }

    @Test
    public void returnAliveNeighbours(){
        GameOfLife gOL = new GameOfLife(new Cell(1,1),new Cell(1,2),new Cell(2,2),new Cell(2,1));

        ArrayList<Cell> aliveNeighbours = new ArrayList<Cell>();
        aliveNeighbours.add(new Cell(1,2));
        aliveNeighbours.add(new Cell(2,1));
        aliveNeighbours.add(new Cell(2,2));

        gOL.setCellState(6,7);

        ArrayList<Cell> aliveNeighbours2 = new ArrayList<Cell>();

        assertThat(gOL.getAliveNeighbours(new Cell(1,1)).toString(), is(aliveNeighbours.toString()));
        assertThat(gOL.getAliveNeighbours(new Cell(6,7)).toString(), is(aliveNeighbours2.toString()));
    }

    @Test
    public void checkIfCellHasLessThan2Neighbours(){
        GameOfLife gOL = new GameOfLife(new Cell(1,1),new Cell(2,2));

        assertThat(gOL.has2OrLessAliveNeighbours(new Cell(1,1)), is(true));
        assertThat(gOL.has2OrLessAliveNeighbours(new Cell(2,1)), is(false));
    }

    @Test
    public void checkIfCellHas2Or3neighbors(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0),new Cell(0,1),new Cell(0,2),new Cell(1,2),new Cell(2,3));

        assertThat(gOL.has2Or3AliveNeighbours(new Cell(1,1)), is(false));
        assertThat(gOL.has2Or3AliveNeighbours(new Cell(2,2)), is(true));
        assertThat(gOL.has2Or3AliveNeighbours(new Cell(2,0)), is(false));
    }

    @Test
    public void checkIfCellHas4OrMoreLiveNeighbours(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0),new Cell(0,1),new Cell(0,2),new Cell(1,2),new Cell(2,3));

        assertThat(gOL.has4OrMoreAliveNeighbours(new Cell(1,1)), is(true));
        assertThat(gOL.has4OrMoreAliveNeighbours(new Cell(2,2)), is(false));
        assertThat(gOL.has4OrMoreAliveNeighbours(new Cell(2,0)), is(false));
    }

    @Test
    public void checkIfCellHasExactly3LiveNeighbours(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0),new Cell(0,1),new Cell(0,2),new Cell(1,2),new Cell(2,3), new Cell(1,1));

        assertThat(gOL.has3AliveNeighbours(new Cell(1,1)), is(false));
        assertThat(gOL.has3AliveNeighbours(new Cell(2,2)), is(true));
        assertThat(gOL.has3AliveNeighbours(new Cell(2,0)), is(false));
    }

    @Test
    public void checkIfCellHasLessThan2NeighboursAndIsAlive(){
        GameOfLife gOL = new GameOfLife(new Cell(1,1),new Cell(2,2));

        assertThat(gOL.has2OrLessAliveNeighboursAndIsAlive(new Cell(1,1)), is(true));
        assertThat(gOL.has2OrLessAliveNeighboursAndIsAlive(new Cell(2,1)), is(false));
        assertThat(gOL.has2OrLessAliveNeighboursAndIsAlive(new Cell(3,3)), is(false));
    }

    @Test
    public void checkIfCellHas2Or3NeighborsAndIsAlive(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0),new Cell(0,1),new Cell(2,2),new Cell(0,2),new Cell(1,2),new Cell(2,3));

        assertThat(gOL.has2Or3AliveNeighboursandAlive(new Cell(1,1)), is(false));
        assertThat(gOL.has2Or3AliveNeighboursandAlive(new Cell(2,2)), is(true));
        assertThat(gOL.has2Or3AliveNeighboursandAlive(new Cell(4,0)), is(false));
    }

    @Test
    public void checkIfCellHas4OrMoreLiveNeighboursAndIsAlive(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0),new Cell(0,1),new Cell(0,2),new Cell(1,2),new Cell(2,3),new Cell(1,1));

        assertThat(gOL.has4OrMoreAliveNeighboursAndIsAlive(new Cell(1,1)), is(true));
        assertThat(gOL.has4OrMoreAliveNeighboursAndIsAlive(new Cell(2,2)), is(false));
        assertThat(gOL.has4OrMoreAliveNeighboursAndIsAlive(new Cell(2,0)), is(false));
    }

    @Test
    public void checkIfCellHasExactly3LiveNeighboursAndIsDead(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0),new Cell(0,1),new Cell(0,2),new Cell(1,2),new Cell(2,3), new Cell(1,1),new Cell(2,4));

        assertThat(gOL.has3AliveNeighboursAndIsDead(new Cell(1,1)), is(false));
        assertThat(gOL.has3AliveNeighboursAndIsDead(new Cell(2,2)), is(true));
        assertThat(gOL.has3AliveNeighboursAndIsDead(new Cell(2,3)), is(false));
    }

    @Test
    public void returnAllCellsThatWillBecomeAliveNextTick(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0), new Cell(0,1), new Cell(1,0),
                new Cell(1,1), new Cell(2,2));


        GameOfLife gOL2 = new GameOfLife(new Cell(0,1), new Cell(0,3), new Cell(1,0),
                new Cell(1,1), new Cell(2,3));

        ArrayList<Cell> birthList = new ArrayList<Cell>();
        birthList.add(new Cell(1,2));
        birthList.add(new Cell(2,1));

        ArrayList<Cell> birthList2 = new ArrayList<Cell>();
        birthList2.add(new Cell(0,0));
        birthList2.add(new Cell(0,2));

        assertThat(
                gOL.getBirthList().toString(), is(birthList.toString()));
        assertThat(
                gOL2.getBirthList().toString(), is(birthList2.toString()));
    }

    @Test
    public void canRunNextTick(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0), new Cell(0,1), new Cell(1,0),
                new Cell(1,1), new Cell(2,2));

        ArrayList<Cell> birthList = new ArrayList<Cell>();
        birthList.add(new Cell(1,2));
        birthList.add(new Cell(2,1));

        GameOfLife gOL2 = new GameOfLife(new Cell(0,1), new Cell(0,3), new Cell(1,0),
                new Cell(1,1), new Cell(2,3));

        int[][] expectedGrid1 = new int[20][20];
        for(int i = 0; i < expectedGrid1.length; i++){
            Arrays.fill(expectedGrid1[i], 0);
        }
        expectedGrid1[0][0] = 1;
        expectedGrid1[0][1] = 1;
        expectedGrid1[1][0] = 1;
        expectedGrid1[1][2] = 1;
        expectedGrid1[2][1] = 1;

        assertThat(
                gOL.nextTick(gOL.getBirthList(),gOL.getDeathList()),is(expectedGrid1));
    }

}
