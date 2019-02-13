import java.util.IllegalArgumentException;
import java.util.Scanner;
public class KnightBoard{

  private int[][] board;
  private int length;
  private int width;
  private int Solutions;

  public KnightBoard(int startingrow, int startingcol){
    if(startingrow < 0 || startingcol < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingrow][startingcol];
    length = startingrow;
    width = startingcol;
  }

  private boolean inBounds(int row, int col){
    if(row >= length || col >= width){return false;}
    else if(row < 0 || col < 0){return false;}
    return true;
  }

  private void KnightMove(int row, int col, int Knightnum, String direction){
    if(direction.equals("upright")){
      int newrow = row - 3;
      int newcol = col + 1;
      if(inBounds(newrow,newcol)){board[newrow][newcol] = Knightnum+1;}
    }
    else if(direction.equals("downright")){
      int newrow = row + 3;
      int newcol = col + 1;
      if(inBounds(newrow,newcol)){board[newrow][newcol] = Knightnum+1;}
    }
  }

  public boolean solve(int startingrow, int startingcol){
    return true;
  }

  public int countSolutions(int startingrow, int startingcol){
    return 0;
  }

  private boolean solveHelper(int row, int col, int level){
    return false;
  }

  public String toString(){
    String result = "";
    for(int i = 0; i < startingrow; i++){
      for(int j = 0; j < startingcol; j++){
        if(board[i][j] == 0){result += "__ ";}
        else{result += board[i][j] + " ";}
      }
      result += "\n";
    }
    return result;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int num1 = 0;
    int num2 = 0;
    boolean taken = true;
    while(taken){
    try{
    System.out.println("Input a length: ");
	  num1 = in.nextInt();
    System.out.println("Input a width: ");
	  num2 = in.nextInt();
    taken = false;
  } catch(InputMismatchException e){
    System.out.println("Please input a number!");
    in.next();
  }
}
    KnightBoard puzzle = new KnightBoard(num1,num2);
    System.out.println("Welcome to KnightBoard!!!");
    System.out.println("------------------------------");
    System.out.println("Chose one of the following options: ");
    System.out.prinltn("1. Print the puzzle");
    System.out.println("------------------------------");
    int option = in.nextInt();
    boolean running = true;
    while(running){
    try{}
  }

}
