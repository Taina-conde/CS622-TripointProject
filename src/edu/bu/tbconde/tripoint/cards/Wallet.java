package edu.bu.tbconde.tripoint.cards;

import java.lang.reflect.Array;

public class Wallet <C>{
    private C card1;
    private C card2;
    private C[] cardsList;

    public Wallet(int capacity) {
        cardsList = (C[]) new Object[capacity];
    }
    public C[] getCardsList(){return cardsList;}
    public C getCard(int index) { return cardsList[index];}
    public boolean add(C card) {
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
    public int size() {
        int count = 0;
        for (int i = 0; i < cardsList.length; i++) {
            if (cardsList[i] != null) {
                count++;
            }
        }
        return count;
    }
}
