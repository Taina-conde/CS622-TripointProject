package edu.bu.tbconde.tripoint.cards;

public class Wallet <C>{
    private int capacity;
    private C[] objList;

    public Wallet(int capacity) {
        this.capacity = capacity;
        objList = (C[]) new Object[capacity];
    }

    public C get(int index) { return objList[index];}
    public boolean add(C card) {
            for(int i = 0; i < objList.length; i++) {
                if (objList[i] == null) {
                    objList[i] = card;
                    return true;
                }
            }
            System.out.println("Wallet is full. Unable to add " + card);
            return false;

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
}
