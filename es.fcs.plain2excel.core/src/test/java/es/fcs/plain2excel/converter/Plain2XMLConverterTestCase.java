package es.fcs.plain2excel.converter;

import java.io.FileWriter;

import junit.framework.TestCase;

public class Plain2XMLConverterTestCase extends TestCase {
	public void testConvertBalance() throws Exception {
		Plain2XMLConverter converter = new Plain2XMLConverter();
		FileWriter fw =new FileWriter("./src/test/resources/balance.xml");
		fw.write(converter.convert("./src/test/resources/balance"));
		fw.close();
//		System.out.println(converter.convert("./src/test/resources/balance"));
	}
	
	public void testConvertResultados() throws Exception {
		Plain2XMLConverter converter = new Plain2XMLConverter();
		FileWriter fw =new FileWriter("resultados.xml");
		fw.write(converter.convert("./src/test/resources/resultados"));
		fw.close();

//		System.out.println(converter.convert("./src/test/resources/resultados"));
	}

	public void testConvertMayor() throws Exception {
		Plain2XMLConverter converter = new Plain2XMLConverter();
		FileWriter fw =new FileWriter("mayor.xml");
		fw.write(converter.convert("./src/test/resources/mayor"));
		fw.close();
	}

	public void testConvertCostes() throws Exception {
		Plain2XMLConverter converter = new Plain2XMLConverter();
		FileWriter fw =new FileWriter("./src/test/resources/costes.xml");
		fw.write(converter.convert("./src/test/resources/costes"));
		fw.close();
	}
}
