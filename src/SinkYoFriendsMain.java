
import java.util.InputMismatchException; 
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import com.google.code.chatterbotapi.*;




public class SinkYoFriendsMain {
	
	
	public static void main(String[] args) throws Exception {
  	  ChatterBotFactory factory = new ChatterBotFactory();
          ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
          ChatterBotSession bot1session = bot1.createSession();
        int[][] board = new int[5][5];
        int[][] ships = new int[3][2];
        int[] shoot = new int[2];
        int attempts=0,
            shotHit=0;
        String x = "YASSSSSSS! You have sunk yo' friends, matey! The game is finished!";
        x = bot1session.think(x);
        initBoard(board);
        initShips(ships);
        System.out.println("Come and Sink Yo' Friends!!! You are going first.");
        System.out.println("Pick a row and a column between 1 and 5 to target a");
        System.out.println("ship. For your added entertainment, Cleverbot will comment");
        System.out.println("on the game as well.");
        
        
        do{
            showBoard(board);
            shoot(shoot);
            attempts++;
            
            if(hit(shoot,ships)){
                hint(shoot,ships,attempts);
                shotHit++;
            }                
            else
                hint(shoot,ships,attempts);
            
            changeboard(shoot,ships,board);
            

        }while(shotHit!=3);
        
        System.out.println("\n\n\nYASSSSSSS! You have sunk yo' friends, matey! The game is finished! You hit 3 ships in "+attempts+" attempts");
        System.out.println( x + " -said by Cleverbot");
        showBoard(board);
    	
    }
    
    public static void sound() {
    	try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("no.wav")));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }
    
    public static void initBoard(int[][] board){
        for(int row=0 ; row < 5 ; row++ )
            for(int column=0 ; column < 5 ; column++ )
                board[row][column]=-1;
    }
    
    public static void showBoard(int[][] board){
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();
        
        for(int row=0 ; row < 5 ; row++ ){
            System.out.print((row+1)+"");
            for(int column=0 ; column < 5 ; column++ ){
                if(board[row][column]==-1){
                    System.out.print("\t"+"~");
                }else if(board[row][column]==0){
                    System.out.print("\t"+"*");
                }else if(board[row][column]==1){
                    System.out.print("\t"+"X");
                }
                
            }
            System.out.println();
        }

    }

    public static void initShips(int[][] ships){
        Random random = new Random();
        
        for(int ship=0 ; ship < 3 ; ship++){
            ships[ship][0]=random.nextInt(5);
            ships[ship][1]=random.nextInt(5);
            
            
            for(int last=0 ; last < ship ; last++){
                if( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) )
                    do{
                        ships[ship][0]=random.nextInt(5);
                        ships[ship][1]=random.nextInt(5);
                    }while( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) );
            }
            
        }
    }

    public static void shoot(int[] shoot){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Row: ");
        try{
        shoot[0] = input.nextInt();
        }catch(InputMismatchException e){
    		System.out.println("Feeling naughty? Stick to integer values please.");

    		sound();

    	}
        shoot[0]--;
        
        
        System.out.print("Column: ");
        try{
        shoot[1] = input.nextInt();
    }catch(InputMismatchException e){
		System.out.println("Feeling naughty? Stick to integer values please.");
		sound();
	}
        shoot[1]--;
        
    }
    
    public static boolean hit(int[] shoot, int[][] ships) throws Exception{
    	ChatterBotFactory factory = new ChatterBotFactory();

        ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
        ChatterBotSession bot1session = bot1.createSession();
        for(int ship=0 ; ship<ships.length ; ship++){
            if( shoot[0]==ships[ship][0] && shoot[1]==ships[ship][1]){
                System.out.printf("You hit a ship located in (%d,%d)\n",shoot[0]+1,shoot[1]+1);
                System.out.println(bot1session.think("Good Job! Nice Hit!") + "-said by Cleverbot");
                return true;
            }
        }
        return false;
    }

    public static void hint(int[] shoot, int[][] ships, int attempt){
        int row=0,
            column=0;
        
        for(int line=0 ; line < ships.length ; line++){
            if(ships[line][0]==shoot[0])
                row++;
            if(ships[line][1]==shoot[1])
                column++;
        }
        
        System.out.printf("\nHint %d: \nRow %d -> %d ships\n" +
                                 "Column %d -> %d ships\n",attempt,shoot[0]+1,row,shoot[1]+1,column);
    }

    public static void changeboard(int[] shoot, int[][] ships, int[][] board) throws Exception{
    	ChatterBotFactory factory = new ChatterBotFactory();

        ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
        ChatterBotSession bot1session = bot1.createSession();
    	try{
        if(hit(shoot,ships))
            board[shoot[0]][shoot[1]]=1;
        else
            board[shoot[0]][shoot[1]]=0;
    	}catch(Exception e){
    		System.out.println("INVALID SPOT!!!! There is no such column or row, so try again, you knucklehead!");
    		System.out.println(bot1session.think("INVALID SPOT!!!! There is no such column or row, so try again, you knucklehead!") + "-said by Cleverbot");
    	}
    }
}