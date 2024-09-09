package mvvm.games.snakegame.model;

import mvvm.games.snakegame.dto.Position;

import java.util.*;

public class SnakeModel {
    private static SnakeModel snakeModel;
    public char[][] board;
    Queue<Position> snake;
    public int remainingFood;
    public int row;
    public int col;
    private SnakeModel(){
        row = 0;
        col = 0;
        board = new char[8][8];
        snake = new LinkedList<>();
        remainingFood = 4;
    }
    public void setBoard(){
        for(char i[]:board){
            Arrays.fill(i,'-');
        }
        initializeFoodPosition();
        initializeSnakePosition();
    }
    private void initializeFoodPosition(){
        Random random = new Random();
        int i=0;
        while (i<4){
            int row = random.nextInt(board.length);
            int col = random.nextInt(board.length);
            if(row!=0 && col!=0 && board[row][col] != 'O'){
                board[row][col] = 'O';
                i++;
            }
        }
    }
    public void initializeSnakePosition(){
        board[0][0] = '*';
        snake.add(new Position(0,0));
    }
    public static SnakeModel getSnakeModelInstance() {
        if(snakeModel == null)
            snakeModel = new SnakeModel();
        return snakeModel;
    }

    public boolean handleLogic(char ch){
        switch (ch) {
            case 'U' -> row--;
            case 'D' -> row++;
            case 'R' -> col++;
            case 'L' -> col--;
            default -> System.out.println("Invalid Move!!!");
        }
        return makeMove(row,col);
    }
    private boolean makeMove(int row, int col){
        if(row < 0 || row > board.length || col < 0 || col > board.length)
            return false;
        if(board[row][col] == '*')
            return false;

        snake.add(new Position(row, col));
        if(board[row][col] != 'O'){
            Position p = snake.poll();
            board[p.row][p.col] = '-';
        }
        else {
            remainingFood--;
            if(remainingFood==0)
                return false;
        }
        board[row][col] = '*';
            return true;
    }
}
