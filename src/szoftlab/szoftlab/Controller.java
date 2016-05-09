package szoftlab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener{
    private Program game;
    private View view;

    public Controller(Program game,View view){
        this.game = game;
        this.view = view;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            game.oneil.step();
        }
        else if(e.getKeyCode() == KeyEvent.VK_W){
            game.oneil.rotate(Item.Direction.left);
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            game.oneil.rotate(Item.Direction.up);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            game.oneil.rotate(Item.Direction.down);
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            game.oneil.rotate(Item.Direction.right);
        }

        view.revalidate();
        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
