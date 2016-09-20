import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;
import tk.jingood2.java.service.SearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 21..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/mydocument-context.xml")
public class MyDocumentsAOPTest {

    private static final Logger log =
            LoggerFactory.getLogger(MyDocumentsAOPTest.class);

    @Autowired
    private SearchEngine engineProxy;
    @Autowired
    private Type webType;

    @Test
    public void testUsingSpringAOP() {
        log.debug("Using Spring AOP:");

        List<Document> documents = engineProxy.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size()==1);

        documents = engineProxy.listAll();
        assertNotNull(documents);
        assertTrue(documents.size()==1);

        try {
            engineProxy.findByLocation("/some/path/");
        } catch(Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
