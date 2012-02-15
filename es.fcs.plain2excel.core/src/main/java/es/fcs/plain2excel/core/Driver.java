// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Driver.java

package es.fcs.plain2excel.core;


import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;



import org.apache.cocoon.pipeline.Pipeline;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.config.ConfigParser;
import org.apache.commons.chain.impl.CatalogFactoryBase;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;

import es.fcs.plain2excel.converter.Plain2XMLConverter;
import es.fcs.plain2excel.converter.XML2ExcelConverter;
import es.fcs.plain2excel.identifier.FileIdentifier;
import es.fcs.plain2excel.transformer.XSLTransformer;

// Referenced classes of package prueba.excel:
//            CreateWork, GenericParser, MayorWork, BalanceWork, 
//            TxtParser, ResultadosWork, CostesWork

public class Driver extends Observable {

	private final static String PREFIX = "/";
	private String text_file;
	private Plain2XMLConverter plainConverter = null; 
	private XSLTransformer transformer = null;
	private XML2ExcelConverter excelConverter = null;
	private String xml_excel;
	Pipeline pl = null;
	private Logger log = Logger.getLogger(Driver.class);
	private Catalog catalog;
	
    public void initialize() throws Exception {
    	log.debug("Initializing...");
    	plainConverter = new Plain2XMLConverter();
    	log.debug("Initializing Plain2XMLConverter");
    	transformer = new XSLTransformer();
    	log.debug("Initializing XSLTransformer");
    	excelConverter = new XML2ExcelConverter();
    	log.debug("Initializing XML2ExcelConverter");
    	setChanged();
    	notifyObservers("20");
    	log.debug("Initialized!");
    }

    public void create() throws Exception {
//    	log.info("parsing");
//    	pl = new NonCachingPipeline();
//    	pl.addComponent(new StringGenerator("<?xml version='1.0' encoding='iso-8859-1' ?>" + plainConverter.convert(text_file)));
//    	pl.addComponent(new XSLTTransformer(this.getClass().getResource("/main.xsl")));
//    	pl.addComponent(new XMLSerializer());
//    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        pl.setup(bos);
//        pl.execute();
//        log.info("fin");
//        xml_excel = bos.toString();
    	parseConfigFile();
       	log.debug("parsing file");
    	String xml = plainConverter.convert(text_file);
    	FileIdentifier fi = new FileIdentifier();
    	String type = fi.identify(xml);
    	Command cmd = catalog.getCommand(type);
    	Context ctx = new ContextBase();
    	ctx.put("xml", xml);
    	ctx.put("template", PREFIX + type + ".stx");
    	ctx.put("removePagingTemplate", PREFIX + "removePaging.stx");
//    	ctx.put("template", "/main.stx");
    	cmd.execute(ctx);
//    	log.debug(xml);
//    	log.debug("apliying xsl");
//    	xml_excel = (transformer.transform(new StringReader(xml),"/main.stx")).toString();
//    	log.debug("finish");
    	xml_excel = (String)ctx.get("xml_excel");
    	if (log.isDebugEnabled()){
    		log.debug(xml_excel.substring(0, 100));
    	}
     }

    public void createEclipse() throws Exception {
//    	log.info("parsing");
//    	pl = new NonCachingPipeline();
//    	pl.addComponent(new StringGenerator("<?xml version='1.0' encoding='iso-8859-1' ?>" + plainConverter.convert(text_file)));
//    	pl.addComponent(new XSLTTransformer(this.getClass().getResource("/main.xsl")));
//    	pl.addComponent(new XMLSerializer());
//    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        pl.setup(bos);
//        pl.execute();
//        log.info("fin");
//        xml_excel = bos.toString();
    	parseConfigFile();
    	setChanged();
    	notifyObservers("20");
       	log.debug("parsing file");
    	String xml = plainConverter.convert(text_file);
    	setChanged();
    	notifyObservers("20");
    	FileIdentifier fi = new FileIdentifier();
    	String type = fi.identify(xml);
    	setChanged();
    	notifyObservers("20");
    	Command cmd = catalog.getCommand(type);
    	Context ctx = new ContextBase();
    	ctx.put("xml", xml);
    	ctx.put("url", FileLocator.resolve(Driver.class.getResource(PREFIX + type + ".stx")));
    	ctx.put("removePagingUrl", FileLocator.resolve(Driver.class.getResource(PREFIX + "removePaging.stx")));
//    	ctx.put("template", "/main.stx");
    	cmd.execute(ctx);
//    	log.debug(xml);
//    	log.debug("apliying xsl");
//    	xml_excel = (transformer.transform(new StringReader(xml),"/main.stx")).toString();
//    	log.debug("finish");
    	xml_excel = (String)ctx.get("xml_excel");
    	if (log.isDebugEnabled()){
    		log.debug(xml_excel.substring(0, 100));
    	}
    	setChanged();
    	notifyObservers("40");
     }
    
    public void parseTextFile(String file)
        throws IOException {
    	text_file = file;
    }

    public void parseTextFile(String file, Observer obs)
        throws IOException {
        addObserver(obs);
        parseTextFile(file);
    }

    public void saveExcelFile(String file) throws Throwable {
        log.info("saving excel file " + file);
        excelConverter.convert(new StringReader(xml_excel),file);
    }

    public String getXMLExcel(){
    	return xml_excel;
    }
    

	private void parseConfigFile() throws Exception { // Parse the
		// configuration
		// file
		ConfigParser parser = new ConfigParser();
		String fileLocation = "chain-config.xml";
		URL url = Driver.class.getClassLoader().getResource(fileLocation);
		parser.parse(url);
		catalog = CatalogFactoryBase.getInstance().getCatalog("perico");
	}
}
