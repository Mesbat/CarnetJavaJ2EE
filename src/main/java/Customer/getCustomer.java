package Customer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Personnel on 16/03/2017.
 */
public class getCustomer {

    public List getCustomer () {
        List<Element> nodeList = new ArrayList<Element>();
        try {
            try {
                SAXBuilder builder = new SAXBuilder();
                File xmlFile = new File("carnet.xml");
                Document document = builder.build(xmlFile);
                Element rootElement = document.getRootElement();
                List loanList = rootElement.getChildren("Loan");

                for (int i = 0; i < loanList.size(); ++i) {
                    Element loanChild = (Element) loanList.get(i);
                    nodeList.add(loanChild);
                }
            } catch (JDOMException jex) {
                System.out.println(jex.getMessage());
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }

        return (nodeList);
    }

}
