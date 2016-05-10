package szoftlab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

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
        //-----Control of Colonel----
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            game.oneil.shoot();
        }
        else if(e.getKeyCode() == KeyEvent.VK_Q){
            game.oneil.changeColor();
        }
        else if(e.getKeyCode() == KeyEvent.VK_E){
            if(game.oneil.hand.hasBox()) game.oneil.putDown();
            else game.oneil.pickUp();
        }
        else if(e.getKeyCode() == KeyEvent.VK_W){
            game.oneil.step();
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            if(game.oneil.dir == Item.Direction.up) game.oneil.rotate(Item.Direction.right);
            else if(game.oneil.dir == Item.Direction.right) game.oneil.rotate(Item.Direction.down);
            else if(game.oneil.dir == Item.Direction.down) game.oneil.rotate(Item.Direction.left);
            else if(game.oneil.dir == Item.Direction.left) game.oneil.rotate(Item.Direction.up);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            if(game.oneil.dir == Item.Direction.up) game.oneil.rotate(Item.Direction.left);
            else if(game.oneil.dir == Item.Direction.left) game.oneil.rotate(Item.Direction.down);
            else if(game.oneil.dir == Item.Direction.down) game.oneil.rotate(Item.Direction.right);
            else if(game.oneil.dir == Item.Direction.right) game.oneil.rotate(Item.Direction.up);
        }


        //----Control of Jaffa---

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            game.jaffa.shoot();
        }
        else if(e.getKeyCode() == KeyEvent.VK_O){
            game.jaffa.changeColor();
        }
        else if(e.getKeyCode() == KeyEvent.VK_P){
            if(game.jaffa.hand.hasBox()) game.jaffa.putDown();
            else game.jaffa.pickUp();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            game.jaffa.step();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(game.jaffa.dir == Item.Direction.up) game.jaffa.rotate(Item.Direction.right);
            else if(game.jaffa.dir == Item.Direction.right) game.jaffa.rotate(Item.Direction.down);
            else if(game.jaffa.dir == Item.Direction.down) game.jaffa.rotate(Item.Direction.left);
            else if(game.jaffa.dir == Item.Direction.left) game.jaffa.rotate(Item.Direction.up);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(game.jaffa.dir == Item.Direction.up) game.jaffa.rotate(Item.Direction.left);
            else if(game.jaffa.dir == Item.Direction.left) game.jaffa.rotate(Item.Direction.down);
            else if(game.jaffa.dir == Item.Direction.down) game.jaffa.rotate(Item.Direction.right);
            else if(game.jaffa.dir == Item.Direction.right) game.jaffa.rotate(Item.Direction.up);
        }

        //------
        else if(e.getKeyCode() == KeyEvent.VK_T){
            if(game.oneil.score >= game.oneil.maxscore || game.jaffa.score >= game.jaffa.maxscore){
               view.jframe.dispatchEvent(new WindowEvent(view.jframe, WindowEvent.WINDOW_CLOSING));
            }
        }

        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
