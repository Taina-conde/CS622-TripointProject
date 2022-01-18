
class TransactionTest {
    public static void main(String[] args) {
        CreditCard basicCard = new BasicCard("Taina", 5000);
        CreditCard preferredCard = new BasicCard("Taina");
        Transaction newTrans = new CategoryTransaction(basicCard,"travel", 55.60);
        //testing method calculatePoints
        System.out.println(basicCard.getPointsBal());
        int pointsEarned = newTrans.calculatePoints();
        System.out.println(pointsEarned);
        assert pointsEarned == 278 : "The method calculatePoints returned " + pointsEarned + " but it should have returned 278";
        newTrans = new CategoryTransaction(preferredCard,"travel", 10);
        System.out.println(CreditCard.getPointsBal());
        pointsEarned = newTrans.calculatePoints();
        System.out.println(pointsEarned);
        System.out.println(CreditCard.getPointsBal());


    }

}
