/**
 * Created by KimJin-young on 2016. 9. 19..
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;
import tk.jingood2.java.service.SearchEngine;
import tk.jingood2.spring.config.MyDocumentsContext;

import java.util.List;


public class MyDocumentsBeanConfigurationTest {

    private ApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setup() {

        context = new AnnotationConfigApplicationContext(MyDocumentsContext.class);
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean(Type.class);

    }

    @Test
    public void testWithBeanConfigurationFindByType() {

        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(),documents.get(0).getType().getName());
    }

    @Test
    public void testWithBeanConfigurationListAll() {

        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 1);

    }


}
