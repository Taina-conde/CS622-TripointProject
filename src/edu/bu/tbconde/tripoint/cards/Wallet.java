package edu.bu.tbconde.tripoint.cards;

public class Wallet <C extends CreditCard>{
    private C card1;
    private C card2;
    private CreditCard[] cardsList;

    public Wallet(C card1, C card2) {
        this.card1 = card1;
        this.card2 =card2;
        cardsList = new CreditCard[] {card1, card2};
    }
    public Wallet(C card1) {
        this(card1, null);
    }
    public Wallet() {
        cardsList = new CreditCard[2];
    }
    public CreditCard[] getCardsList(){return cardsList;}
    public boolean addCard(C card) {
        if (cardsList.length < 2) {
            for(int i = 0; i < cardsList.length; i++) {
                if (cardsList[i] == null) {
                    cardsList[i] = card;
                    break;
                }
            }
            return true;
        } else {
            System.out.println("Wallet is full. Unable to add " + card);
            return false;
        }


    }



}
