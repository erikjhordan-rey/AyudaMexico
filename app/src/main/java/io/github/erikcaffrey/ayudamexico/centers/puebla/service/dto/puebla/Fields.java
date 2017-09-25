
package io.github.erikcaffrey.ayudamexico.centers.puebla.service.dto.puebla;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("informacion_sobre_centros_de_acopio_en_puebla")
    @Expose
    private String informacionSobreCentrosDeAcopioEnPuebla;
    @SerializedName("column_7")
    @Expose
    private String column7;
    @SerializedName("column_6")
    @Expose
    private String column6;
    @SerializedName("column_5")
    @Expose
    private String column5;
    @SerializedName("column_3")
    @Expose
    private String column3;
    @SerializedName("column_2")
    @Expose
    private List<Double> column2 = null;

    public String getInformacionSobreCentrosDeAcopioEnPuebla() {
        return informacionSobreCentrosDeAcopioEnPuebla;
    }

    public void setInformacionSobreCentrosDeAcopioEnPuebla(String informacionSobreCentrosDeAcopioEnPuebla) {
        this.informacionSobreCentrosDeAcopioEnPuebla = informacionSobreCentrosDeAcopioEnPuebla;
    }

    public String getColumn7() {
        return column7;
    }

    public void setColumn7(String column7) {
        this.column7 = column7;
    }

    public String getColumn6() {
        return column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6;
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public List<Double> getColumn2() {
        return column2;
    }

    public void setColumn2(List<Double> column2) {
        this.column2 = column2;
    }

}
