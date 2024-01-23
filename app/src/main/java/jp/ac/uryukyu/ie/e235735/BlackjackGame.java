package jp.ac.uryukyu.ie.e235735;

import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Hand dealerHand;

    public BlackjackGame() {
        deck = new Deck();
        player = new Player();
        dealerHand = new Hand();
    }

    public void dealInitialCards() {
        player.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
    }

    public void playerTurn(Scanner scanner) {
        while (true) {
            System.out.println("あなたの手札は" + player.getHand() + "です。");
            System.out.println("ディーラーの手札は" + (dealerHand.getHand().isEmpty() ? "" : dealerHand.getHand().get(0)) + "です。");
            System.out.print("ヒットしますか？ (y/n): ");

            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("y")) {
                player.getHand().addCard(deck.drawCard());
                if (player.getHand().calculateHandValue() > 21) {
                    System.out.println("バストしました！ あなたの手札は21点を超えてしまいました！");
                    break;
                }
            } else if (choice.equals("n")) {
                System.out.println("あなたはスタンドしました。");
                break;
            }
        }
    }

    public void dealerTurn() {
        while (dealerHand.calculateHandValue() < 17) {
            dealerHand.addCard(deck.drawCard());
        }
    }

    public Hand getDealerHand() {
        return dealerHand;
    }    

    public void checkWinner() {
        int playerValue = player.getHand().calculateHandValue();
        int dealerValue = dealerHand.calculateHandValue();

        System.out.println("\nあなたの手札は" + player.getHand() + "です。(" + playerValue + "点)");
        System.out.println("ディーラーの手札は" + dealerHand + "です。(" + dealerValue + "点)");

        if (playerValue > 21 || (dealerValue <= 21 && dealerValue >= playerValue)) {
            System.out.println("ディーラーの勝ち！");
        } else {
            System.out.println("あなたの勝ち！");
        }
    }
}