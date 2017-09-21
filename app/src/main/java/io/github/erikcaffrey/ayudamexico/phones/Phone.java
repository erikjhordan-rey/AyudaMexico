package io.github.erikcaffrey.ayudamexico.phones;


public class Phone {
    private String city;
    private String name;
    private String number;

    public Phone(String city, String name, String number) {
        this.city = city;
        this.name = name;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
