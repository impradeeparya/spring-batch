package com.spring.batch.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 17/2/17
 * Time: 12:02 PM
 */
public class DateAdapter extends XmlAdapter<String, LocalDate> {

    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy");

    @Override
    public LocalDate unmarshal(String localDate) throws Exception {
        return LocalDate.parse(localDate, dtf);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.toString();
    }
}
