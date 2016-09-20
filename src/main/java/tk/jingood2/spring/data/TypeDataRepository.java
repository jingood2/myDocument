package tk.jingood2.spring.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;

import java.util.List;
import java.util.Map;

/**
 * Created by KimJin-young on 2016. 9. 21..
 */
public class TypeDataRepository implements TypeDataDAO {

    private static Logger log =
            LoggerFactory.getLogger(TypeDataRepository.class);

    private Map<String,Type> types = null;

    public Map<String, Type> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Type> types) {
        this.types = types;
    }

    @Override
    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }

    @Override
    public Type findById(String id) {
        if(log.isDebugEnabled())
            log.debug("Start <findById> Params: " + id);

        Type type = types.get(id);

        if(log.isDebugEnabled())
            log.debug("End <findById> Params: " + type);
        return type;

    }
}
