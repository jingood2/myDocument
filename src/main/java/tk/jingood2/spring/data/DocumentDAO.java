package tk.jingood2.spring.data;

import tk.jingood2.java.model.Document;

import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public interface DocumentDAO {
    public List<Document> getAll();
}
