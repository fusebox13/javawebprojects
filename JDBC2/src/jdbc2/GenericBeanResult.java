package jdbc2;

import java.util.ArrayList;

public class GenericBeanResult {

    boolean isQueryFlag = false;
    String errorMessage = null;
    int executeUpdateReturn = 0;
    int num_cols = 0;
    String[] colNames = null;
    ArrayList<GenericDataRow> queryData = null;
    String endLine = System.getProperty("line.separator");

    public String toString() {

        if (errorMessage != null) {
            return "Error Message =" + errorMessage;
        } else if (!isQueryFlag) {
            return "Non-Query Return = " + executeUpdateReturn;
        } else {
           // Return results of the query

            StringBuilder sb = new StringBuilder();
            sb.append("num_rows=");
            sb.append(queryData.size());
            sb.append("  num_cols=");
            sb.append(num_cols);
            sb.append(endLine);

            sb.append(endLine);
            sb.append("Column Names = ");
            sb.append(endLine);
            for (int i = 0; i < colNames.length; i++) {
                sb.append(colNames[i]);
                sb.append(" \t");
            }
            sb.append(endLine);
            sb.append("Data = ");
            sb.append(endLine);

            for (int r = 0; r < queryData.size(); r++) {
                GenericDataRow gdr = queryData.get(r);
                sb.append(gdr.toString());
                sb.append(endLine);
            }
            return sb.toString();
        }
    }

    public boolean isQuery() {
        return isQueryFlag;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getExecuteUpdateReturn() {
        return executeUpdateReturn;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setExecuteUpdateReturn(int executeUpdateReturn) {
        this.executeUpdateReturn = executeUpdateReturn;
    }

    public void setQueryReturn(int num_cols, String[] colNames, ArrayList<GenericDataRow> queryData) {
        this.num_cols = num_cols;
        this.colNames = colNames;
        this.queryData = queryData;
    }
}
