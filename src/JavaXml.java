import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class JavaXml {
    public static void main(String[] args) {
        String xmlDosyasi = "kişiler.xml";
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlDosyasi);

            Element element = document.getDocumentElement();
            System.out.println(element.getNodeName());

            NodeList nodeList = element.getElementsByTagName("kişi");
            System.out.println("kişi Sayısı : " + nodeList.getLength());

            for (int i = 0; i <nodeList.getLength() ; i++) {
                Node kisi = nodeList.item(i);
                Element kisiElement = (Element) kisi;
                String kisiSira = kisiElement.getElementsByTagName("sira").item(0).getTextContent();
                String kisiAdi = kisiElement.getElementsByTagName("adi").item(0).getTextContent();
                String kisiSoyadı = kisiElement.getElementsByTagName("soyadı").item(0).getTextContent();
                System.out.println(kisiSira +" " +kisiAdi + " " + kisiSoyadı);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
