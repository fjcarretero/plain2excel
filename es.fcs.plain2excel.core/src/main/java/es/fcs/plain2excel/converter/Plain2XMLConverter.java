package es.fcs.plain2excel.converter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class Plain2XMLConverter {
	private StringBuffer xmlBuf = null;
	private BufferedReader br = null;
	private String previous_line = "";
	private Logger log = Logger.getLogger(Plain2XMLConverter.class);
	
	public String convert(String file) throws Exception {
			this.xmlBuf = new StringBuffer();
			this.xmlBuf.append("<document>\r\n");
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"Cp1252"));
			String line;
			while ((line = br.readLine()) != null) {
				//line = new String(buffer, 0, num_bytes, "Cp437");
				if (line.contains("|") || line.contains("--")) {
					parseRow(line);
				} else {
					parseLine(line);
				}
				previous_line = line;
			}
			if (previous_line.endsWith("--")){
				this.xmlBuf.append("\t</table>\r\n");
			}
			this.xmlBuf.append("</document>\r\n");
			if (log.isDebugEnabled())
				log.debug(this.xmlBuf.toString());
			return this.xmlBuf.toString();
			//return new String(xmlBuf.toString().getBytes(),0, xmlBuf.length(), "Cp437");
	}

	private void parseRow(String line) {
		if (log.isDebugEnabled())
			log.debug("row=" + line);
		if (!line.endsWith("--")){
			String[] parts = line.split("[|]");
			this.xmlBuf.append("\t\t<row>");
			for (int i = 1; i < parts.length; i++) {
				this.xmlBuf.append("<cell length='");
				this.xmlBuf.append(parts[i].length());
				this.xmlBuf.append("'");
				if (parts[i].trim().equals("")){
					this.xmlBuf.append("/>");
				} else {
					this.xmlBuf.append(">");
					//this.xmlBuf.append(StringEscapeUtils.escapeXml(parts[i].trim()));
					this.xmlBuf.append("<![CDATA[");
					this.xmlBuf.append(parts[i].trim());
					this.xmlBuf.append("]]>");
					this.xmlBuf.append("</cell>");
				}
			}
			this.xmlBuf.append("</row>\r\n");
		} else {
			if (previous_line.trim().equals("")){
				this.xmlBuf.append("\t<table>\r\n");
			}
		}
		
	}

	private void parseLine(String line) {
		if (log.isDebugEnabled())
			log.debug("line=" + line);
		if (previous_line.endsWith("--")){
			this.xmlBuf.append("\t</table>\r\n");
		}
		if (!line.trim().equals("")) {
			this.xmlBuf.append("\t<line length='");
			this.xmlBuf.append(line.length());
			this.xmlBuf.append("'>");
			//this.xmlBuf.append(StringEscapeUtils.escapeXml(line.trim()));
			this.xmlBuf.append("<![CDATA[");
			this.xmlBuf.append(line.trim());
			this.xmlBuf.append("]]>");
			this.xmlBuf.append("</line>\r\n");
		} 
	}
}
