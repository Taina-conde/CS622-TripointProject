# Tripoint : A Points System for Credit Cards
This project concerns a points system for credit card purchases. 
The users accumulate points by making purchases with their credit cards. 
The point value depends on the credit card they used, the category of the
purchase (dining, travel, online shopping, and grocery), and the transaction’s
amount. 	

For every purchase the user registers, the system collects information 
about the credit card used and the category of the purchase. 
Then, it calculates the points earned and adds them to the overall 
sum of points in the user’s account. The goal of the user is to eventually 
redeem these points for travel. This points system is called Tripoint.


## Documentation

The project directory:
* src.edu.bu.tbconde.tripoint
  * views
    * AppView.java
    * NewTransactionView.java
    * PastTransactionsView.java
    * WelcomeView.java
    * MainMenuView.java
  * controllers
    * AppController.java
    * NewTransactionController.java
    * PastTransactionsController.java
    * WelcomeController.java
    * MainMenuController.java
  * models
    * NewTransactionModel.java
    * PastTransactionsModel.java
    * WelcomeModel.java
    * MainMenuModel.java
    * AppModel.java
  * cards
    * BasicCard.java
    * CreditCard.java
    * PreferredCard.java
  * transactions
    * CategoryTransaction.java
    * Transaction.java
  * util
    * RecordsReader.java
    * RecordsWriter.java
    * Wallet.java
  * io
    * transactionsRecords.txt
* tests.edu.bu.tbconde.tripoint


## Instructions to execute

Go to controllers package, open the AppController.java file and run the main method in a code editor.

