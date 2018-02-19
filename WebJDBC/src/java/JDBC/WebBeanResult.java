package JDBC;


public class WebBeanResult {

    GenericBeanResult genericBeanResult;

    public WebBeanResult(GenericBeanResult gbr) {
        genericBeanResult = gbr;
    }

    public String toHtml() {
        String endLine = System.getProperty("line.separator");

        if (genericBeanResult.errorMessage != null) {
            return "Error Message =" + genericBeanResult.errorMessage;
        } else if (!genericBeanResult.isQueryFlag) {
            return "Non-Query Return = "
                    + genericBeanResult.executeUpdateReturn;
        } else {
            // Return results of the query

            StringBuilder sb = new StringBuilder();
            sb.append("num_rows=");
            sb.append(genericBeanResult.queryData.size());
            sb.append("  num_cols=");
            sb.append(genericBeanResult.num_cols);
            sb.append(genericBeanResult.endLine);

            sb.append(genericBeanResult.endLine + "<br>");
            
            sb.append("<table border=\"4\">");
            sb.append("<tr><th>");
            for (int i = 0; i < genericBeanResult.colNames.length; i++) {
                sb.append(genericBeanResult.colNames[i]);
                if (i < genericBeanResult.colNames.length - 1) {
                    sb.append("</th><th>");
                }
            }
            sb.append("</th></tr>" + endLine);

            for (int r = 0; r < genericBeanResult.queryData.size(); r++) {
                GenericDataRow gdr = genericBeanResult.queryData.get(r);
                sb.append("<tr><td>");
                for (int c = 0; c < gdr.dataRow.length; c++) {
                    sb.append(gdr.dataRow[c]);
                    if (c < gdr.dataRow.length - 1) {
                        sb.append("</td><td>");
                    }
                }
                sb.append("</td></tr>" + endLine);
            }
            sb.append("</table>");
            return sb.toString();
        }
    }
}