
class TransactionTest {
    public static void main(String[] args) {
        CreditCard myCard = new BasicCard("Taina", 5000);
        Transaction newTrans = new TravelTransaction(myCard, 55.60);
        //testing method calculatePoints
        System.out.println(myCard.getPointsBal());
        int pointsEarned = newTrans.calculatePoints();
        assert pointsEarned == 278 : "The method calculatePoints returned " + pointsEarned + " but it should have returned 278";

    }

}
