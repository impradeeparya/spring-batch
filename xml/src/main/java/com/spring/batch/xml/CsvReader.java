package com.spring.batch.xml;

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
public class CsvReader implements FieldSetMapper<Report> {

    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy");

    public Report mapFieldSet(FieldSet fieldSet) throws BindException {

        Report report = new Report();
        report.setId(fieldSet.readString(0));
        report.setName(fieldSet.readString(1));
        report.setDateOfJoining(LocalDate.parse(fieldSet.readString(2), dtf));

        return report;

    }

}