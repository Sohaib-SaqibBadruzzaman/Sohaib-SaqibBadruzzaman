public class TicTacToe
{
    private String[] grid;
    private boolean[] usedGrid; 
    private int numOfTurns;
    private int state;
    
    public TicTacToe()
    {
        numOfTurns = 0;
        grid = new String[]{"1","2","3","4","5","6","7","8","9"};
        usedGrid = new boolean[9];
        state = 3;
    }
    
    /*** GETTERS & SETTERS ***/
    
    public int getState() {return state;}
    public String[] getGridContent(){return grid;}
    public int getCurrentP(){return (numOfTurns%2 == 0) ? 1 : 2;}
    
    public void putInGridAt(int pos)
    {
        String symbol;
        int i = pos-1;
        if (usedGrid[i] != true)
        {
            symbol = (numOfTurns%2 == 0)?"X" : "O";
            grid[i] = symbol;
            usedGrid[i] = true;
            numOfTurns++;
        }
        else
        {
            System.out.println("Please Enter in a Open Position\n");
        }
    }
    
    
    public String check4WinToString()
	{
        if (state == 1)
        {
            return "(X) Wins!";
        }
        else if (state == -1)
        {
            return "(O) Wins!";
        }
        else if (state == 0)
        {
            return "Draw";
        }
        else
        {
            return "Unfinished";
        }
	}
    
    public void gridToString()
	{
	    int i = 0;
	    for (String state: grid)
	    {
	        System.out.print(state + " ");
	        if (i%3 == 2)
	        {
	            System.out.println();
	        }
	        i++;
	    }
	    System.out.println();
	}
    
    /*** Helper Methods ***/
    
    private String[] gridToUpperCase()
	{
	    for(int i = 0; i<grid.length; i++)
	    {
	        grid[i] = grid[i].toUpperCase();
	    }
	    return grid;
	}
	
	public boolean gridIsFull()
	{
	    for (String element : grid) {
            if (!element.equals("X") && !element.equals("O")) {
                return false;
            }
        }
        return true;
	}
	
	public void check4Win() 
	{
	    //1 == PlayerOneWon, -1 == PlayerOne lost, 0 == Draw
	    grid = gridToUpperCase();
	    if(grid[0].equals("X") && grid[3].equals("X")
	    && grid[6].equals("X") || grid[0].equals("X")
	    && grid[4].equals("X") && grid[8].equals("X")
	    || grid[0].equals("X") && grid[1].equals("X")
	    && grid[2].equals("X") || grid[1].equals("X")
	    && grid[4].equals("X") && grid[7].equals("X")
	    || grid[2].equals("X") && grid[4].equals("X") 
	    && grid[6].equals("X") || grid[2].equals("X")
	    && grid[5].equals("X") && grid[8].equals("X")
	    || grid[3].equals("X") && grid[4].equals("X") 
	    && grid[5].equals("X") || grid[6].equals("X")
	    && grid[7].equals("X") && grid[8].equals("X"))
	    {
	        state = 1;
	        
	    }
	    else if (grid[0].equals("O") && grid[3].equals("O")
	    && grid[6].equals("O") || grid[0].equals("O")
	    && grid[4].equals("O") && grid[8].equals("O")
	    || grid[0].equals("O") && grid[1].equals("O")
	    && grid[2].equals("O") || grid[1].equals("O")
	    && grid[4].equals("O") && grid[7].equals("O")
	    || grid[2].equals("O") && grid[4].equals("O") 
	    && grid[6].equals("O") || grid[2].equals("O")
	    && grid[5].equals("O") && grid[8].equals("O")
	    || grid[3].equals("O") && grid[4].equals("O") 
	    && grid[5].equals("O") || grid[6].equals("O")
	    && grid[7].equals("O") && grid[8].equals("O"))
	    {
	        state = -1;
	    }
	    else if (gridIsFull() == true)
	    {
	        state = 0;
	    }
	}
    
}