package mvvm.games.snakegame.view;

import mvvm.games.snakegame.model.SnakeModel;

import java.util.Arrays;
import java.util.Scanner;

public class SnakeView {
    private static SnakeView snakeView;
    SnakeModel snakeModel;
    private SnakeView() {

    }
    public static SnakeView getSnakeViewInstance(){
        if(snakeView == null)
            snakeView = new SnakeView();
        return snakeView;
    }

    public char getUserInput(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter direction");
        char ch = sc.next().charAt(0);
        return ch;
    }

    public void displayBoard(){
        snakeModel = SnakeModel.getSnakeModelInstance();
        for(char[] i : snakeModel.board){
            System.out.println(Arrays.toString(i));
        }
    }

    public void printResult(boolean isWon){
        System.out.println("Game Over");
        if(isWon){
            System.out.println("You Win 🎇!!!");
        }
        else{
            System.out.println("You Lost 😵!!!");
        }
    }
}
