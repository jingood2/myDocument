package tk.jingood2.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;
import tk.jingood2.java.service.SearchEngine;
import tk.jingood2.spring.data.DocumentDAO;
import tk.jingood2.spring.data.DocumentRepository;
import tk.jingood2.spring.service.SearchEngineService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */

@Configuration
public class MyDocumentsContext {

    private Map<String,Document> documents = new HashMap<String,Document>();
    private Map<String,Type> types = new HashMap<String, Type>();

    private DocumentDAO documentDAO() {
        DocumentRepository documentDAO = new DocumentRepository();
        //documentDAO.setDoc1(getDocumentFromMap("doc1"));

        return documentDAO;
    }

    private Document getDocumentFromMap(String documentKey) {
        return documents.get(documentKey);
    }

    private Type getTypeFromMap(String typeKey) {
        return types.get(typeKey);
    }



    @Bean
    public Type webType() {
        return getTypeFromMap("webType");
    }

    @Bean
    public SearchEngine engine() {
        SearchEngineService engine = new SearchEngineService();
        engine.setDocumentDAO(documentDAO());
        return engine;
    }

    public MyDocumentsContext() {

        Type type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");

        Document document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");


        documents.put("doc1",document);
        types.put("webType",type);

    }
}
