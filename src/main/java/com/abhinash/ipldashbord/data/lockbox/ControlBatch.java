package com.abhinash.ipldashbord.data.lockbox;

import java.time.LocalDate;

public class ControlBatch implements DataEntity{

    private String batchHeader;
    private LocalDate batchDate;
    private String company;

    @Override
    public DataEntity map(String line) {
        return null;
    }

    public String getBatchHeader() {
        return batchHeader;
    }

    public void setBatchHeader(String batchHeader) {
        this.batchHeader = batchHeader;
    }

    public LocalDate getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(LocalDate batchDate) {
        this.batchDate = batchDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "ControlBatch{" +
                "batchHeader='" + batchHeader + '\'' +
                ", batchDate=" + batchDate +
                ", company='" + company + '\'' +
                '}';
    }
}
