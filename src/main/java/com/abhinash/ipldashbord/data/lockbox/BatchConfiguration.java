//package com.abhinash.ipldashbord.data.lockbox;
//
//import com.abhinash.ipldashbord.data.MatchDataProcessor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import java.util.List;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfiguration {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public FlatFileItemReader<DataEntity> itemReader() {
//        return new FlatFileItemReaderBuilder<DataEntity>()
//                .name("itemReader")
//                .resource(new ClassPathResource("abc.txt")) // Adjust the path to your text file
//                .lineTokenizer(new DelimitedLineTokenizer(";"))
////                .fieldSetMapper(new DataEntityFieldSetMapper())
//                .lineMapper(new RecordLineMapper())
//                .build();
//    }
//
//    @Bean
//    public ItemProcessor<DataEntity, DataEntity> itemProcessor() {
//        return new ItemProcessor<DataEntity, DataEntity>() {
//            @Override
//            public DataEntity process(DataEntity item) throws Exception {
//                // Implement your processing logic here
//                return item;
//            }
//        };
//    }
//
//    @Bean
//    public ItemWriter<DataEntity> itemWriter() {
//        return new ItemWriter<DataEntity>() {
//            @Override
//            public void write(List<? extends DataEntity> items) throws Exception {
//                for (DataEntity item : items) {
//                    // Implement your writing logic here
//                    System.out.println(item); // For example, print to console
//                }
//            }
//        };
//    }
//
//    @Bean
//    public Step step2(ItemReader<DataEntity> reader, ItemProcessor<DataEntity, DataEntity> processor,
//                      ItemWriter<DataEntity> writer) {
//        return stepBuilderFactory.get("step2")
//                .<DataEntity, DataEntity>chunk(10)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
//
//    @Bean
//    public Job job(Step step2) {
//        return jobBuilderFactory.get("job")
//                .incrementer(new RunIdIncrementer())
//                .flow(step2)
//                .end()
//                .build();
//    }
//}
