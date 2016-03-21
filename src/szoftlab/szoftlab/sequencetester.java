package szoftlab;

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

        System.out.println("1. Oneil step");
        System.out.println("2. Oneil pressing the Scale");
        System.out.println("3. Oneil releasing the Scale");
        System.out.println("4. Oneil going cross the Door");
        System.out.println("5. Oneil blocked by the Door");
        System.out.println("6. Oneil shoot");
        System.out.println("7. Portal open");
        System.out.println("8. Crossing portal");
        System.out.println("9. step into the rift");
        System.out.println("10. pickUp Box");
        System.out.println("11. putDown Box");
        System.out.println("12. pickUp ZPM");
        System.out.println("Number of seqdiagram?");
        
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int number = 12;
        try {
            number = Integer.parseInt(bfr.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        else if(number == 8){ //crossPortal
            crossPortal();
            game.oneil.step();
        }
        else if(number == 9){ // step into the rift
            rift();
            game.oneil.step();
        }
        else if(number == 10){ //pickup Box
            pickUp();
            game.oneil.pickUp();
        }
        else if(number == 11){ //putdown Box
            putDown();
            game.oneil.putDown();
        }
        else if(number == 12){ //pickup ZPM
            pickUpZPM();
            game.oneil.step();
        }
    }
    public static void printMethod(StackTraceElement[] elements){

        String fromMethod = elements[2].getMethodName();
        String methodName = elements[1].getMethodName();
        String className = elements[1].getClassName();
        String fromMethod2 = null ;
        if(elements.length < 4) fromMethod2 = "main";
        else fromMethod2 = elements[3].getMethodName();
        
        String fromKey = fromMethod + fromMethod2;
        String key = methodName + fromMethod;

        if(!canPrint) return;
        if(calls.containsKey(fromKey)){
           for(int k = 0;k<calls.get(fromKey);k++) System.out.print("\t");
            if(!calls.containsKey(key)){
                calls.put(key,calls.get(fromKey)+1);
            }
        }
        else{
            tabindex++;
            calls.put(key,tabindex);
        }
        System.out.print(methodName+"()");
        System.out.println(" | "+"Class: "+className);
    }
    private static void pickUpZPM(){
        game.getMap()[0][1].add(new ZPM());
        canPrint = true;
    }
    private static void putDown(){
        game.getMap()[0][1].add(new Box());
        game.oneil.pickUp();
        canPrint = true;
    }
    private static void pickUp(){
        game.getMap()[0][1].add(new Box());
        canPrint = true;
    }
    private static void rift(){
        game.getMap()[0][1].add(new Rift());
        canPrint = true;
    }
    private static void crossPortal(){

        game.getMap()[0][1].add(new PortalWall(game.getMap()[0][1],game.wormhole));
        game.getMap()[2][0].add(new PortalWall(game.getMap()[2][0], game.wormhole));

        game.oneil.shoot();
        game.oneil.changeColor();
        game.oneil.rotate(Item.Direction.right);
        game.oneil.shoot();
        game.oneil.rotate(Item.Direction.down);

        canPrint = true;
    }
    private static void openPortal(){
        game.getMap()[0][1].add(new PortalWall(game.getMap()[0][1],game.wormhole));
        canPrint = true;
    }
    private static void shoot(){
        game.getMap()[0][4].add(new Wall());
        canPrint = true;
    }
    private static void openDoor(){
        Door door = new Door();
        door.open();
        game.getMap()[0][1].add(door);
        canPrint = true;
    }
    private static void closedDoor(){
        Door door = new Door();
        door.close();
        game.getMap()[0][1].add(door);
        canPrint = true;
    }
}
