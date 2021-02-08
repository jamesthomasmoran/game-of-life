package uk.co.jimbodev.gameoflife;

import javax.swing.*;
import java.awt.*;

public class RunGameOfLife {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(0,0,1000,700);
        frame.setLayout(new GridLayout(20,20));
        JLabel[][] label = new JLabel[20][20];
        for (int i = 0;i < 20; i++){
            for(int j = 0; j < 20; j++){

                 frame.add(new JButton());
            }
        }

        frame.setVisible(true);
        GameOfLife gOL = new GameOfLife(new Cell(0,0), new Cell(0,1), new Cell(1,0),
                new Cell(1,1), new Cell(2,2),new Cell(6,2),new Cell(7,2),new Cell(8,2),new Cell(9,2),
        new Cell(1,2), new Cell(3,2),new Cell(4,2),new Cell(5,2),new Cell(8,3),new Cell(9,3),
        new Cell(1,13), new Cell(5,8),new Cell(8,8),new Cell(8,7),new Cell(3,3),new Cell(15,6),
        new Cell(1,18), new Cell(14,15),new Cell(12,18),new Cell(3,7),new Cell(8,16));
        for(int i = 0; i < 30000; i++){
            for(int j =0;j < gOL.grid[j].length-1;j++){
                for(int k = 0; k <gOL.grid[k].length-1;k++){
                    if(gOL.grid[j][k] == 1){
                        JButton button= new JButton();
                        button.setBackground(Color.RED);
                        frame.add(button);
                    }
                    else{
                        JButton button= new JButton();
                        frame.add(button);
                    }

        }
            }
            System.out.println(gOL.grid);
            frame.getContentPane().repaint();
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){

            }

            frame.getContentPane().removeAll();

            gOL.nextTick(gOL.getBirthList(),gOL.getDeathList());



    }}
}
