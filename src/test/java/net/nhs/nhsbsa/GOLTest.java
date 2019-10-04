package net.nhs.nhsbsa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
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
        assertThat(Primarycell.getNeighbours().toString(),is(neighbours.toString()));

        assertThat(Primarycell2.getNeighbours().toString(), is(neighbours2.toString()));

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
        deathList.add(new Cell(1,0));


        assertThat(gOL.getDeathList().toString(), is(deathList.toString()));
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
        GameOfLife gOL = new GameOfLife(new Cell(1,1),new Cell(1,2),new Cell(2,2));

        assertThat(gOL.has2OrLessAliveNeighbours(new Cell(1,1)), is(true));
        assertThat(gOL.has2OrLessAliveNeighbours(new Cell(2,1)), is(false));
    }

}
