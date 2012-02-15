package es.fcs.plain2excel.converter;
import java.io.FileReader;

import es.fcs.plain2excel.converter.XML2ExcelConverter;
import junit.framework.TestCase;


public class XML2ExcelConverterTestCase extends TestCase{
	public void testBalanceToExcel() throws Throwable {
		XML2ExcelConverter conv = new XML2ExcelConverter();
		conv.convert(new FileReader("./src/test/resources/balance_gnu.xml"),"balance.xls");

		assertTrue(true);
	}

	public void testResultadosToExcel() throws Throwable {
		XML2ExcelConverter conv = new XML2ExcelConverter();
		conv.convert(new FileReader("./src/test/resources/resultados_gnu.xml"),"resultados.xls");
	
		assertTrue(true);
	}

	public void testMayorToExcel() throws Throwable {
		XML2ExcelConverter conv = new XML2ExcelConverter();
		conv.convert(new FileReader("./src/test/resources/mayor_gnu.xml"),"mayor.xls");
	
		assertTrue(true);
	}

	public void testCostesToExcel() throws Throwable {
		XML2ExcelConverter conv = new XML2ExcelConverter();
		conv.convert(new FileReader("./src/test/resources/costes_gnu.xml"),"costes.xls");
	
		assertTrue(true);
	}
	

}
