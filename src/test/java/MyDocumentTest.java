import model.Document;
import model.Type;
import org.junit.Test;
import static org.junit.Assert.*;
import service.MySearchEngine;
import service.SearchEngine;

import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public class MyDocumentTest {

    private SearchEngine engine = new MySearchEngine();

    @Test
    public void testFindByType() {

        Type documentType = new Type();
        documentType.setName("WEB");
        documentType.setDesc("Web Link");
        documentType.setExtension(".url");

        List<Document> documents = engine.findByType(documentType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(documentType.getName(),documents.get(0).getType().getName());
    }

    @Test
    public void testlistAll() {

        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 1);

    }
}
