package xmlCreation;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {

	private String fileName;

	public CreateXML() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CreateXML(String fileName) {
		this.fileName = fileName;
	}
	
	public void RunXML() throws ParserConfigurationException {
		System.out.println(fileName);
		
		DocumentBuilderFactory docBFac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBFac.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element root = doc.createElement("company"); //erstellt Wurzelelement
		root.setAttribute("type", "IT-Software"); //First in - Last Out
		root.setAttribute("Location", "Washington D.C.");
		
		Element Staff = doc.createElement("staff");
		
		Element lastname = doc.createElement("lastname");
		lastname.appendChild(doc.createTextNode("Smith"));
		Staff.appendChild(lastname);
		
		Element firstname = doc.createElement("firstname");
		firstname.appendChild(doc.createTextNode("Robin"));
		Staff.appendChild(firstname);
		
		Element salary = doc.createElement("salary");
		salary.appendChild(doc.createTextNode("68.000"));
		Staff.appendChild(salary);
		
		root.appendChild(Staff);
		
		Element carpool = doc.createElement("carpool");
		
		Element car1 = doc.createElement("car1");
		car1.appendChild(doc.createTextNode("Audi"));
		carpool.appendChild(car1);
		
		root.appendChild(carpool);
		
		doc.appendChild(root);
		
		DomBuilder db = new DomBuilder();
		db.printDomTree(doc);

	}
	
}
