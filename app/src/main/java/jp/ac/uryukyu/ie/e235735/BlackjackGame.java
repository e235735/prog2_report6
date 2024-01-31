package jp.ac.uryukyu.ie.e235735;

import java.util.Scanner;

/**ブラックジャッククラス
 * Deck deck; //山札
 * Player player; //プレイヤー
 * Hand dealerHand; //ディーラーの手札
 */

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Hand dealerHand;

    /**
     * コンストラクタ。山札、プレイヤー、ディーラーの手札を指定する。
     */
    public BlackjackGame() {
        deck = new Deck();
        player = new Player();
        dealerHand = new Hand();
    }

    /**
     * 最初の山札から手札を配るメソッド。
     * プレイヤーの引いたカードは山札から削除し、手札に追加する。
     * ディーラーの引いたカードはDealerHandに追加し、山札から削除する。
     */
    public void dealInitialCards() {
        player.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
    }

    /**
     * プレイヤーの次の行動を選択するメソッド。
     * プレイヤーの手札とディーラーの手札を表示し、ヒットするか選択させる。
     * yを選択して21点以下であればこのループを続ける。
     * 21点以下を超えたり、nを選択すればループを抜ける。
     * @param scanner y/n ; yesかno
     */
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

    /**
     * ディーラーのターンのメソッド。
     * 17点を超えるまでカードを引き続ける
     */
    public void dealerTurn() {
        while (dealerHand.calculateHandValue() < 17) {
            dealerHand.addCard(deck.drawCard());
        }
    }

    /**
     * playerの手札のゲッター
     */
    public Hand getPlayerHand() {
        return player.getHand();
    }

    /**
     * dealerHandのゲッター
     */
    public Hand getDealerHand() {
        return dealerHand;
    }    

    /**
     * どちらが勝ったか判断するメソッド。
     * プレイヤーとディーラーの点数を比べて点数が高かった方が勝ち。
     * ただし、ディーラーが21点を超えていたらディーラーは負けとなる。
     */
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