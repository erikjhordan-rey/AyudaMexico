package io.github.erikcaffrey.ayudamexico.support.model;

import com.google.gson.annotations.SerializedName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by silmood on 9/24/17.
 */

public class SupportSpot {

    public static final String REGEX_PHONE = "[0-9].[0-9]{3}.[0-9]{3}.[0-9]{3}";

    @SerializedName("categoria")
    private String category;

    @SerializedName("nombre")
    private String name;

    @SerializedName("ofrece")
    private String offering;

    @SerializedName("datos_de_contacto")
    private String contact;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffering() {
        return offering;
    }

    public void setOffering(String offering) {
        this.offering = offering;
    }

    public String getContact() {
        if (isPhoneNumber()) {
            String formatted = formatNumber();
            return contact.replaceAll(REGEX_PHONE, formatted);
        }

        return contact;
    }

    private String formatNumber() {
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(contact);

        if (matcher.find()) {
            String result = matcher.group(0);
            String formatted = result.replace(".", "");

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < formatted.length(); i += 2) {
                builder.append(formatted.substring(i, i + 2));
                if ((i + 2) < formatted.length())
                    builder.append("-");
            }

            return builder.toString();
        } else {
            return contact;
        }
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isPhoneNumber() {
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(contact);

        return matcher.find();
    }
}
