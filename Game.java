import java.util.*;
public class Game
{
    private TicTacToe t;
    private Grid g;
    private int posi;
    private String p1,p2, winner;
    
    public Game()
    {
        t = new TicTacToe();
        g = new Grid();
        p1 = "Player 1";
        p2 = "Player 2";
        winner = "none";
    }
    
    public String getP1(){return p1;}
    public String getP2(){return p2;}
    
    public void startGame()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! Lets Play a Game of TIC TAC TOE\n");
        
        System.out.print("Player 1 name >>> ");
        p1 = console.nextLine();
        
        System.out.print("Player 2 name >>> ");
        p2 = console.nextLine();
        
        System.out.println();
        
        g.setGridContent(t.getGridContent());
        g.printGrid();
        
        do 
        {
            promptP();
            updateCheckAndPrintGrid(getPos());
            
        } while(t.getState() == 3);
        if (t.getState() == 1)
        {
            winner = p1;
        }
        else if(t.getState() == -1)
        {
            winner = p2;
        }
        else
        {
            winner = "";
        }
        System.out.print("\n" + winner + " " + t.check4WinToString());
    }
    
    private void promptP()
    {
        Scanner console = new Scanner(System.in);
        String currName;
        String symbol;
        if (t.getCurrentP() == 1) {currName = getP1(); symbol = "X";}
        else {currName = getP2();symbol = "O";}
        
        System.out.print("\n" +currName + ", where are you placing "+ symbol + "? >>> ");
        try 
        {
            posi = console.nextInt();
            if (posi < 0 || posi >= t.getGridContent().length+1) {
            throw new ArrayIndexOutOfBoundsException(); // Throw exception if input is out of bounds
        }
        } catch(InputMismatchException e)
        {
            System.out.println("Please enter a valid number in grid");
            promptP();
        }catch(ArrayIndexOutOfBoundsException i)
        {
            System.out.println("Please put a number from within grid");
            promptP();
        }
        
        
    }
    
    private void updateCheckAndPrintGrid(int pos)
    {
        t.putInGridAt(pos);
        g.setGridContent(t.getGridContent());
        t.check4Win();
        System.out.println();
        g.printGrid();
    }
    
    private void setPos(int pos)
    {
        posi = pos;
    }
    private int getPos()
    {
        return posi;
    }
    
        
}