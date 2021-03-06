//import java.util.IllegalArgumentException;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class KnightBoard{

  private int[][] board;
  private int[][] Moves;
  private int length;
  private int width;
  private int level;
  private int Solutions;

  public KnightBoard(int row, int col){ // constructor
    if(row <= 0 || col <= 0){
      throw new IllegalArgumentException();
    }
    board = new int[row][col];
    length = row;
    width = col;
  }

  private boolean inBounds(int row, int col){ // checks if the knight is inside the Board
    if(row >= length || col >= width){return false;}
    else if(row < 0 || col < 0){return false;}
    return true;
  }

  public int getLevel(){ // returns the level, or the knight number
    return level;
  }

  public boolean solve(int startingrow, int startingcol){
    if(!inBounds(startingrow,startingcol)){
      throw new IllegalArgumentException();
    }
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        if(board[i][j] != 0){throw new IllegalStateException();}
      }
    }
    return solveHelper(startingrow,startingcol,1);
  }

  public int countSolutions(int startingrow, int startingcol){
    if(!inBounds(startingrow,startingcol)){
      throw new IllegalArgumentException();
    }
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        if(board[i][j] != 0){throw new IllegalStateException();}
      }
    }
    counterHelper(1,startingrow,startingcol);
    return Solutions;
  }

  public boolean counterHelper(int position, int row, int col){
    if(position == length*width){
      board[row][col] = 0;
      Solutions++;
      return true;
    }
    int[][] moves = new int[][] { {1,2} , {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1} };
    for(int i = 0; i < moves.length; i++){
      int rowChange = row + moves[i][0];
      int colChange = col + moves[i][1];
      if(inBounds(rowChange,colChange) && board[rowChange][colChange] == 0){
        board[row][col] = position;
        counterHelper(position+1,rowChange,colChange);
        board[row][col] = 0;
      }
    }
    return false;
  }

  public int CountAllSolutions(){
    int counter = 0;
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        counter += countSolutions(i,j);
      }
    }
    return counter;
  }

  private boolean solveHelper(int row, int col, int level){
    if(level == length*width){
      board[row][col] = level;
      return true;
    }
    board[row][col] = level;

    int[][] moves = new int[][] { {1,2} , {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1} };
    for(int i = 0 ; i < moves.length; i++){
      int rowChange = row + moves[i][0];
      int colChange = col + moves[i][1];
      if(inBounds(rowChange,colChange) && board[rowChange][colChange] == 0){
        if(solveHelper(rowChange,colChange,level+1)){return true;}
      }
    }
    board[row][col] = 0;
    return false;
  }

  private boolean addKnight(int row, int col){ // adding a knight at a row and column
    if(!inBounds(row,col)){return false;}
    if(board[row][col] != 0){
      return false;
    }
    board[row][col] = level+1;
    level++;
    return true;
  }

  private boolean removeKnight(int row, int col){ // removing a knight at a row and column
    if(!inBounds(row,col)){return false;}
    if(board[row][col] == 0){return false;}
    board[row][col] = 0;
    level--;
    return true;
  }

  private void clear(){ // clears the board of knights
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        board[i][j] = 0;
      }
    }
  }

  public String toString(){ // Marked by integers for knight
    String result = "";
    for(int i = 0; i < length; i++){
      for(int j = 0; j < width; j++){
        if(board[i][j] == 0){result += "__ ";}
        else{result += board[i][j] + " ";}
      }
      result += "\n";
    }
    return result;
  }

  public static void runTest(int i){

  KnightBoard b;
  int[]m =   {4,5,5,5,5};
  int[]n =   {4,5,4,5,5};
  int[]startx = {0,0,0,1,2};
  int[]starty = {0,0,0,1,2};
  int[]answers = {0,304,32,56,64};
  if(i >= 0 ){
    try{
      int correct = answers[i];
      b = new KnightBoard(m[i%m.length],n[i%m.length]);

      int ans  = b.countSolutions(startx[i],starty[i]);

      if(correct==ans){
        System.out.println("PASS board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans);
      }else{
        System.out.println("FAIL board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans+" vs "+correct);
      }
    }catch(Exception e){
      System.out.println("FAIL Exception case: "+i);

    }
  }
}

  public static void main(String[] args){

    KnightBoard kn = new KnightBoard(5,5);
    int row = Integer.parseInt(args[0]);
    int col = Integer.parseInt(args[1]);
    System.out.println(kn.countSolutions(row,col));
    System.out.println(kn.solve(row,col));
    System.out.println(kn);
    for(int i = 0; i < 5; i++){
    runTest(i);
  }

  }

}
