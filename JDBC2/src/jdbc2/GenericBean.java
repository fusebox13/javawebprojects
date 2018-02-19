package jdbc2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GenericBean {

    private Connection connection;
    private String query;
    String errorMsg;
    GenericBeanResult genericBeanResult;

    public GenericBean(Connection connection, String query) {
        this.connection = connection;
        this.query = query.trim();
        genericBeanResult = new GenericBeanResult();
    }

    public GenericBeanResult getResults() {
        Statement statement = null;
        try {
            if (connection == null)
            {
                genericBeanResult.setErrorMessage("null connection: login error");
                return genericBeanResult;
            }
            statement = connection.createStatement();
            if (!isQuery()) {
                int executeUpdateReturn = statement.executeUpdate(query);
                genericBeanResult.setExecuteUpdateReturn(executeUpdateReturn);

            } else // Process Query
            {
                genericBeanResult = processQuery(statement);
            }
        } catch (SQLException e) {
            String err = "SQLException: " + e;
            genericBeanResult.setErrorMessage(err);
        } finally {
            try {   // Stupid that I need to catch an SQLException here
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
            }
        }

        return genericBeanResult;
    }

    private GenericBeanResult processQuery(Statement statement) throws SQLException {
        GenericBeanResult genericBeanResult = new GenericBeanResult();
        genericBeanResult.isQueryFlag = true;
        ResultSet resultSet = statement.executeQuery(query);

        // Collect data about the query

        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        int num_cols = rsMetaData.getColumnCount();
        String[] colNames = new String[num_cols];

        // Get the names of the columns   

        for (int i = 1; i <= num_cols; i++) {
            colNames[i - 1] = rsMetaData.getColumnName(i);
        }

        ArrayList<GenericDataRow> data = new ArrayList<GenericDataRow>();


        while (resultSet.next()) {
            String[] colData = new String[num_cols];
            for (int i = 1; i <= num_cols; i++) {
                colData[i - 1] = resultSet.getString(i);
            }
            data.add(new GenericDataRow(colData));
        }

        genericBeanResult.setQueryReturn(num_cols, colNames, data);

        return genericBeanResult;
    }

    private boolean isQuery() {
        int index = query.indexOf(' ');
        if (index > 0) {
            String cmd = query.substring(0, index);
            if ("select".compareToIgnoreCase(cmd) == 0) {
                return true;
            }
        }
        return false;
    }
}