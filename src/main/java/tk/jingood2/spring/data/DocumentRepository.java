package tk.jingood2.spring.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.jingood2.java.model.Document;
import tk.jingood2.java.model.Type;

import javax.sql.DataSource;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KimJin-young on 2016. 9. 18..
 */
public class DocumentRepository implements DocumentDAO{

    private DataSource dataSource;

    private static Logger log =
            LoggerFactory.getLogger(DocumentRepository.class);

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Document> getAll() {

        List<Document> result = new ArrayList<Document>();
        Connection connection = null;
        Statement   statement = null;
        ResultSet   resultSet = null;
        Document    document = null;
        Type type = null;

        try {
            connection =  dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from documents");

            while(resultSet.next()) {
                document = new Document();
                document.setDocumentId(resultSet.getString("documentId"));
                document.setName(resultSet.getString("name"));
                document.setLocation(resultSet.getString("location"));
                document.setCreated(resultSet.getString("created"));
                document.setCreated(resultSet.getString("modified"));
                document.setCreated(resultSet.getString("description"));

                result.add(document);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch(SQLException ex) {

                }
            }
        }

        return result;

    }
}
