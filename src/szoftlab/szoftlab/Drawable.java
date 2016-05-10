package szoftlab;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drawable {
    public int posX,posY;
    private BufferedImage image = null;
    private boolean isSprite = false;
    private int state = 0;
    private int type = 0;
    private int size;
    private boolean alignCenter = false;
    public boolean visible = true;

    public void setState(Item.Direction dir,int type){
        if(dir == Item.Direction.up)   this.state = 1;
        if(dir == Item.Direction.down)  this.state = 2;
        if(dir == Item.Direction.right)  this.state = 0;
        if(dir == Item.Direction.left)  this.state = 3;
        this.type = type;
    }
    public void loadSprite(String path,int size,boolean center){
        isSprite = true;
        this.size = size;
        this.alignCenter = center;
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
        if(image != null && visible){
            if(isSprite){
                if(alignCenter){
                    posX += size/2;
                    posY += size/2;
                }
                g.drawImage(image.getSubimage(type*size,state*size,size,size),posX,posY,null);
            }
            else{
                if(image.getWidth() < 64 || image.getHeight() < 64){
                    posX = posX+image.getWidth()/2;
                    posY = posY+image.getHeight()/2;
                }
                g.drawImage(image,posX,posY,null);

            }

        }
    }
}
