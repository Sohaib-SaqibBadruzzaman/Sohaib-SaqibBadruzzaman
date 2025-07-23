public class Grid
{
    private String grid;
    private String[] content;
    
    public Grid()
    {
        grid = "  |  |  \n-----------\n  |  |  \n-----------\n  |  |  ";
        content = new String[]{"1","2","3","4","5","6","7","8","9"};
        fillGridwithContent();
    }
    
    private void fillGridwithContent()
    {
        grid = " " + content[0] + " | " + content[1] + " | " + content[2] + "\n" +
                  "-----------\n" +
                  " " + content[3] + " | " + content[4] + " | " + content[5] + "\n" +
                  "-----------\n" +
                  " " + content[6] + " | " + content[7] + " | " + content[8] + "\n"; 
    }
    
    public void setGridContent(String[] gridContent)
    {
        for (int i = 0; i< content.length; i++)
        {
            content[i] = gridContent[i];
        }
        fillGridwithContent();
    }
    
    
    public void printGrid()
    {
        System.out.print(grid);
    }
}