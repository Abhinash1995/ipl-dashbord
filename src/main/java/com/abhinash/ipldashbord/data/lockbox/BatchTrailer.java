package com.abhinash.ipldashbord.data.lockbox;

public class BatchTrailer implements DataEntity{

    private String batchNumber;
    private int totalBatchRecordCount;

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

    public int getTotalBatchRecordCount() {
        return totalBatchRecordCount;
    }

    public void setTotalBatchRecordCount(int totalBatchRecordCount) {
        this.totalBatchRecordCount = totalBatchRecordCount;
    }

    @Override
    public String toString() {
        return "BatchTrailer{" +
                "batchNumber='" + batchNumber + '\'' +
                ", totalBatchRecordCount=" + totalBatchRecordCount +
                '}';
    }
}
