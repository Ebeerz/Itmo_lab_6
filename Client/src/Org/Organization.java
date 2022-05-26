package Org;

import java.io.Serializable;

public class Organization implements Comparable, Serializable {
    private Integer id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String fullName; //Поле не может быть null
    private float annualTurnover; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(float annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }


    @Override
    public String toString() {
        return "Organization{" +
                "id Организации = " + id +
                ", Имя Организации = '" + name + '\'' +
                ", Полное имя = '" + fullName + '\'' +
                ", Годовая выручка = " + annualTurnover +
                ", Тип = " + type +
                ", Оф. Адрес " + officialAddress +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Organization organization = (Organization) o;
        return (int)this.id.compareTo(organization.getId());
    }
}
