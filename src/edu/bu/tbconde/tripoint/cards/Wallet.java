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
    


}
