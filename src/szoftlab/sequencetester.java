import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class sequencetester {
    public static Map<String,Integer> calls = new HashMap<>();
    public static int tabindex = 0;
    public static boolean canPrint = false;
    public static Program game;

    public static void main(String[] args){

        game = new Program();
        System.out.println("Number of seqdiagram?");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;

        //Seqdiagram
        if(number == 0){
            canPrint = true;
            game.oneil.changeColor();
        }
        else if(number == 1){ //Oneil step
            canPrint = true;
            game.oneil.step();
        }
        else if(number == 2){ //Oneil pressing the Scale
            game.getMap()[0][1].add(new Scale(new Door()));
            canPrint = true;
            game.oneil.step();
        }
        else if(number == 3){ //Oneil releasing the Scale
            game.getMap()[0][0].add(new Scale(new Door()));
            canPrint = true;
            game.oneil.step();
        }
        else if(number == 4){ //Oneil going cross the Door
            openDoor();
            game.oneil.step();
        }
        else if(number == 5){ //Oneil blocked by the Door
            closedDoor();
            game.oneil.step();
        }
        else if(number == 6){ //Shot
            shoot();
            game.oneil.shoot();
        }
        else if(number == 7){ //openPortal
            openPortal();
            game.oneil.shoot();
        }
    }
    public static void printMethod(StackTraceElement[] elements){
        String fromMethod = elements[2].getMethodName();
        String methodName = elements[1].getMethodName();
        if(!canPrint) return;
        if(calls.containsKey(fromMethod)){
           for(int k = 0;k<calls.get(fromMethod);k++) System.out.print("\t");
            if(!calls.containsKey(methodName)){
                calls.put(methodName,calls.get(fromMethod)+1);
            }
        }
        else{
            tabindex++;
            calls.put(methodName,tabindex);
        }
        System.out.println(methodName+"()");
    }
    public static void openPortal(){
        canPrint = true;
    }
    public static void shoot(){
        game.getMap()[0][4].add(new Wall());
        canPrint = true;
    }
    public static void openDoor(){
        Door door = new Door();
        door.open();
        game.getMap()[0][1].add(door);
        canPrint = true;
    }
    public static void closedDoor(){
        Door door = new Door();
        door.close();
        game.getMap()[0][1].add(door);
        canPrint = true;
    }
}
