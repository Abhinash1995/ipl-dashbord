package com.abhinash.ipldashbord.data.lockbox;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RecordDetail implements DataEntity{
    private String batchNumber;
    private String transactionNumber;
    private String masterCompanyNumber;
    private String idType;
    private String accountNumber;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDate postMarkDate;

    @Override
    public DataEntity map(String line) {
        return null;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getMasterCompanyNumber() {
        return masterCompanyNumber;
    }

    public void setMasterCompanyNumber(String masterCompanyNumber) {
        this.masterCompanyNumber = masterCompanyNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPostMarkDate() {
        return postMarkDate;
    }

    public void setPostMarkDate(LocalDate postMarkDate) {
        this.postMarkDate = postMarkDate;
    }
}
