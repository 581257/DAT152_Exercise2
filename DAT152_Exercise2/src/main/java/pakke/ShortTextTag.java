package pakke;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.JspFragment;


public class ShortTextTag extends SimpleTagSupport{
	private int max;
	
	public final void setMax(int max) {
		this.max = max;
	}
	
	 @Override
	    public final void doTag() throws JspException, IOException {
	        PageContext pageContext = (PageContext) getJspContext();
	        JspWriter out = pageContext.getOut();
	        StringWriter stringWriter = new StringWriter();
	        JspFragment body = getJspBody();
	        body.invoke(stringWriter);
	        String bodyText = stringWriter.getBuffer().toString();
	        bodyText = bodyText.substring(0, Math.min(bodyText.length(), 10));
	        out.println(bodyText);
	    }

}
