package tk.jingood2.spring.data;

/**
 * Created by KimJin-young on 2016. 9. 21..
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;

import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 21..
 */
public interface TypeDataDAO {

    public Type[] getAll();
    public Type findById(String id);

}
