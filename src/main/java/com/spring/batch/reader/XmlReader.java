package com.spring.batch.reader;

import com.spring.batch.handler.EmployeeXmlHandler;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 16/2/17
 * Time: 11:08 PM
 */

@Component("xmlFileReader")
public class XmlReader implements Tasklet {

    @Autowired
    private EmployeeXmlHandler employeeXmlHandler;

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        System.out.println(read(new File("output/report.xml")));
        return RepeatStatus.FINISHED;
    }

    public List<? extends Object> read(File file) throws IOException, SAXException, ParserConfigurationException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.parse(file, employeeXmlHandler);

        return employeeXmlHandler.getEmployees();

    }
}
