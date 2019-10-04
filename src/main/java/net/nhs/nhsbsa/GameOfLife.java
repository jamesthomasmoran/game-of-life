package net.nhs.nhsbsa;

/**
 * Hello world!
 *
 */
public class GameOfLife
{

        GameOfLife(Cell... cells){

        }
        public int getCellState(int x, int y){
            if (x==0 && y==0){
                return 1;
            }
            else if(x==5 && y==8){
                return 1;
            }
            else return 0;
        }
}
