package szoftlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SeqTester {
    public static Map<Integer,String> classNames = new HashMap<>();
    public static Map<String,Integer> calls = new HashMap<>();
    public static int tabindex = 0;
    public static boolean canPrint = false;
    public static Program game;
    public static void printMenu(){
        //System.out.println("1. Szinvaltas");
        //System.out.println("1. Iranyvaltas");

        System.out.println("1. Szinvaltas");
        System.out.println("2. Iranyvaltas");
        System.out.println("3. Mozgas");
        System.out.println("4. Doboz felvetele");
        System.out.println("5. Doboz lerakasa");
        System.out.println("6. Loves");
        System.out.println("7. Szakadekba lepes");
        System.out.println("8. Ures mezore lepes");
        System.out.println("9. Falhoz lepes");
        System.out.println("10. Merlegre lepes");
        System.out.println("11. Ajtohoz lepes");
        System.out.println("12. Csillagkapura lepes");
        System.out.println("13. Merlegrol lelepes");
        System.out.println("14. ZPM felvetele");
        System.out.println("15. Merlegre helyezes");
        System.out.println("16. Doboz szakadekba esik");
        System.out.println("17. Doboz megsemmisul");
        System.out.println("18. Csillagkapu nyitas");
        System.out.println("19. Lovedek ures mezore lep");
        System.out.println("Number of seqdiagram?");
    }
    public static String getClassIdName(Object object){
        if(object == null) return "null";
        Class className = object.getClass();
        int ID = System.identityHashCode(object);
        if(!classNames.containsKey(ID)){
            int index = 1;
            while(classNames.containsValue(className.getSimpleName().toLowerCase()+index)){
                index++;
            }
            classNames.put(ID,className.getSimpleName().toLowerCase()+index);

        }
        if(className.getSimpleName().equals("Boolean")){
            return Boolean.parseBoolean(object.toString())+":"+className.getSimpleName();
        }
        else return classNames.get(ID)+":"+className.getSimpleName();
    }

    public void init(){

        game = new Program();

        printMenu();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int number = 18;
        try {
            String line = bfr.readLine();
            if(line.isEmpty()) return;
            number = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Seqdiagram
        if (number == 1) {
            canPrint = true;
            game.oneil.changeColor();
        } else if(number == 2) {
            canPrint = true;
            game.oneil.rotate(Item.Direction.up);
        } else if (number == 3 || number == 8) { //Oneil step
            canPrint = true;
            game.oneil.step();
        } else if (number == 4) { //pickup Box
            pickUp();
            game.oneil.pickUp();
        } else if (number == 5) { //putdown Box
            putDown();
            game.oneil.putDown();
        } else if (number == 6) { //Shot
            shoot();
            game.oneil.shoot();
        } else if (number == 7) { // step into the rift
            rift();
            game.oneil.step();
        } else if (number == 9) { //Oneil blocked by the Wall
            wall();
            game.oneil.step();
        }else if (number == 10) { //Oneil pressing the Scale
            pressScale();
            game.oneil.step();
        } else if (number == 11) { //Oneil going cross the Door
            openDoor();
            game.oneil.step();
        }else if (number == 12) { //crossPortal
            crossPortal();
            game.oneil.step();
        }else if (number == 13) { //Oneil releasing the Scale
            releaseScale();
            game.oneil.step();
        } else if (number == 14) { //pickup ZPM
            pickUpZPM();
            game.oneil.step();
        } else if (number == 15) { //putdown item to scale
            putDownItemtoScale();
            game.oneil.putDown();
        } else if(number == 16 || number == 17) {
            riftwithBox();
            game.oneil.step();
        } else if (number == 18) { //openPortal
            openPortal();
            game.oneil.shoot();
        } else if(number == 19){
            flyingBullet();
            game.oneil.shoot();
        }

    }
    public static void printMethod(Object object,StackTraceElement[] elements,Object... args){
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

        System.out.print(getClassIdName(object)+" -> ");
        System.out.print(methodName + "(");
        for(Object arg : args){
            System.out.print(getClassIdName(arg));
            if(args[args.length-1] != arg) System.out.print(", ");
        }
        System.out.println(")");

    }
    private static void pickUpZPM(){
        game.getMap()[0][1].add(new ZPM());
        canPrint = true;
    }
    private static void putDown(){
        game.getMap()[0][1].add(new Box(10,game.map[0][1]));
        game.oneil.pickUp();
        canPrint = true;
    }
    private static void pickUp(){
        game.getMap()[0][1].add(new Box(10,game.map[0][1]));
        canPrint = true;
    }
    private static void rift(){
        game.getMap()[0][1].add(new Rift());
        canPrint = true;
    }
    private static void riftwithBox(){
        game.getMap()[0][1].add(new Rift());
        game.oneil.rotate(Item.Direction.right);
        game.getMap()[1][0].add(new Box(10,game.map[1][0]));
        game.oneil.pickUp();
        game.oneil.rotate(Item.Direction.down);
        canPrint = true;
    }
    private static void crossPortal(){

        game.getMap()[0][1].add(new PortalWall(game.getMap()[0][1]));
        game.getMap()[2][0].add(new PortalWall(game.getMap()[2][0]));

        game.oneil.shoot();
        game.oneil.changeColor();
        game.oneil.rotate(Item.Direction.right);
        game.oneil.shoot();
        game.oneil.rotate(Item.Direction.down);

        canPrint = true;
    }
    private static void openPortal(){
        game.getMap()[0][1].add(new PortalWall(game.getMap()[0][1]));
        canPrint = true;
    }
    private static void wall(){
        game.getMap()[0][1].add(new Wall());
        canPrint = true;
    }
    private static void shoot(){
        game.getMap()[0][4].add(new Wall());
        canPrint = true;
    }
    private static void openDoor(){
        Door door = new Door(1);
        door.open();
        game.getMap()[0][1].add(door);
        canPrint = true;
    }
    private static void putDownItemtoScale(){
        game.getMap()[0][1].add(new Box(10,game.map[0][1]));
        game.getMap()[1][0].add(new Scale(20));
        game.oneil.pickUp();
        game.oneil.rotate(Item.Direction.right);
        canPrint = true;
    }
    private static void closedDoor(){
        Door door = new Door(1);
        door.close();
        game.getMap()[0][1].add(door);
        canPrint = true;
    }
    private static void pressScale(){
        game.getMap()[0][1].add(new Scale(20));
        canPrint = true;
    }
    private static void releaseScale(){
        game.getMap()[0][0].add(new Scale(20));
        canPrint = true;
    }
    private static void flyingBullet(){
        game.getMap()[0][5].add(new Wall());
        canPrint = true;
    }
}
