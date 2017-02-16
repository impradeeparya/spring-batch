package com.spring.batch.xml;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 15/2/17
 * Time: 10:16 PM
 */
public class CsvProcessor implements ItemProcessor<Report, Report> {

    public Report process(Report item) throws Exception {

        System.out.println("Processing..." + item);
        return item;
    }

}
