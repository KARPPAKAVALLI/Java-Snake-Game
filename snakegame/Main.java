package mvvm.games.snakegame;

import mvvm.games.snakegame.viewmodel.SnakeViewModel;

public class Main {
    public static void main(String[] args) {
        SnakeViewModel game = new SnakeViewModel();
        game.snakeModel.setBoard();
        game.handleUserMove();
    }
}
