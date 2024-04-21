package com.abhinash.ipldashbord.data.lockbox;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MyItemWriter implements ItemWriter<FinalRecord> {

    @Override
    public void write(List<? extends FinalRecord> list) throws Exception {
           for (FinalRecord record : list){
               System.out.println(record);
           }
    }
}
