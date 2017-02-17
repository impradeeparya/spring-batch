package com.spring.batch.processor;

import com.spring.batch.model.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 15/2/17
 * Time: 10:16 PM
 */

@Component("itemProcessor")
public class CsvProcessor implements ItemProcessor<Employee, Employee> {

    public Employee process(Employee item) throws Exception {

        System.out.println("Processing..." + item);
        return item;
    }

}
