package com.spring.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 15/2/17
 * Time: 10:16 PM
 */

@Component("itemProcessor")
public class CsvProcessor implements ItemProcessor<Report, Report> {

    public Report process(Report item) throws Exception {

        System.out.println("Processing..." + item);
        return item;
    }

}
