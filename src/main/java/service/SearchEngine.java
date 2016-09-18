package service;

import model.Document;
import model.Type;

import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public interface SearchEngine {

    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
}
