package es.fcs.plain2excel.identifier;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class FileIdentifier {
	private static final String TEXT_BALANCE = "BALANCE DE SITUACIÓN";
	private static final String TEXT_COSTES = "EXTRACTO";
	private static final String TEXT_MAYOR = "L I B R O   M A Y O R";
	private static final String TEXT_RESULTADOS = "CUENTA DE PÉRDIDAS Y GANANCIAS";
	
	public static String BALANCE = "balance";
	public static String COSTES = "costes";
	public static String MAYOR = "mayor";
	public static String RESULTADOS = "resultados";
	
	public String identify(String xml) throws XPathExpressionException{
		String xpathExpr = "//line[position()=2]/text()";
		XPath xp = XPathFactory.newInstance().newXPath();
		InputSource is = new InputSource(new StringReader(xml));
		return processResponse(xp.evaluate(xpathExpr, is));
	}

	private String processResponse(String evaluate) {
		if (evaluate.startsWith(TEXT_BALANCE)){
			return BALANCE;
		} else if (evaluate.startsWith(TEXT_COSTES)){
			return COSTES;
		} else if (evaluate.startsWith(TEXT_MAYOR)){
			return MAYOR;
		}else if (evaluate.startsWith(TEXT_RESULTADOS)){
			return RESULTADOS;
		} 
		
		throw new RuntimeException();
	}
}
