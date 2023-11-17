import java.util.Scanner;
public class TicTacToe {

    //class-level variables can be accessed/used by all methods
    //in the class

    //-for now, all class-level vars are public static

    //for board - only declare, but don't initialize bc
    //setupBoard() will get and set the correct size
    public static String [][] board;

    public static Scanner s = new Scanner(System.in);

    //init length to 2 bc we know the game needs 2 names
    public static String [] names = new String [2];
    public static String [] pieces = {"x", "o"};

    public static void main(String [] args) {
        setupBoard();
        getNames();
        printBoard();

     //player will alternate between 1 and 0 to use as
        //an index for the names and pieces arrays
        int player = 1;
        //gameOver() will print whether there's a win or tie
        while (gameOver(player) == false) {
            //pass in the old player value, and save the
            //returned value back to the player variable
            player = switchPlayers(player);
            turn(player);
            printBoard();
        }
    }

    public static void setupBoard() {
        System.out.println("how big should the board be? needs to be positive");
        //since s was initialized at the class level, it can be
        //used in any of the class methods
        int size = s.nextInt();
        while(size < 1) {
            System.out.println("Invalid");
            System.out.println("how big should the board be? needs to be positive");
            size = s.nextInt();
        }
        //initialize the class-level board array
        board = new String [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "_";
            }
        }
        s.nextLine();

    }
    public static void getNames() {
        System.out.println("Player 1 - what is your name?");
        names[0] = s.nextLine();
        System.out.println("Player 2 - what is your name?");
        names[1] = s.nextLine();
    }
    public static void printBoard() {
        //size isn't accessible in this method bc it was
        //declared in setupBoard()
        //-variable scope - a variable only exists within
        //the method it was declared
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

    }

    //current will be either 0 or 1
    //if 1, return 0
    //if 0, return 1
    public static int switchPlayers(int current) {
        if(current == 1) {
            //only the first return that's reached will run
            //then the method will stop once a value is returned
            return 0;
        }
        return 1;
    }

    //player will be 0 or 1
    public static void turn(int player) {
        String name = names[player];
        String piece = pieces[player];
        System.out.println(name + " - where would you like to place your " + piece +"?");
        System.out.println("row: ");
        int row = s.nextInt();
        System.out.println("col: ");
        int col = s.nextInt();

        //validate that row and col are within range and
        // that there isn't already a piece there
        while (row < 0 || row >= board.length ||
        col < 0 || col >= board.length || !board[row][col].equals("_")) {
            System.out.println("invalid coordinates");
            System.out.println("row: ");
            row = s.nextInt();
            System.out.println("col: ");
            col = s.nextInt();
        }

        board[row][col] = piece;

    }

    public static boolean gameOver(int player) {
        String name = names[player];
        String piece = pieces[player];

        for (int i = 0; i < board.length; i++) {

            int rowCount = 0;
            int colCount = 0;
            int diag1Count = 0;
            int diag2Count = 0;

            for (int j = 0; j < board.length; j++) {
                if(board[i][j].equals(piece)) {
                    rowCount++;
                }
                if (board[j][i].equals(piece)) {
                    colCount++;
                }
                if (board[j][j].equals(piece)) {
                    diag1Count++;
                }
                if (board[j][board.length-1-j].equals(piece)) {
                    diag2Count++;
                }
            }

            if (rowCount == board.length || colCount == board.length
            || diag1Count == board.length || diag2Count == board.length) {
                System.out.println(name + " wins!");
                return true;
            }

        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("_")) {
                    //if there's a blank in the board, the game isn't over yet
                    //so return false (and stop the method from continuing to run)
                    return false;
                }
            }
        }

        //if the code reaches this point, there was no winner and there are no blanks
        //left on the board, so it's a tie game and the game is over
        System.out.println("tie game!");
        return true;
    }


}
