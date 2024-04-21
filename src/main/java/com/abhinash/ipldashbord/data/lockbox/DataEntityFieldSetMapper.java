package com.abhinash.ipldashbord.data.lockbox;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


public class DataEntityFieldSetMapper implements FieldSetMapper<DataEntity> {

    @Override
    public DataEntity mapFieldSet(FieldSet fieldSet) throws BindException {
        String recordType = fieldSet.readString(0); // Assuming record type is at position 1
        switch (recordType) {
            case "1":
                return mapControlRecord(fieldSet);
            case "3":
                return mapControlBatch(fieldSet);
            case "4":
                return mapRecordDetail(fieldSet);
            case "7":
                return mapBatchTrailer(fieldSet);
            default:
                return null;
        }
    }

    private ControlRecord mapControlRecord(FieldSet fieldSet) {
        ControlRecord controlRecord = new ControlRecord();
//        controlRecord.setOrderId(fieldSet.readString(1, 13)); // Assuming orderId is from position 2 to 14
//        controlRecord.setOrderDate(LocalDateTime.parse(fieldSet.readString(14, 40))); // Assuming orderDate is from position 15 to 40
        return controlRecord;
    }

    private ControlBatch mapControlBatch(FieldSet fieldSet) {
        ControlBatch controlBatch = new ControlBatch();
//        controlBatch.setBatchHeader(fieldSet.readString(1, 4)); // Assuming batchHeader is from position 2 to 5
//        controlBatch.setBatchDate(LocalDate.parse(fieldSet.readString(5, 13), DateTimeFormatter.ofPattern("MMddyyyy"))); // Assuming batchDate is from position 6 to 13
//        controlBatch.setCompany(fieldSet.readString(13, 18)); // Assuming company is from position 14 to 31
        return controlBatch;
    }

    private RecordDetail mapRecordDetail(FieldSet fieldSet) {
        RecordDetail recordDetail = new RecordDetail();
//        recordDetail.setBatchNumber(fieldSet.readString(1, 4)); // Assuming batchNumber is from position 2 to 5
        // Map other fields accordingly
        return recordDetail;
    }

    private BatchTrailer mapBatchTrailer(FieldSet fieldSet) {
        BatchTrailer batchTrailer = new BatchTrailer();
//        batchTrailer.setBatchNumber(fieldSet.readString(1, 4)); // Assuming batchNumber is from position 2 to 5
//        batchTrailer.setTotalBatchRecordCount(fieldSet.readInt(5, 12)); // Assuming totalBatchRecordCount is from position 6 to 12
        return batchTrailer;
    }
}
