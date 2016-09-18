package tk.jingood2.spring.annotated.data;

import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;
import org.springframework.stereotype.Repository;
import tk.jingood2.spring.data.DocumentDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
@Repository("documentDAO")
public class AnnotatedDocumentRepository implements DocumentDAO {

    @Override
    public Document[] getAll() {
        return storage();
    }

    public Document[] storage() {
        List<Document> result = new ArrayList<Document>();

        Type type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");

        Document document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        result.add(document);

        return result.toArray(new Document[result.size()]);
    }
}
