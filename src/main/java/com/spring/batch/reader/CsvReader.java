package com.spring.batch.reader;

import com.spring.batch.model.Employee;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 15/2/17
 * Time: 10:17 PM
 */
public class CsvReader implements FieldSetMapper<Employee> {

    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy");

    public Employee mapFieldSet(FieldSet fieldSet) throws BindException {

        Employee employee = new Employee();
        employee.setId(fieldSet.readString(0));
        employee.setName(fieldSet.readString(1));
        employee.setDateOfJoining(LocalDate.parse(fieldSet.readString(2), dtf));

        return employee;

    }

}