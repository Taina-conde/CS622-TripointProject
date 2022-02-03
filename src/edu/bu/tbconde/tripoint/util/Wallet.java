package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;

public class Wallet <T extends CreditCard>{
    private int capacity;
    private T[] objList;
    public Wallet( T... objs) {
        this(objs.length);
        for (int i = 0; i < capacity; i++) {
            objList[i] = objs[i];
        }
    }
    public Wallet(int capacity) {
        this.capacity = capacity;
        objList = (T[]) new CreditCard[capacity];
    }
    public T get(int index) { return objList[index];}
    public T add(T obj) {
            for(int i = 0; i < objList.length; i++) {
                if (objList[i] == null) {
                    objList[i] = obj;
                    return objList[i];
                }
            }
            System.out.println("Wallet is full. Unable to add " + obj);
            return null;
    }
    public int size() {
        int count = 0;
        for (int i = 0; i < objList.length; i++) {
            if (objList[i] != null) {
                count++;
            }
        }
        return count;
    }
    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("Elements in wallet: ");
        for (int i = 0; i < objList.length; i++) {
            if (i == objList.length - 1) {
                content.append(objList[i] + ".");
            }
            else { content.append(objList[i] + ", ");}
        }
        return content.toString();
    }
    public static void main(String[] args) {
        int capacity = 2;
        CreditCard card1 = new BasicCard();
        CreditCard card2 = new PreferredCard();
        CreditCard card3 = new BasicCard();
        // create an instance of Wallet with capacity for 2 elements
        Wallet<CreditCard> wallet = new Wallet<CreditCard>(capacity);
        //add 2 cards to wallet
        System.out.println(wallet.add(card1) + " card added to wallet");
        System.out.println("Number of cards in wallet: " + wallet.size());
        System.out.println(wallet.add(card2) + " card added to wallet");
        // try to add more than 2 cards to a wallet with capacity for 2 elements
        wallet.add(card3);
        System.out.println("Number of cards in wallet: " + wallet.size());
        System.out.println(wallet);
    }
}
