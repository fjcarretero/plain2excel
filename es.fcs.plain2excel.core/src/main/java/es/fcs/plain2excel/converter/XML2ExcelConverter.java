package es.fcs.plain2excel.converter;
import java.io.FileOutputStream;
import java.io.Reader;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.avalon.excalibur.logger.Log4JLogger;
import org.apache.avalon.framework.logger.Logger;
import org.apache.cocoon.serialization.HSSFSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class XML2ExcelConverter {

	private org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(XML2ExcelConverter.class);

	
	public void convert(Reader aux, String file) throws Throwable {
			try {
				Logger logger = new Log4JLogger(log4j);
				HSSFSerializer serializer = new HSSFSerializer();
				serializer.enableLogging(logger);
				logger.debug("kkota");
				XMLReader reader = null;
				reader = XMLReaderFactory.createXMLReader();
				
				serializer.initialize();
				
				reader.setContentHandler(serializer);
				InputSource inputSource = new InputSource(aux);
				//InputSource inputSource = new InputSource(XML2ExcelConverter.class.getClassLoader().getResourceAsStream(aux));

				serializer.setOutputStream(new FileOutputStream(file));
				reader.parse(inputSource);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				log4j.error("error", e);
				throw e;
			}
	}
	
	public void toXSLT(String file){
		
	    try {
			//File xmlFile = new File(file);
			//File xsltFile = new File("xslt.xsl");
 
			javax.xml.transform.Source xmlSource =
			    new javax.xml.transform.stream.StreamSource(XML2ExcelConverter.class.getResourceAsStream(file));
			javax.xml.transform.Source xsltSource =
			    new javax.xml.transform.stream.StreamSource(XML2ExcelConverter.class.getResourceAsStream("xslt.xsl"));
			javax.xml.transform.Result result =
			    new javax.xml.transform.stream.StreamResult(System.out);
 
			// create an instance of TransformerFactory
			javax.xml.transform.TransformerFactory transFact =
			    javax.xml.transform.TransformerFactory.newInstance( );
 
			javax.xml.transform.Transformer trans =
			    transFact.newTransformer(xsltSource);
 
			trans.transform(xmlSource, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
