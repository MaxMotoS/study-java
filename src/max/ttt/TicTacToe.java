package max.ttt;

/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 22.07.13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
enum Cell {X, O, _}

public class TicTacToe {
    private final static int SIZE_FIELD = 3;
    private final static Cell DEFAULT_CELL = Cell._;
    private final static int FIRST_CHECK = 4;

    private int countMoves = 0;
    private Cell[][] field = null;

    private Cell[][] newField() {
        Cell[][] temp = new Cell[SIZE_FIELD][];
        for (int i = 0; i < SIZE_FIELD; i++) {
            temp[i] = newLine();
        }
        return temp;
    }

    private Cell[] newLine() {
        Cell[] temp = new Cell[SIZE_FIELD];
        for (int i = 0; i < SIZE_FIELD; i++) {
            temp[i] = DEFAULT_CELL;
        }
        return temp;
    }

    public void start() {
        field = newField();
        countMoves = 0;
    }

    public void makeMove(int x, int y, Cell cell) {
        if (x >= SIZE_FIELD || y >= SIZE_FIELD) {
            // выброс ошибки
        } else {
            field[x][y] = cell;
            if (++countMoves > FIRST_CHECK) {
                check();
            }
        }
    }

    private void check() {

    }
}
