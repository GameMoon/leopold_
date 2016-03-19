import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class sequencetester {
    public static Map<String,Integer> calls = new HashMap<>();
    public static int tabindex = 0;
    public static int callindex = 1;

    public static void main(String[] args){

        Program game = new Program();
        System.out.println("Number of seqdiagram?");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        try {
            number = Integer.parseInt(bfr.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Seqdiagram
        if(number == 0){

            game.oneil.step();
        }
    }
    public static void printMethod(String object,String methodName){
        System.out.println(object+":"+methodName);
        if(calls.containsKey(object)){
           for(int k = 0;k<calls.get(object);k++) System.out.print("\t");
        }
        else{
            calls.put(object,tabindex);
            tabindex++;
            for(int k = 0;k<calls.get(object);k++) System.out.print("\t");
        }
        System.out.println(callindex+": "+methodName+"()");
        callindex++;
    }
}
