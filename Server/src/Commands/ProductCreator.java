package Commands;

import Org.*;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductCreator {
    private final Scanner scanner = new Scanner(System.in);


    public Product create(String id) {
        ProductCollection collection = new ProductCollection();
        Product product = new Product();
        Organization organization = new Organization();
        Address address = new Address();
        try {
            if (id.equals("free")) {
                product.setId((long) ProductCollection.getFreeId());
            } else {
                product.setId(Long.parseLong((String) id));
            }
        } catch (Exception e){
            System.out.println("Неверный формат команды, аргумент должен быть = 'free' или быть типа long");
        }

        organization.setId((int) ProductCollection.getFreeId());

        this.setName(product);
        Coordinates coordinates = new Coordinates();
        this.setCoordinateX(coordinates);
        this.setCoordinateY(coordinates);
        product.setCoordinates(coordinates);
        product.setCreationDate(LocalDateTime.now());
        this.setPrice(product);
        this.setPartNumber(product);
        this.setManufactureCost(product);
        this.setUnitOfMeasure(product);
        this.setOrganizationName(organization);
        this.setAnnualTurnover(organization);
        this.setOrganizationType(organization);
        this.setAdress(address);
        organization.setOfficialAddress(address);
        product.setManufacturer(organization);
        return product;
    }


    public void setName(Product product) {
        System.out.println("Введите название продукта: (String)");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals("null")) {
            System.out.println("Имя не может быть пустым");
            this.setName(product);
        } else {
            product.setName(name);
        }
    }

    public void setCoordinateX(Coordinates coords) {
        try {
            System.out.println("Введите координату x: (int)");
            String x = scanner.nextLine();
            if (x.equals("") || x.equals(null)) this.setCoordinateX(coords);
            else {
                int xn = Integer.parseInt(x);
                if (xn <= 287) {
                    coords.setX(xn);
                } else {
                    System.out.println("Максимальное значение x: 287");
                    this.setCoordinateX(coords);
                }
                coords.setX(xn);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Значение должно быть типа:\"int\".");
            this.setCoordinateX(coords);
        }
    }

    public void setCoordinateY(Coordinates coords) {
        try {
            System.out.println("Введите координату y: (Double)");
            String y = scanner.nextLine();
            if (y.equals("") || y.equals(null)) {
                System.out.println("y не может быть null");
                this.setCoordinateY(coords);
            } else {
                Double yn = Double.parseDouble(y);
                if (yn <= 864) {
                    coords.setY(yn);
                } else {
                    System.out.println("Максимальное значение y: 864");
                    this.setCoordinateX(coords);
                }
                coords.setY(yn);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Значение должно быть типа:\"Double\".");
            this.setCoordinateX(coords);
        }
    }

    public void setPrice(Product product) {
        System.out.println("Введите стоимость продукта: (long)");
        long price = Long.parseLong(scanner.nextLine());
        if (price < 0) {
            System.out.println("Цена не может быть меньше 0");
            this.setName(product);
        } else {
            product.setPrice(price);
        }
    }

    public void setPartNumber(Product product) {
        System.out.println("Введите номер партии (String)");
        String partNumber = scanner.nextLine();
        product.setPartNumber(partNumber);
    }

    public void setManufactureCost(Product product) {
        try {
            System.out.println("Введите стоимость производства: (Double)");
            Double manufactureCost = Double.parseDouble(scanner.nextLine());
            product.setManufactureCost(manufactureCost);
        } catch (InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Значение должно быть типа:\"Double\".");
            this.setManufactureCost(product);
        }
    }

    public void setUnitOfMeasure(Product product) {
        System.out.println("Введите меру измерения: (METERS, \n" +
                "    CENTIMETERS,\n" +
                "    PCS,\n" +
                "    LITERS,\n" +
                "    MILLIGRAMS;)");
        String unit = scanner.nextLine().toUpperCase();
        try {
            product.setUnitOfMeasure(UnitOfMeasure.valueOf(unit));
        } catch (Exception e) {
            System.out.println("Значение должно соответствовать перечислинным типам. Введите значение:");
            this.setUnitOfMeasure(product);
        }
    }

    public void setOrganizationName(Organization organization) {
        System.out.println("Введите название организации: (String)");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals("null")) {
            System.out.println("Имя не может быть пустым");
            this.setOrganizationName(organization);
        } else {
            organization.setName(name);
        }
    }

    public void setOrganizationFullName(Organization organization) {
        System.out.println("Введите полное название организации: (String)");
        String name = scanner.nextLine();
        if (name.equals("null")) {
            System.out.println("Имя не может быть пустым");
            this.setOrganizationFullName(organization);
        } else {
            organization.setFullName(name);
        }
    }

    public void setAnnualTurnover(Organization organization) {
        try {
            System.out.println("Введите годовой оборот: (Float)");
            Float annualTurnover = Float.parseFloat(scanner.nextLine());
            organization.setAnnualTurnover(annualTurnover);
        } catch (InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Значение должно быть типа:\"float\".");
            this.setAnnualTurnover(organization);
        }
    }

    public void setOrganizationType(Organization organization) {
        System.out.println("Введите тип организации: COMMERCIAL,\n" +
                "    PUBLIC,\n" +
                "    GOVERNMENT,\n" +
                "    TRUST,\n" +
                "    PRIVATE_LIMITED_COMPANY;");
        String type = scanner.nextLine().toUpperCase();
        try {
            organization.setType(OrganizationType.valueOf(type));
        } catch (Exception e) {
            System.out.println("Значение должно соответствовать перечислинным типам. Введите значение:");
            this.setOrganizationType(organization);;
        }
    }

    public void setAdress(Address adress){
        System.out.println("Введите годовой оборот: (String)");
        String street = scanner.nextLine();
        adress.setStreet(street);
    }



}