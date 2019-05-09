package xmlCreation;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomBuilder {

	public void printDomTree(Node doc) {
		int type = doc.getNodeType();
		switch (type) {
		case Node.DOCUMENT_NODE: {
			System.out.print("<?xml version=\"1.0\" ?>");
			printDomTree(((Document) doc).getDocumentElement());
			break;
		}
		case Node.ELEMENT_NODE: {
			System.out.println();
			System.out.print("<");
			System.out.print(doc.getNodeName());

			if (doc.hasAttributes()) {
				NamedNodeMap nameOfAtt = doc.getAttributes();
				for (int i = 0; i < nameOfAtt.getLength(); i++) {
					printDomTree(nameOfAtt.item(i));
				}
			}
			System.out.print(">");

			if (doc.hasChildNodes()) {
				NodeList children = doc.getChildNodes();
				for (int i = 0; i < children.getLength(); i++) {
					printDomTree(children.item(i));
				}
			}
			break;
		}
		
		case Node.ATTRIBUTE_NODE: {
			 System.out.print(" " + doc.getNodeName() + "=\"");
	          if (doc.hasChildNodes())
	          {
	            NodeList children = doc.getChildNodes();
	            for (int i = 0; i < children.getLength(); i++)
	              printDomTree(children.item(i));
	          }
	          System.out.print("\"");
	          break;
		}
		
		case Node.TEXT_NODE: {
			System.out.print(doc.getNodeValue());
			break;
		}

		}

		if (type == Node.ELEMENT_NODE)
	    {
	      System.out.print("</");
	      System.out.print(doc.getNodeName());
	      System.out.print('>');
	      System.out.println();
	    }
	}
}