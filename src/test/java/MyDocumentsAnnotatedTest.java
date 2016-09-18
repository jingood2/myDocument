

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;
import tk.jingood2.java.service.SearchEngine;

import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public class MyDocumentsAnnotatedTest {

    private ApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("META-INF/mydocument-annotations-context.xml");

    }



    /*
    @Test
    public void testWithAnnotationsFindByType() {
        List<Document>  documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size()==1);
    }

    @Test
    public void testWithAnnotationsListAll() {
        List<Document>  documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size()==1);

    }
    */
}
