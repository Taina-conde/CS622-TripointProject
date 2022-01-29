package edu.bu.tbconde.tripoint.cards;

import java.lang.reflect.Array;

public class Wallet <C>{
    private C card1;
    private C card2;
    private int capacity;
    private C[] cardsList;

    public Wallet(int capacity) {
        this.capacity = capacity;
        cardsList = (C[]) new Object[capacity];
    }
    public C[] getCardsList(){return cardsList;}
    public C getCard(int index) { return cardsList[index];}
    public boolean add(C card) {
            for(int i = 0; i < cardsList.length; i++) {
                if (cardsList[i] == null) {
                    cardsList[i] = card;
                    return true;
                }
            }
            System.out.println("Wallet is full. Unable to add " + card);
            return false;

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
