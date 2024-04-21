package com.abhinash.ipldashbord.data.lockbox;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration1 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<DataEntity> itemReader() {
        return new FlatFileItemReaderBuilder<DataEntity>()
                .name("itemReader")
                .resource(new ClassPathResource("abc.txt")) // Adjust the path to your text file
                .lineTokenizer(new DelimitedLineTokenizer(";"))
//                .fieldSetMapper(new DataEntityFieldSetMapper())
                .lineMapper(new RecordLineMapper())
                .build();
    }


    @Bean
    public FinalRecordProcessor processor1() {
        return new FinalRecordProcessor();
    }

    @Bean
    public MyItemWriter itemWriter() {
        return new MyItemWriter();
    }


    @Bean
    public Step step2() {
        return stepBuilderFactory
                .get("step1")
                .<DataEntity, FinalRecord>chunk(10)
                .reader(itemReader())
                .processor(processor1())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Job job(Step step2) {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(step2)
                .end()
                .build();
    }
}
