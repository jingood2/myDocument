package tk.jingood2.spring.data;

import tk.jingood2.java.model.Document;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public class DocumentRepository implements DocumentDAO{

    private Document doc1;

    public Document getDoc1() {
        return doc1;
    }

    public void setDoc1(Document doc1) {
        this.doc1 = doc1;
    }

    @Override
    public Document[] getAll() {
        return new Document[] { doc1 };
    }
}
