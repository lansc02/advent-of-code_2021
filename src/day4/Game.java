package day4;

import java.util.List;

public class Game {
    public List<BingoBoard> boards;
    public List<Integer> numbers;

    public Game(List<BingoBoard> boards, List<Integer> numbers) {
        this.boards = boards;
        this.numbers = numbers;
    }

    public void round(){
        for (Integer i:numbers) {
            for (BingoBoard board:boards) {
                board.markValue(i);
                if (board.isBoardBingo()){
                    System.out.println(board.toString());
                    System.out.println(board.calcSum(i));
                    return;
                }
            }
        }
    }
}
