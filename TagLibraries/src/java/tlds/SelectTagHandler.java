package tlds;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectTagHandler extends SimpleTagSupport implements DynamicAttributes
{
    private List<String> optionsList;
    private String name;
    private String size;

    public void setOptionsList(List<String> list)
    {
        optionsList = list;
    }
    public void setName(String value)
    {
        this.name = value;
    }

    private Map<String, Object> tagAttrs = new HashMap<String, Object>();
    public void setDynamicAttribute(String uri, String name, Object value)
    {
        tagAttrs.put(name, value);
    }
    


    public void doTag() throws JspException, IOException
    {                
        PageContext pageContext = (PageContext)getJspContext();
        JspWriter out = pageContext.getOut();
    
        // Start the HTML (select> tag with HTML-specific attributes
        out.println();
        out.print("<select ");
        // add mandatory attribute
        out.print(String.format("%s = '%s' ", "name", this.name));
        
        // add dynamic attributes
        for (String attrName : tagAttrs.keySet())
        {
            String attrDefinition = String.format("%s = '%s' ", attrName, tagAttrs.get(attrName));
            out.print(attrDefinition);
        }

        out.println(">");

        for (int i=0; i < optionsList.size(); i++)
        {
            String s=optionsList.get(i);
            out.println(String.format(" <option value='%s'> %s </option>", s,s));
        }

        out.println("</select>");


    }
}