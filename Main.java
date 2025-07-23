import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner console = new Scanner(System.in);
		//System.out.println(" . | . | . \n-----------\n . | . | . \n-----------\n . | . | . ");
 		boolean keepPlaying = true;
 		boolean isProperResponse = false;
        String response;
		    

 		do
 		{
            Game tictactoe = new Game();
            tictactoe.startGame();
    		
     		System.out.print("\nKeep Playing [Y] or [N] >>> "); 
     		response = console.nextLine().toLowerCase();
    		
     		if (response.equals("y") || response.equals("n")) 
     		{
     		    isProperResponse = true;
     		    if (response.equals("y"))
     		    {
     		        continue;
     		    }
     		    else
     		    {
     		        break;
     		    }
     		}
    		
     		while(!isProperResponse)
     		{
     		    System.out.print("Please Enter [Y] to PLAY AGAIN or [N] to STOP: ");
     		    response = console.nextLine().toLowerCase();
    		    
     		    if (response.equals("y") || response.equals("n")) 
     		    {
     		        isProperResponse = true;
     		        if (response.equals("y"))
         		    {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
         		    }
         		    else
         		    {
         		        break;
         		    }
     		    }
    		    
     		}
 		} while(keepPlaying = true);
	}
}
