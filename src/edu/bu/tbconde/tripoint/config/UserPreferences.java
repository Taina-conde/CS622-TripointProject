package edu.bu.tbconde.tripoint.config;


public class UserPreferences<T extends Preference> {
    private int capacity;
    private T[] objList;
    public UserPreferences( T... objs) {
        this(objs.length);
        for (int i = 0; i < capacity; i++) {
            objList[i] = objs[i];
        }
    }
    public UserPreferences(int capacity) {
        this.capacity = capacity;
        objList = (T[]) new Preference[capacity];
    }
    public T get(int index) { return objList[index];}
    public T add(T obj) {
        for(int i = 0; i < objList.length; i++) {
            if (objList[i] == null) {
                objList[i] = obj;
                return objList[i];
            }
        }
        System.out.println("UserPreferences is full. Unable to add " + obj);
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
        StringBuilder content = new StringBuilder("Preferences: ");
        for (int i = 0; i < objList.length; i++) {
            if (i == objList.length - 1) {
                content.append(objList[i] + ".");
            }
            else { content.append(objList[i] + ", ");}
        }
        return content.toString();
    }
}
