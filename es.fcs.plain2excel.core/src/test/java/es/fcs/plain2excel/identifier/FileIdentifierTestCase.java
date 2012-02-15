package es.fcs.plain2excel.identifier;

import es.fcs.plain2excel.converter.Plain2XMLConverter;

import junit.framework.TestCase;

public class FileIdentifierTestCase extends TestCase {
	public void testIdentifyBalance() throws Exception{
//		String xml ="<kkota><line/><line>perra</line></kkota>";
		Plain2XMLConverter converter = new Plain2XMLConverter();
		String xml = converter.convert("./src/test/resources/balance");
		FileIdentifier fi = new FileIdentifier();
		
		assertEquals(FileIdentifier.BALANCE, fi.identify(xml));
	}
	
	public void testIdentifyCostes() throws Exception{
//		String xml ="<kkota><line/><line>perra</line></kkota>";
		Plain2XMLConverter converter = new Plain2XMLConverter();
		String xml = converter.convert("./src/test/resources/costes");
		FileIdentifier fi = new FileIdentifier();
		
		assertEquals(FileIdentifier.COSTES, fi.identify(xml));
	}
	
	public void testIdentifyMayor() throws Exception{
//		String xml ="<kkota><line/><line>perra</line></kkota>";
		Plain2XMLConverter converter = new Plain2XMLConverter();
		String xml = converter.convert("./src/test/resources/mayor");
		FileIdentifier fi = new FileIdentifier();
		
		assertEquals(FileIdentifier.MAYOR, fi.identify(xml));
	}
	
	public void testIdentifyResultados() throws Exception{
//		String xml ="<kkota><line/><line>perra</line></kkota>";
		Plain2XMLConverter converter = new Plain2XMLConverter();
		String xml = converter.convert("./src/test/resources/resultados");
		FileIdentifier fi = new FileIdentifier();
		
		assertEquals(FileIdentifier.RESULTADOS, fi.identify(xml));
	}
}
