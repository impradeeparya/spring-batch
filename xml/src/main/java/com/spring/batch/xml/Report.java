package com.spring.batch.xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 15/2/17
 * Time: 10:15 PM
 */
@XmlRootElement(name = "record")
public class Report {

    private String id;
    private String name;
    private LocalDate dateOfJoining;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Report [id : " + id + ", name : " + name + ", dateOfJoining : " + dateOfJoining + "]";
    }

}
