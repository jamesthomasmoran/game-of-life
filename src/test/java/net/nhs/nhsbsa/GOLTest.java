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

        List<Cell> neighbours = new ArrayList<Cell>(8);
        neighbours.add(new Cell(1 ,1));
        neighbours.add(new Cell(1, 2));
        neighbours.add(new Cell(1,3));
        neighbours.add(new Cell(2,1));
        neighbours.add(new Cell(2,3));
        neighbours.add(new Cell(3,1));
        neighbours.add(new Cell(3,2));
        neighbours.add(new Cell(3,3));


        assertThat(Primarycell.getNeighbours().toString(),is(neighbours.toString()));

    }

}
