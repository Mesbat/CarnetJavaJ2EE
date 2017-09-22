package Customer; /**
 * Created by Personnel on 15/03/2017.
 */

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.lang.*;

public class addCustomer {

    private String xmlPath = "carnet.xml";
    private SAXBuilder builder = new SAXBuilder(); // Constructeur de document
    private File xmlFile = new File("carnet.xml"); // Récupération d'un document depuis un fichier

    public void addCustomer(String fname, String lname, String itemType, String itemName, String itemDate, String returned) {
        try {
            File f = new File("carnet.xml");
            if (!f.exists()) {
                Element carnet = new Element("carnet");
                Document doc = new Document(carnet);
                XMLOutputter xmlOutput = new XMLOutputter();
                xmlOutput.setFormat(Format.getPrettyFormat());
                xmlOutput.output(doc, new FileWriter(this.xmlPath));
            }
            try {
                Document document = builder.build(xmlFile); // Création du document
                Element ppl = new Element("Loan");
                ppl.addContent(new Element("First-name").setText(fname));
                ppl.addContent(new Element("Last-name").setText(lname));
                ppl.addContent(new Element("Item-name").setText(itemName));
                ppl.addContent(new Element("Item-type").setText(itemType));
                ppl.addContent(new Element("Date").setText(itemDate));
                document.getRootElement().addContent(ppl);
                FileOutputStream ps = new FileOutputStream("carnet.xml");
                XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                sortie.output(document, ps);
                ps.close();
            } catch (JDOMException jex) {
                System.out.println(jex.getMessage());
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

}
