package Bank;

import java.util.Date;

public class BankStatement {

    private String accountType, accountNumber, currency, wiringReference, operationDescription;
    private Integer coming, consumption;
    private Date dateOperation;

    public BankStatement(String accountType, String accountNumber, String currency, Date dateOperation, String wiringReference, String operationDescription, Integer coming, Integer consumption)
    {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.dateOperation = dateOperation;
        this.wiringReference = wiringReference;
        this.operationDescription = operationDescription;
        this.coming = coming;
        this.consumption = consumption;
    }


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getWiringReference() {
        return wiringReference;
    }

    public void setWiringReference(String wiringReference) {
        this.wiringReference = wiringReference;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getComing() {
        return coming;
    }

    public void setComing(Integer coming) {
        this.coming = coming;
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

}
