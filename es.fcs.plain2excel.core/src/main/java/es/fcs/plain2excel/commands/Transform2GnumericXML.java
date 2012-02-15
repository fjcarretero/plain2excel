package es.fcs.plain2excel.commands;

import java.io.StringReader;
import java.io.Writer;
import java.net.URL;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import es.fcs.plain2excel.transformer.XSLTransformer;

public class Transform2GnumericXML implements Command {
	private Logger log = Logger.getLogger(Transform2GnumericXML.class);
	
	public boolean execute(Context ctx) throws Exception {
		XSLTransformer transformer = new XSLTransformer();
		log.info("Executing xsl transformation ");
		Writer writer = null;
		if(ctx.containsKey("template")){
			writer = transformer.transform(new StringReader((String)ctx.get("xml")), (String)ctx.get("template"));
		} else {
			writer = transformer.transform(new StringReader((String)ctx.get("xml")), (URL)ctx.get("url"));
		}
		ctx.put("xml_excel", writer.toString());
		return false;
	}

}
