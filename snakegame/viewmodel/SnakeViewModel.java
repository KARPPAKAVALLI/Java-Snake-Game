package mvvm.games.snakegame.viewmodel;

import mvvm.games.snakegame.model.SnakeModel;
import mvvm.games.snakegame.view.SnakeView;

public class SnakeViewModel {
    public SnakeModel snakeModel;
    public SnakeView snakeView;
    public SnakeViewModel(){
        snakeModel = SnakeModel.getSnakeModelInstance();
        snakeView = SnakeView.getSnakeViewInstance();
    }

    public void handleUserMove(){
        char ch;
        do{
            snakeView.displayBoard();
            ch = snakeView.getUserInput();
        }while (snakeModel.handleLogic(ch));

        snakeView.displayBoard();
        if(snakeModel.remainingFood==0)
            snakeView.printResult(true);
        else
            snakeView.printResult(false);
    }
}
