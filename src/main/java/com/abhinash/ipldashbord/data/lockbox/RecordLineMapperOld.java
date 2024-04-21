package com.abhinash.ipldashbord.data.lockbox;

import org.springframework.batch.item.file.LineMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecordLineMapperOld implements LineMapper<DataEntity> {
    @Override
    public DataEntity mapLine(String line, int lineNumber) throws Exception {
        String recordType = line.substring(0, 1); // Assuming record type is at position 1
        switch (recordType) {
            case "1":
                return mapControlRecord(line);
            case "3":
                return mapControlBatch(line);
            case "4":
                return mapRecordDetail(line);
            case "7":
                return mapBatchTrailer(line);
            default:
                return null;
        }
    }

    private ControlRecord mapControlRecord(String line) {
        ControlRecord controlRecord = new ControlRecord();
        controlRecord.setOrderId(line.substring(1, 14)); // Assuming orderId is from position 2 to 14
        controlRecord.setOrderDate(LocalDateTime.parse(line.substring(14, 41))); // Assuming orderDate is from position 15 to 40
        return controlRecord;
    }

    private ControlBatch mapControlBatch(String line) {
        ControlBatch controlBatch = new ControlBatch();
        controlBatch.setBatchHeader(line.substring(1, 5)); // Assuming batchHeader is from position 2 to 5
        controlBatch.setBatchDate(LocalDate.parse(line.substring(5, 14), DateTimeFormatter.ofPattern("MMddyyyy"))); // Assuming batchDate is from position 6 to 13
        controlBatch.setCompany(line.substring(14, 32)); // Assuming company is from position 14 to 31
        return controlBatch;
    }

    private RecordDetail mapRecordDetail(String line) {
        RecordDetail recordDetail = new RecordDetail();
        recordDetail.setBatchNumber(line.substring(1, 5)); // Assuming batchNumber is from position 2 to 5
        // Map other fields accordingly
        return recordDetail;
    }

    private BatchTrailer mapBatchTrailer(String line) {
        BatchTrailer batchTrailer = new BatchTrailer();
        batchTrailer.setBatchNumber(line.substring(1, 5)); // Assuming batchNumber is from position 2 to 5
        batchTrailer.setTotalBatchRecordCount(Integer.parseInt(line.substring(5, 13))); // Assuming totalBatchRecordCount is from position 6 to 12
        return batchTrailer;
    }
}
