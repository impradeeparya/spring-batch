package com.spring.batch.model;

import com.spring.batch.adapter.DateAdapter;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 15/2/17
 * Time: 10:15 PM
 */

@Component("employee")
@XmlRootElement(name = "employee")
public class Employee {

    private String id;
    private String name;
    private LocalDate dateOfJoining;

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "dateOfJoining")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee [id : " + id + ", name : " + name + ", dateOfJoining : " + dateOfJoining + "]";
    }

}
