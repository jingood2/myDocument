package tk.jingood2.java.service;

import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;
import tk.jingood2.java.service.SearchEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public class MySearchEngine implements SearchEngine {

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();

        for(Document document : storage()) {
            if(document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }
        return result;
    }

    @Override
    public List<Document> listAll() {

        return storage();
    }

    @Override
    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("findByLocation not yet implemented.");
    }

    private List<Document> storage() {
        List<Document> result = new ArrayList<Document>();

        Type type = new Type();
        type.setName("WEB");
        type.setExtension(".url");
        type.setDesc("Web Link");

        Document document = new Document();
        document.setName("Pro String Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        result.add(document);

        return result;
    }
}
