import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.jingood2.java.service.SearchEngine;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */

public class MyDocumentsWithSpringTest {

    private ClassPathXmlApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setup() {

        context = new ClassPathXmlApplicationContext("META-INF/mydocument-context.xml");
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean("webType", Type.class);

    }

    @Test
    public void testWithSpringFindByType() {

        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(),documents.get(0).getType().getName());
    }

    @Test
    public void testWithSpringlistAll() {

        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 1);

    }
}
