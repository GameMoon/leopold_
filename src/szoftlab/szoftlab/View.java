package szoftlab;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel{
    private Program game;
    public JFrame jframe;
    private static int stepSize = 64;
    public View(Program game,JFrame jframe){
        this.game = game;
        this.jframe = jframe;
    }
    public Dimension getPreferredSize() {
        return new Dimension(64*game.mapSizeX,64*game.mapSizeY);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(game.oneil.score >= game.oneil.maxscore) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("ONEIL WON",230,200);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g.drawString("Press T to exit!",240,300);
        }
        else if(game.jaffa.score >= game.jaffa.maxscore){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("JAFFA WON",230,200);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g.drawString("Press T to exit!",240,300);
        }
        else{
            for (int x = 0; x < game.mapSizeX; x++) {
                for (int y = 0; y < game.mapSizeY; y++) {
                    game.map[x][y].drawable.draw(g, x * stepSize, y * stepSize);
                   // g.drawString(game.map[x][y].getItems().size() + ".", x * 64 + 10, y * 64 + 10);

                    for (Item item : game.map[x][y].getItems()) {
                        item.drawable.draw(g, x * stepSize, y * stepSize);
                    }
                }
            }
            g.setColor(Color.WHITE);
            g.drawString("ONEIL SCORE: " + game.oneil.score, 20, 30);
            g.drawString("JAFFA SCORE: " + game.jaffa.score, 20, 50);
        }
    }
}
