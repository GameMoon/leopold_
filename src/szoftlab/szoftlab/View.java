package szoftlab;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel{
    private Program game;
    private static int stepSize = 64;
    public View(Program game){
        this.game = game;
    }
    public Dimension getPreferredSize() {
        return new Dimension(768,640);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int x = 0; x < game.mapSizeX;x++){
            for(int y = 0;y < game.mapSizeY;y++){
                game.map[x][y].drawable.draw(g,x*stepSize,y*stepSize);
                g.drawString(game.map[x][y].getItems().size()+".",x*64+32,y*64+32);
                for(Item item : game.map[x][y].getItems()){
                    item.drawable.draw(g,x*stepSize,y*stepSize);
                }
            }
        }
    }
}
