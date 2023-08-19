import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("order.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("order");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String customerName = element.getElementsByTagName("customerName").item(0).getTextContent();
                    String medicines = element.getElementsByTagName("medicines").item(0).getTextContent();
                    System.out.println("Customer Name: " + customerName);
                    System.out.println("Medicines: " + medicines);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
