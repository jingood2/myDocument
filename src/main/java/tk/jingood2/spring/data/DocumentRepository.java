package tk.jingood2.spring.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.jingood2.java.model.Document;

import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public class DocumentRepository implements DocumentDAO{

    private static Logger log =
            LoggerFactory.getLogger(DocumentRepository.class);

    private List<Document> documents = null;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public Document[] getAll() {
        if(log.isDebugEnabled())
            log.debug("Start <getAll> Params: ");

        Document[] result = documents.toArray(new Document[documents.size()]);

        if(log.isDebugEnabled())
            log.debug("End <getAll> Result:" + result);

        return result;
    }
}
