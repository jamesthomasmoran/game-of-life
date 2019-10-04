package net.nhs.nhsbsa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class GOLTest
{
    @Test
    public void cellCanBeAliveOrDead(){
        GameOfLife gOL = new GameOfLife(new Cell(0,0));

        assertThat(gOL.getCellState(0,0),is(1));
        assertThat(gOL.getCellState(0,1), is(0));
    }

    @Test
    public void getCellCoords(){
        Cell testCell = new Cell(2,5);
        assertThat(testCell.getXCoord(), is(2));
        assertThat(testCell.getYCoord(), is(5));
    }

}
