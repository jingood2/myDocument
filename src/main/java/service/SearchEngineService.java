package service;

import data.DocumentDAO;
import model.Document;
import model.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public class SearchEngineService implements SearchEngine {

    private DocumentDAO documentDAO;

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

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
