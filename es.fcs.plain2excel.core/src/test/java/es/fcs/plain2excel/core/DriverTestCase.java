// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Driver.java

package es.fcs.plain2excel.core;

import junit.framework.TestCase;


// Referenced classes of package prueba.excel:
//            CreateWork, GenericParser, MayorWork, BalanceWork, 
//            TxtParser, ResultadosWork, CostesWork

public class DriverTestCase extends TestCase {
	public void testCreate() throws Exception {
		Driver driver = new Driver();
		driver.initialize();
		driver.parseTextFile("E:/$felipe/$DATOS_PRUEBA/plain/MAYOR C.C.A. 311210");
		driver.create();
		System.out.println(driver.getXMLExcel());
	}
	
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		System.setProperty("javax.xml.transform.TransformerFactory","net.sf.joost.trax.TransformerFactoryImpl");
	}
}
