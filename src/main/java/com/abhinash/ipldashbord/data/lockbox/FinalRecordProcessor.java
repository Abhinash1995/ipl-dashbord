package com.abhinash.ipldashbord.data.lockbox;

import org.springframework.batch.item.ItemProcessor;

import java.util.ArrayList;
import java.util.List;

public class FinalRecordProcessor implements ItemProcessor<DataEntity, FinalRecord> {

    private ControlRecord controlRecord;
    private ControlBatch controlBatch;
    private List<RecordDetail> recordDetails;
    private BatchTrailer batchTrailer;

    @Override
    public FinalRecord process(DataEntity item) throws Exception {
        if (item instanceof ControlRecord) {
            controlRecord = (ControlRecord) item;
        } else if (item instanceof ControlBatch) {
            controlBatch = (ControlBatch) item;
        } else if (item instanceof RecordDetail) {
            if (recordDetails == null) {
                recordDetails = new ArrayList<>();
            }
            recordDetails.add((RecordDetail) item);
        } else if (item instanceof BatchTrailer) {
            batchTrailer = (BatchTrailer) item;
        }

        if (controlRecord != null && controlBatch != null && batchTrailer != null) {
            FinalRecord finalRecord = new FinalRecord(controlRecord, controlBatch, recordDetails, batchTrailer);
            // Reset fields for the next set of records
            controlRecord = null;
            controlBatch = null;
            recordDetails = null;
            batchTrailer = null;
            return finalRecord;
        }

        return null; // Return null until all components are available
    }
}
