package szoftlab;


import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import szoftlab.Item.Direction;

public class Program {
    public static int mapSizeX = 10;
    public static int mapSizeY = 10;
    public Field[][] map;
    public Colonel oneil;
    public Colonel jaffa;
    Replikator repli;
    public Program(){
    	//initMap();
      // oneil = new Colonel(map[0][0],Item.Direction.down,10,10,wormhole,this);
       
    }
    public void mapLoader() 
	{
		try
		{
			BufferedReader fr1 = new BufferedReader(new InputStreamReader(new FileInputStream("map.txt")));
			int n = Integer.parseInt(fr1.readLine()) + 2;
			map = new Field[n][n];
			mapSizeX = n;
			mapSizeY = n;
			initMap();
			ArrayList<Integer> scalesIndex = new ArrayList<Integer>();
			ArrayList<Scale> scales = new ArrayList<Scale>();
			ArrayList<Integer> doorsIndex = new ArrayList<Integer>();
			ArrayList<Door> doors = new ArrayList<Door>();
			for(int i = 0; i < n; i++)
			{
				map[0][i].add(new Wall());
				map[n - 1][i].add(new Wall());
				map[i][0].add(new Wall());
				map[i][n - 1].add(new Wall());
			}
			for(int i = 0; i < n - 2; i++)
			{
				String line[] = fr1.readLine().split(";");
				for(int j = 0; j < n - 2; j++)
				{
					for(int k = 0; k < line[j].length(); k++)
					{
						switch(line[j].charAt(k))
						{
						case ('R') :
							map[i + 1][j + 1].add(new Rift());
							break;
						case ('W') :
							map[i + 1][j + 1].add(new Wall());
							break;
						case ('P') :
							map[i + 1][j + 1].add(new PortalWall(map[i + 1][j + 1]));
							break;
						case ('<') :
							k++;
							String xD = line[j].substring(k).split(">")[0];
							doorsIndex.add(Integer.parseInt(xD));
							Door door = new Door(doorsIndex.get(doorsIndex.size()-1));
							map[i + 1][j + 1].add(door);
							doors.add(door);
							k += xD.length();
							break;
						case ('-') :
							k += 2;
							String[] xS = line[j].substring(k).split(">")[0].split(",");
							Scale scale = new Scale(Integer.parseInt(xS[1]));
							map[i + 1][j + 1].add(scale);
							scalesIndex.add(Integer.parseInt(xS[0]));
							scales.add(scale);
							k += (xS[0].length() + xS[1].length() + 1);
							break;
						default:
							break;
						}
					}
				}
			}
			for(int i = 0; i < scalesIndex.size(); i++)
			{
				scales.get(i).setDoor(doors.get(doorsIndex.indexOf(scalesIndex.get(i))));
			}
			fr1.close();

			BufferedReader fr2 = new BufferedReader(new InputStreamReader(new FileInputStream("start.txt")));
			fr2.readLine(); //én szívesen beolvasom
			int col1W = Integer.parseInt(fr2.readLine());
			int col2W = Integer.parseInt(fr2.readLine());
			int boxW = Integer.parseInt(fr2.readLine());
			for(int i = 0; i < n - 2; i++)
			{
				String line[] = fr2.readLine().split(";");
				for(int j = 0; j < n - 2; j++)
				{
					for(int k = 0; k < line[j].length(); k++)
					{
						switch(line[j].charAt(k))
						{
						case ('O') :
							oneil = new Colonel(map[i + 1][j + 1], Direction.up, 3, col1W,new Wormhole(Color.BLUE, Color.YELLOW),this);
							map[i + 1][j + 1].add(oneil);
							break;
						case ('J') :
							jaffa = new Colonel(map[i + 1][j + 1], Direction.up, 3, col2W,new Wormhole(Color.RED, Color.GREEN),this);
							map[i + 1][j + 1].add(jaffa);
							break;
						case ('R') :
							repli = new Replikator(map[i + 1][j + 1]);
							map[i + 1][j + 1].add(repli);
							break;
						case ('B') :
							map[i + 1][j + 1].add(new Box(boxW, map[i + 1][j + 1]));
							break;
						case ('Z') :
							map[i + 1][j + 1].add(new ZPM());
							break;
						default:
							break;
						}
					}
				}
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		
	}
    public void Result() {
    	for(int i=0;i< mapSizeX - 2;i++){
    		for(int j=0; j<mapSizeY - 2;j++){
    			String aString = map[i + 1][j + 1].getItemsString();
    			String fieldType = "T";
    			int zpmCount = 0;
    			int boxCount = 0;
    			char oneilHere = 'N', jaffaHere = 'N', repliHere = 'N';
    			char portalColor = 'n', portalDir = '-';
    			for(int k = 0; k < aString.length(); k++)
    			{
    				String number;
    				switch (aString.charAt(k))
    				{
    				case 'R':
    					fieldType = "R";
    					break;
    				case 'W':
    					fieldType = "W";
    					break;
    				case 'P':
    					fieldType = "P";
    					break;
    				case '<':
    					k++;
    					number = aString.substring(k).split(">")[0];
    					fieldType = "<".concat(number).concat(">");
    					k += number.length();
    					break;
    				case '+':
    					k += 2;
    					number = aString.substring(k).split(">")[0];
    					fieldType = "+<".concat(number).concat(">");
    					k += number.length();
    					break;
    				case '-':
    					k += 2;
    					number = aString.substring(k).split(">")[0];
    					fieldType = "-<".concat(number).concat(">");
    					k += number.length();
    					break;
    				case 'Z':
    					zpmCount++;
    					break;
    				case 'B':
    					boxCount++;
    					break;
    				case 'o':
    					oneilHere = 'I';
    					break;
    				case 'j':
    					jaffaHere = 'I';
    					break;
    				case 'r':
    					repliHere = 'I';
    					break;
    				case 'p':
    				case 'z':
    				case 'k':
    				case 's':
    					portalColor = aString.charAt(k);
    					portalDir = aString.charAt(++k);
    					break;
    				default:
    					break;
    				}
    			}
    			String finalString="<"+fieldType+","+zpmCount+","+boxCount+","+jaffaHere+","+oneilHere+","+repliHere+","+portalColor+","+portalDir+">";
    			System.out.print(finalString);
    		}
    		System.out.println();
    	}
    }
    private void initMap(){
        //Generate fields
        for(int posX = 0;posX<mapSizeX;posX++){
            for(int posY =0;posY<mapSizeY;posY++) {
                map[posX][posY] = new Field();
            }
        }
        //Init field neighbor's
        for(int posX = 0;posX<mapSizeX;posX++){
            for(int posY =0;posY<mapSizeY;posY++) {
                if(posX-1 >= 0) map[posX][posY].setNeighbor(map[posX-1][posY],Item.Direction.left);
                if(posX+1 < mapSizeX) map[posX][posY].setNeighbor(map[posX+1][posY],Item.Direction.right);
                if(posY-1 >= 0) map[posX][posY].setNeighbor(map[posX][posY-1],Item.Direction.up);
                if(posY+1 < mapSizeY) map[posX][posY].setNeighbor(map[posX][posY+1],Item.Direction.down);
            }
        }
    }
    public void clearMap(){
        for(int posX = 0;posX<mapSizeX;posX++){
            for(int posY =0;posY<mapSizeY;posY++) {
                map[posX][posY].clearItems();
            }
        }
    }
    //ÚJ ZPM létrehozása
    public void createRandomZPM(){
    	//Macht etwas
    };
    public Field[][] getMap(){ return map;}





}
