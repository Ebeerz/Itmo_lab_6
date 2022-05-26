package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.Message;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

public class Save implements Command{
    @Override
    public String execute(Object o) throws ParserConfigurationException, IOException, TransformerException {

        ProductCollection productCollection = new ProductCollection();
        TreeSet<Product> collection = ProductCollection.getCollection();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        File trueFile = new File(ProductCollection.getFileName());
        trueFile.delete();
        trueFile.createNewFile();

        Element root = document.createElement("Products");
        for (Product product: collection){
            Element docProduct = document.createElement("Product");
            docProduct.setAttribute("id", product.getId().toString());

            Element docName = document.createElement("name");
            docName.setTextContent(product.getName());
            docProduct.appendChild(docName);

            Element docCoordinateX = document.createElement("coordinateX");
            docCoordinateX.setTextContent(Integer.toString(product.getCoordinates().getX()));
            docProduct.appendChild(docCoordinateX);

            Element docCoordinateY = document.createElement("coordinateY");
            docCoordinateY.setTextContent(Double.toString(product.getCoordinates().getY()));
            docProduct.appendChild(docCoordinateY);

            Element docTime = document.createElement("date");
            LocalDateTime time = product.getCreationDate();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            String formattedDateTime = time.format(formatter);
            docTime.setTextContent(formattedDateTime);
            docProduct.appendChild(docTime);

            Element docPrice = document.createElement("price");
            docPrice.setTextContent(Long.toString(product.getPrice()));
            docProduct.appendChild(docPrice);

            Element docPartNumber = document.createElement("partNumber");
            docPartNumber.setTextContent(product.getPartNumber());
            docProduct.appendChild(docPartNumber);

            Element docManufactureCost = document.createElement("manufactureCost");
            docManufactureCost.setTextContent(Double.toString(product.getManufactureCost()));
            docProduct.appendChild(docManufactureCost);

            Element docUnitOfMeasure = document.createElement("unitOfMeasure");
            docUnitOfMeasure.setTextContent(product.getUnitOfMeasure().toString());
            docProduct.appendChild(docUnitOfMeasure);

            Element docOrganization = document.createElement("organization");

            Element docOrganizationId = document.createElement("id");
            docOrganizationId.setTextContent(Integer.toString(product.getManufacturer().getId()));
            docOrganization.appendChild(docOrganizationId);

            Element docOrganizationName = document.createElement("name");
            docOrganizationName.setTextContent(product.getManufacturer().getName());
            docOrganization.appendChild(docOrganizationName);

            Element docOrganizationFullName = document.createElement("fullName");
            docOrganizationFullName.setTextContent(product.getManufacturer().getFullName());
            docOrganization.appendChild(docOrganizationFullName);

            Element docOrganizationAnnualTurnover = document.createElement("annualTurnover");
            docOrganizationAnnualTurnover.setTextContent(Float.toString(product.getManufacturer().getAnnualTurnover()));
            docOrganization.appendChild(docOrganizationAnnualTurnover);

            Element docOrganizationType = document.createElement("type");
            docOrganizationType.setTextContent(product.getManufacturer().getType().toString());
            docOrganization.appendChild(docOrganizationType);

            Element docOrganizationAdress = document.createElement("adress");
            docOrganizationAdress.setTextContent(product.getManufacturer().getOfficialAddress().getStreet());
            docOrganization.appendChild(docOrganizationAdress);

            docProduct.appendChild(docOrganization);
            root.appendChild(docProduct);
        }
        document.appendChild(root);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // для красивого вывода в консоль
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);

        //печатаем в консоль или файл
        StreamResult file = new StreamResult(trueFile);

        //записываем данные
        transformer.transform(source, file);

        //System.out.println("Создание XML файла закончено");
        //System.out.println("Записано в файл");
        Message.setMessage("Записано в файл");

        return null;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "Сохранить коллекцию в файл";
    }
}
