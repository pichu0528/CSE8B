import java.util.*;
public class Tictactoe {
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final char NUL_CHAR = '\u0000';
    private String[][] board;
    //construct an empty board
    public Tictactoe()
    {
        board = new String[ROWS][COLUMNS];
        //Fill with spaces
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLUMNS; j++)
            {
                board[i][j] = " ";
            }
        }
    }
    //set the fields in the board
    public void set(int i, int j, String player)
    {
        if(board[i][j].equals(" "))
        {
            board[i][j] = player;
        }
    }
    /**creates a string representation of the board
     * @return the string representation
     */
    public String toString()
    {
      int i, j;
      String r = "  ";
      System.out.println("----------------");
      
      for( i = 0; i < ROWS; i++)
      {
        System.out.println("|"); 
      for( j = 0; j < COLUMNS; j++)
      {
        r += board[i][j];
        r += "|";
      }
      
      System.out.println("-------------");
     
      }
      return r;
    }
    
      
   
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String player = "x";
        Tictactoe game = new Tictactoe();
        boolean done = false;
        while(!done)
        {
            System.out.println(game.toString());
            System.out.println("Row for "+player+" (-1 to exit): ");
            int row = in.nextInt();
            if(row < 0) done = true;
            else
            {
                System.out.println("Column for "+player+": ");
                int column = in.nextInt();
                game.set(row, column, player);
                if(player.equals("x")) player = "o";
                else player = "x";
            }
        }
    }
}