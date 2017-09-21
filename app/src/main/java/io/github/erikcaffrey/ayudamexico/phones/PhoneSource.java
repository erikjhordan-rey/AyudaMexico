package io.github.erikcaffrey.ayudamexico.phones;


import java.util.ArrayList;

public class PhoneSource {

    public static ArrayList<Phone> getCdmxPhones() {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Ciudad de México", "Protección Civil 1", "(55)5683-2222"));
        phones.add(new Phone("Ciudad de México", "Protección Civil 2", "(55)5277-4177"));
        phones.add(new Phone("Ciudad de México", "Emergencias", "911"));
        phones.add(new Phone("Ciudad de México", "Sistema de Aguas", "(55)5654-3210"));
        phones.add(new Phone("Ciudad de México", "Fugas", "(55)5654-3210"));
        phones.add(new Phone("Ciudad de México", "Locatel", "(55)5658-1111"));
        phones.add(new Phone("Ciudad de México", "Bomberos 1", "(55)5768-3800"));
        phones.add(new Phone("Ciudad de México", "Bomberos 2", "(55)5768-2532"));
        phones.add(new Phone("Ciudad de México", "Cruz Roja 1", "065"));
        phones.add(new Phone("Ciudad de México", "Cruz Roja 2", "(55)5557-5757"));
        phones.add(new Phone("Ciudad de México", "Reporte de fallas CFE", "071"));
        phones.add(new Phone("Ciudad de México", "IMMS", "01-800-623-2323"));

        return phones;
    }

    public static ArrayList<Phone> getEdoPhones() {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Edo. de México", "Emergencias", "066"));
        phones.add(new Phone("Edo. de México", "Cruz Roja", "065"));
        phones.add(new Phone("Edo. de México", "Atención del Gobierno", "01-800-696-9696"));
        return phones;
    }

    public static ArrayList<Phone> getMorelosPhones() {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Morelos", "Informes Emergencia en Tultepec", "01-800-696-9696"));
        phones.add(new Phone("Morelos", "Emergencias", "066"));
        phones.add(new Phone("Morelos", "Seguridad Pública del Estado", "(77)7101-1000"));
        phones.add(new Phone("Morelos", "Protección Civil 1", "(77)7100-0515"));
        phones.add(new Phone("Morelos", "Protección Civil 2", "(77)7100-0517"));
        phones.add(new Phone("Morelos", "Cruz Roja 1", "(77)7315-3505"));
        phones.add(new Phone("Morelos", "Cruz Roja 2", "(77)7315-3555"));
        return phones;
    }

    public static ArrayList<Phone> getPueblaPhones() {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Puebla", "Cruz Roja", "(22)213-7700"));
        phones.add(new Phone("Puebla", "Locatel", "(22)211-7800"));
        phones.add(new Phone("Puebla", "Bomberos", "(22)245-8001"));
        return phones;
    }
}
