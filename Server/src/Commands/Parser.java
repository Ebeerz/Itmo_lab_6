package Commands;

import Org.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDateTime;
import java.util.TreeSet;

public class Parser {

    public static void fillCollection(String path) throws ParserException {
        TreeSet<Product> collection = new TreeSet<Product>();
        File file = new File(path);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;

        try {
            doc = dbf.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            System.out.println("Ошибка парсинга, коллекция не была заполнена" + e.getMessage());
            System.exit(0);
        }


        Node rootNode = doc.getFirstChild();
        NodeList rootChilds = rootNode.getChildNodes();

        for (int i = 0; i < rootChilds.getLength(); i++) {

            if (rootChilds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                collection.add(getProduct(rootChilds.item(i)));
            }
        }
        System.out.println("Коллекия заполнена из файла");
        ProductCollection.setCollection(collection);
    }


    public static Product getProduct(Node root) throws ParserException {
        Product product = new Product();
        Organization organization = new Organization();
        Address adress = new Address();
        Coordinates coord = new Coordinates();
        Element element = (Element) root;

        product.setId(Long.parseLong(element.getAttribute("id")));
        NodeList productTags = root.getChildNodes();
        for (int i = 0; i < productTags.getLength() - 1; i++) {
            if (productTags.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (productTags.item(i).getNodeName()) {
                case "name" -> {
                    if (productTags.item(i).getTextContent().equals("") || productTags.item(i).getTextContent().equals("null")) {
                        throw new ParserException("Имя не может быть пустым, встречено: ", productTags.item(i).getTextContent());
                    }
                    product.setName(productTags.item(i).getTextContent());
                }
                case "coordinateX" -> {
                    if (Integer.parseInt(productTags.item(i).getTextContent()) >= 287) {
                        throw new ParserException("Значение координаты x должно быть типа int и не превышать 287, встречено: ", productTags.item(i).getTextContent());
                    }
                    coord.setX(Integer.parseInt(productTags.item(i).getTextContent()));
                }
                case "coordinateY" -> {
                    if (Double.parseDouble(productTags.item(i).getTextContent()) >= 864 ) {
                        throw new ParserException("Значение координаты y должно быть типа Long и не превышать 864, встречено: ", productTags.item(i).getTextContent());
                    }
                    coord.setY(Double.parseDouble((productTags.item(i).getTextContent())));
                    product.setCoordinates(coord);
                }
                case "date" -> {
                    LocalDateTime dateTime = LocalDateTime.parse((productTags.item(i).getTextContent()));
                    product.setCreationDate(dateTime);
                }
                case "price" -> {
                    if (Long.parseLong(productTags.item(i).getTextContent()) < 0) {
                        throw new ParserException("Значение price должно быть типа long и быть больше 0, встречено: ", productTags.item(i).getTextContent());
                    }
                    product.setPrice(Long.parseLong((productTags.item(i).getTextContent())));
                }
                case "partNumber" -> {
                    if (productTags.item(i).getTextContent().equals("null")) {
                        throw new ParserException("partNumber не может быть null, встречено: ", productTags.item(i).getTextContent());
                    }
                    product.setPartNumber((productTags.item(i).getTextContent()));
                }
                case "manufactureCost" -> {
                    product.setManufactureCost(Double.parseDouble((productTags.item(i).getTextContent())));
                }
                case "unitOfMeasure" ->{
                    if (productTags.item(i).getTextContent().equals("null")) {
                        throw new ParserException("unitOfMeasure не может быть null, встречено: ", productTags.item(i).getTextContent());
                    }
                    product.setUnitOfMeasure(UnitOfMeasure.valueOf((productTags.item(i).getTextContent())));
                }
                case "organization" ->{
                    if (productTags.item(i).getTextContent().equals("")) {
                        throw new ParserException("manufacturer не может быть null, встречено: ", productTags.item(i).getTextContent());
                    }
                    NodeList root2 = (productTags.item(i).getChildNodes());
                    for (int j = 0; j < root2.getLength(); j ++){
                        if (root2.item(j).getNodeType() != Node.ELEMENT_NODE) {
                            continue;
                        }

                        switch (root2.item(j).getNodeName()) {
                            case "id" -> {
                                organization.setId(Integer.parseInt(root2.item(j).getTextContent()));
                            }
                            case "name" -> {
                                if (root2.item(j).getTextContent().equals("") || root2.item(j).getTextContent().equals("null")) {
                                    throw new ParserException("Organization name не может быть пустым, встречено: ", root2.item(j).getTextContent());
                                }
                                organization.setName(root2.item(j).getTextContent());
                            }
                            case "fullName" -> {
                                if (root2.item(j).getTextContent().equals("null")) {
                                    throw new ParserException("Organization fullName не может быть пустым, встречено: ", root2.item(j).getTextContent());
                                }
                                organization.setFullName(root2.item(j).getTextContent());
                            }
                            case "annualTurnover" -> {
                                if (Float.parseFloat(root2.item(j).getTextContent()) < 0) {
                                    throw new ParserException("annualTurnover должно быть типа float и быть больше 0, встречено: ", root2.item(j).getTextContent());
                                }
                                organization.setAnnualTurnover(Float.parseFloat(root2.item(j).getTextContent()));
                            }
                            case "type" -> {
                                if (root2.item(j).getTextContent().equals("null")) {
                                    throw new ParserException("Organization type не может быть null, встречено: ", root2.item(j).getTextContent());
                                }
                                organization.setType(OrganizationType.valueOf(root2.item(j).getTextContent()));
                            }
                            case "adress" -> {
                                if (root2.item(j).getTextContent().equals("null")) {
                                    throw new ParserException("Organization officialAdress не может быть null, встречено: ", root2.item(j).getTextContent());
                                }
                                adress.setStreet(root2.item(j).getTextContent());
                                organization.setOfficialAddress(adress);
                            }
                        }
                        product.setManufacturer(organization);
                    }

                }
            }

        }
        return product;
    }
}
