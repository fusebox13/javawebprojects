
package jdbc2;

public class GenericDataRow
{
    String[] dataRow;
    GenericDataRow(String[] dataRow)
    {
        this.dataRow = dataRow;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < dataRow.length; i++)
        {
            sb.append(dataRow[i]);
            sb.append(" \t");
        }
        return sb.toString();
    }
}