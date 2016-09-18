package tk.jingood2.spring.annotated.service;

import tk.jingood2.spring.data.DocumentDAO;
import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jingood2.java.service.SearchEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
@Service("engine")
public class AnnotatedSearchEngine implements SearchEngine {

    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for(Document document : listAll()) {
            if(document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }
        return result;
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }
}
