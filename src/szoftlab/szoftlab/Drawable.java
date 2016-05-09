package szoftlab;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drawable {
    public int posX,posY;
    private BufferedImage image = null;
    private boolean isCharacter = false;
    private int state = 0;

    public void loadCharacter(String path,Item.Direction dir){
        isCharacter = true;
        if(dir == Item.Direction.up)   this.state = 1;
        if(dir == Item.Direction.down)  this.state = 2;
        if(dir == Item.Direction.right)  this.state = 0;
        if(dir == Item.Direction.left)  this.state = 3;

        loadImage(path);
    }
    public void loadImage(String path){
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g,int posX,int posY){
        this.posX = posX;
        this.posY = posY;
        if(image != null){
            if(isCharacter)  g.drawImage(image.getSubimage(0,state*32,32,32),posX,posY,null);
            else  g.drawImage(image,posX,posY,null);

        }
    }
}
