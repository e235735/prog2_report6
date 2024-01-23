package jp.ac.uryukyu.ie.e235735;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BlackjackGame game = new BlackjackGame();
        game.dealInitialCards();

        game.playerTurn(scanner);
        game.dealerTurn();
        game.checkWinner();

        scanner.close();
    }
}

