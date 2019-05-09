package xmlCreation;

import javax.xml.parsers.ParserConfigurationException;

public class Controler {

	public static void main(String args[]) throws ParserConfigurationException {
		
		CreateXML cXML = new CreateXML("XML-Document Company");
		cXML.RunXML();
	}
}
