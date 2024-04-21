package com.abhinash.ipldashbord.data.lockbox;

import java.util.List;

public class FinalRecord {

    private ControlRecord controlRecord;

    private ControlBatch batch;

    private List<RecordDetail> recordDetails;

    private BatchTrailer trailer;

    public FinalRecord(ControlRecord controlRecord, ControlBatch controlBatch, List<RecordDetail> recordDetails, BatchTrailer batchTrailer) {
        this.controlRecord = controlRecord;
        this.batch = controlBatch;
        this.recordDetails = recordDetails;
        this.trailer = batchTrailer;
    }

    public ControlRecord getControlRecord() {
        return controlRecord;
    }

    public void setControlRecord(ControlRecord controlRecord) {
        this.controlRecord = controlRecord;
    }

    public ControlBatch getBatch() {
        return batch;
    }

    public void setBatch(ControlBatch batch) {
        this.batch = batch;
    }

    public List<RecordDetail> getRecordDetails() {
        return recordDetails;
    }

    public void setRecordDetails(List<RecordDetail> recordDetails) {
        this.recordDetails = recordDetails;
    }

    public BatchTrailer getTrailer() {
        return trailer;
    }

    public void setTrailer(BatchTrailer trailer) {
        this.trailer = trailer;
    }
}
