package es.fcs.plain2excel.commands;

import java.io.StringReader;
import java.io.Writer;
import java.net.URL;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import es.fcs.plain2excel.transformer.XSLTransformer;

public class RemovePaging implements Command {
	private Logger log = Logger.getLogger(RemovePaging.class);
	
	public boolean execute(Context ctx) throws Exception {
		XSLTransformer transformer = new XSLTransformer();
		log.info("Executing xsl transformation /removePaging.stx");
		Writer writer = null;
		if(ctx.containsKey("template")){
			writer = transformer.transform(new StringReader((String)ctx.get("xml")), (String)ctx.get("removePagingTemplate")); 
		} else {
			writer = transformer.transform(new StringReader((String)ctx.get("xml")), (URL)ctx.get("removePagingUrl")); 
		}
		ctx.put("xml", writer.toString());
		return false;
	}
}
