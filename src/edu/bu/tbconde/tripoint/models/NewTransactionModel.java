package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.transactions.RedeemTransaction;
import edu.bu.tbconde.tripoint.util.Wallet;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;

public class NewTransactionModel{
    private Wallet<CreditCard> wallet;
    private String cardType;
    private String category;
    private double amount;
    private Transaction currTrans;
    private int points;
    private int catValue;
    public NewTransactionModel(Wallet<CreditCard> wallet) {
       this.wallet = wallet;
    }

    //getters'
    public Wallet<CreditCard> getWallet() {return wallet;}
    public Transaction getCurrTrans() { return currTrans;}
    public int getPoints() {return points;}
    public int getCatValue() {return catValue;}
    public String getCardType() {return cardType;}
    public String getCategory() {return category;
    }
    public double getAmount() {return amount;}

    //setters
    public void setAmount(double amount) {this.amount = amount; }
    public void setWallet(Wallet<CreditCard> wallet) { this.wallet = wallet;}
    public void setCategory(String category) {this.category = category;}
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public void setCurrTrans(Transaction currTrans) {
        this.currTrans = currTrans;

    }
    public Transaction createPurchaseTransaction() {
        for (int i = 0; i < wallet.size(); i++) {
            CreditCard card = wallet.get(i);
            if (card.getType().equals(cardType)) {
                currTrans = new PurchaseTransaction(card, category, amount);
            }
        }
        //this.points = currTrans.calculatePoints();
        //this.catValue = currTrans.getCard().getCategoryValue(this.category);
        return currTrans;
    }
    public Transaction createRedeemTransaction() {
        currTrans = new RedeemTransaction(amount);
        return currTrans;
    }
}
