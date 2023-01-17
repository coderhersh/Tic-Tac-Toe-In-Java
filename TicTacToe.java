import java.util.Scanner;

public class TicTacToe {
    private int[][] board;
    private int numberOfFilledPlaces = 0;
    private boolean firstPlayer = true;

    private boolean isValidPosition(int x, int y) {
        if (x < 0 || x > 2) return false;
        if (y < 0 || y > 2) return false;
        return true;
    }

    private boolean isFilled(int x, int y) {
        if (this.board[x][y] == -1) return false;
        return true;
    }

    private void isDraw() {
        if (board.length == numberOfFilledPlaces) {
            System.out.println("Draw Match");
        }
    }

    private void isWinner() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 0 && board[i][1] == 0 && board[i][2] == 0) {
                System.out.println("First Player won!!");
            }
            if (board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1) {
                System.out.println("Second Player won!!");
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == 0 && board[1][i] == 0 && board[2][i] == 0) {
                System.out.println("First Player won!!");
            }
            if (board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1) {
                System.out.println("Second Player won!!");
            }
        }
        if (board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0) {
            System.out.println("First Player won!!");
        }
        if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
            System.out.println("Second Player won!!");
        }
        isDraw();
    }

    private TicTacToe() {
        board = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = -1;
            }            
        }
    }
    
    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void Main(String []args) {
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            game.printBoard();
            if (game.firstPlayer) {
                System.out.print("Turn of first player: ");
                int x = input.nextInt();
                int y = input.nextInt();
                if (!game.isValidPosition(x-1, y-1)) {
                    System.out.println("Wrong input try again!!!");
                    continue;
                }
                if (game.isFilled(x-1, y-1)) {
                    System.out.println("This place is already filled try again!!");
                    continue;
                }
                game.board[x-1][y-1] = 1;
                game.numberOfFilledPlaces++;
                game.isWinner();
                game.firstPlayer = !game.firstPlayer;
            } else {
                System.out.println("Turn of second player: ");
                int x = input.nextInt();
                int y = input.nextInt();
                if (!game.isValidPosition(x-1, y-1)) {
                    System.out.println("Wrong input try again!!!");
                    continue;
                }
                if (game.isFilled(x-1, y-1)) {
                    System.out.println("This place is already filled try again!!");
                    continue;
                }
                game.board[x-1][y-1] = 0;
                game.numberOfFilledPlaces++;
                game.isWinner();
                game.firstPlayer = !game.firstPlayer;
            }
        }

    }
}
