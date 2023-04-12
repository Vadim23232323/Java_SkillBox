public class Account
{
    private String accNumber;
    private long money;
    private boolean withoutBlockAcc;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
        this.withoutBlockAcc = true;
    }


    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isWithoutBlockAcc() {
        return withoutBlockAcc;
    }

    public void setWithoutBlockAcc(boolean withoutBlockAcc) {
        this.withoutBlockAcc = withoutBlockAcc;
    }

}
