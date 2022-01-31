package edu.bu.tbconde.tripoint.util;

public class Wallet <C>{
    private int capacity;
    private C[] objList;

    public Wallet( C... objs) {
        this.capacity = objs.length;
        objList = (C[]) new Object[capacity];
    }
    public Wallet(int capacity) {
        this.capacity = capacity;
        objList = (C[]) new Object[capacity];
    }

    public C get(int index) { return objList[index];}
    public C add(C obj) {
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
}
