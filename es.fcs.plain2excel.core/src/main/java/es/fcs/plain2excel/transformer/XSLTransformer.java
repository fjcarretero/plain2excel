package es.fcs.plain2excel.transformer;


import java.io.Reader;

import java.io.StringWriter;
import java.io.Writer;

import java.net.URL;

import org.apache.log4j.Logger;

public class XSLTransformer {
	private static Logger log = Logger.getLogger(XSLTransformer.class);
	
	public Writer transform(Reader source, String template) throws Exception{
			//File xmlFile = new File(file);
			//File xsltFile = new File(template);
			StringWriter output = new StringWriter();
			log.info("Appliying template " + template);
			URL url = XSLTransformer.class.getResource(template);
			javax.xml.transform.Source xmlSource =
			    new javax.xml.transform.stream.StreamSource(source);
			javax.xml.transform.Source xsltSource =
			    new javax.xml.transform.stream.StreamSource(url.openStream());
				//new javax.xml.transform.stream.StreamSource(template);
			javax.xml.transform.Result result =
			    new javax.xml.transform.stream.StreamResult(output);
 
			xsltSource.setSystemId(url.toExternalForm());
			// create an instance of TransformerFactory
			javax.xml.transform.TransformerFactory transFact =
			    javax.xml.transform.TransformerFactory.newInstance( );
 
			javax.xml.transform.Transformer trans =
			    transFact.newTransformer(xsltSource);
 
			trans.transform(xmlSource, result);
			return output;
	}
	
	public Writer transform(Reader source, URL url) throws Exception{
		//File xmlFile = new File(file);
		//File xsltFile = new File(template);
		StringWriter output = new StringWriter();
		log.info("Appliying template " + url.toExternalForm());
		javax.xml.transform.Source xmlSource =
		    new javax.xml.transform.stream.StreamSource(source);
		javax.xml.transform.Source xsltSource =
		    new javax.xml.transform.stream.StreamSource(url.openStream());
			//new javax.xml.transform.stream.StreamSource(template);
		javax.xml.transform.Result result =
		    new javax.xml.transform.stream.StreamResult(output);

		xsltSource.setSystemId(url.toExternalForm());
		// create an instance of TransformerFactory
		javax.xml.transform.TransformerFactory transFact =
		    javax.xml.transform.TransformerFactory.newInstance( );

		javax.xml.transform.Transformer trans =
		    transFact.newTransformer(xsltSource);

		trans.transform(xmlSource, result);
		return output;
}
}
