package com.spring.batch.handler;

import com.spring.batch.model.Employee;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 17/2/17
 * Time: 11:24 AM
 */

@Component("employeeXmlHandler")
public class EmployeeXmlHandler extends DefaultHandler {

    private List<Employee> employees;
    private Employee employee;
    private Stack<String> tagStack;

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("company")) {
            employees = new ArrayList<>();
            tagStack = new Stack<>();
        } else if (qName.equalsIgnoreCase("employee")) {
            employee = new Employee();
        } else {
            tagStack.push(qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            employees.add(employee);
            employee = null;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        String tagValue = new String(ch, start, length);
        String tag = tagStack.pop();

        if (tag.equalsIgnoreCase("dateOfJoining")) {
            employee.setDateOfJoining(LocalDate.parse(tagValue));
        } else if (tag.equalsIgnoreCase("id")) {
            employee.setId(tagValue);
        } else if (tag.equalsIgnoreCase("name")) {
            employee.setName(tagValue);
        }
    }
}
