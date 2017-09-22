package Customer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Personnel on 17/03/2017.
 */
public class modifyCustomers {

    public Element getSingleCustomer(int id) {
        try {
            try {
                SAXBuilder builder = new SAXBuilder();
                File xmlFile = new File("carnet.xml");
                Document document = builder.build(xmlFile);
                Element rootElement = document.getRootElement();
                List loanList = rootElement.getChildren("Loan");
                return ((Element) loanList.get(id));
            } catch (JDOMException jex) {
                System.out.println(jex.getMessage());
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return (null);
    }

    public void modifyCustomer(int id, String fname, String lname, String itemType, String itemName, String itemDate, String returned) {
        try {
            try {
                SAXBuilder builder = new SAXBuilder();
                File xmlFile = new File("carnet.xml");
                Document document = builder.build(xmlFile);
                Element rootElement = document.getRootElement();
                List loanList = rootElement.getChildren("Loan");
                Element node =  ((Element) loanList.get(id));

                if (returned != null) {
                    System.out.println("SUPPRIME : returned -> " + returned);
                    rootElement.removeContent(node);
                } else {
                    System.out.println("MODIFIE : returned -> " + returned);
                    Element fchild = node.getChild("First-name");
                    fchild.setText(fname);
                    Element lchild = node.getChild("Last-name");
                    lchild.setText(lname);
                    Element itchild = node.getChild("Item-type");
                    itchild.setText(itemType);
                    Element inchild = node.getChild("Item-name");
                    inchild.setText(itemName);
                    Element dchild = node.getChild("Date");
                    dchild.setText(itemDate);
                }
                FileOutputStream ps = new FileOutputStream("carnet.xml");
                XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                sortie.output(document, ps);
                ps.close();
            } catch (JDOMException jex) {
                System.out.println(jex.getMessage());
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
}
