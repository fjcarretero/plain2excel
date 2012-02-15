package es.fcs.plain2excel.transformer;

import java.io.FileReader;
import java.io.FileWriter;

import junit.framework.TestCase;

public class XSLTransformerTestCase extends TestCase{
	
	public void testTransformBalance() throws Exception {
		XSLTransformer trans = new XSLTransformer();
		FileWriter fw =new FileWriter("./src/test/resources/balance_gnu.xml");
		fw.write((trans.transform(new FileReader("./src/test/resources/balance.xml"),"/main.stx")).toString());
		fw.close();
		//System.out.println((trans.transform(new FileReader("./src/test/resources/balance.xml"),"/main.xsl")).toString());
		
		assertTrue(true);
	}

	public void testTransformResultados() throws Exception {
		XSLTransformer trans = new XSLTransformer();
		FileWriter fw =new FileWriter("./src/test/resources/resultados_gnu.xml");
		fw.write((trans.transform(new FileReader("./src/test/resources/resultados.xml"),"/main.stx")).toString());
		fw.close();
		//System.out.println((trans.transform(new FileReader("./src/test/resources/resultados.xml"),"/main.xsl")).toString());
		
		assertTrue(true);
	}

	public void testTransformMayor() throws Exception {
		XSLTransformer trans = new XSLTransformer();
		FileWriter fw =new FileWriter("./src/test/resources/mayor_gnu.xml");
		fw.write((trans.transform(new FileReader("./src/test/resources/mayor.xml"),"/mayor.stx")).toString());
		fw.close();
		//System.out.println((trans.transform(new FileReader("./src/test/resources/mayor.xml"),"/main.xsl")).toString());
		
		assertTrue(true);
	}

	public void testTransformCostes() throws Exception {
		XSLTransformer trans = new XSLTransformer();
		FileWriter fw =new FileWriter("./src/test/resources/costes_gnu.xml");
		fw.write((trans.transform(new FileReader("./src/test/resources/costes.xml"),"/main.stx")).toString());
		fw.close();
		//System.out.println((trans.transform(new FileReader("./src/test/resources/mayor.xml"),"/main.xsl")).toString());
		
		assertTrue(true);
	}
	
	public void testRemovePaging() throws Exception {
		XSLTransformer trans = new XSLTransformer();
		FileWriter fw =new FileWriter("./src/test/resources/no_paging.xml");
		fw.write((trans.transform(new FileReader("./src/test/resources/paging.xml"),"/removePaging.stx")).toString());
		fw.close();
		//System.out.println((trans.transform(new FileReader("./src/test/resources/mayor.xml"),"/main.xsl")).toString());
		
		assertTrue(true);
	}

	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		System.setProperty("javax.xml.transform.TransformerFactory","net.sf.joost.trax.TransformerFactoryImpl");
	}
}
