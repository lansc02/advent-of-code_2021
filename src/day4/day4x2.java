package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day4x2 {
    static List<BingoBoard> boards;
    static List<Integer> randomNumbers;

    public static void setup(List<String> textinput){
        randomNumbers = Arrays.stream(textinput.get(0).split(",")).map(Integer::valueOf).toList();
        boards = new ArrayList<>();
        for (int i = 1; i < textinput.size(); i=i+6) {
            BingoBoard board = new BingoBoard();
            board.setRow(0, textinput.get(i+1));
            board.setRow(1, textinput.get(i+2));
            board.setRow(2, textinput.get(i+3));
            board.setRow(3, textinput.get(i+4));
            board.setRow(4, textinput.get(i+5));
            boards.add(board);
        }
    }


    public static void main(String[] args) {
        List<String> textinput = utils.inputReaders.readStringInput("src/day4/day4x1.txt");
       // List<String> textinput = utils.inputReaders.readStringInput("src/day4/da4x1test.txt");
        setup(textinput);
        Game game = new Game(boards, randomNumbers);
        game.round();
        }
    }

