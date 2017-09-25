
package io.github.erikcaffrey.ayudamexico.centers.puebla.service.dto.puebla;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollectorCenterDto {

    @SerializedName("nhits")
    @Expose
    private Integer nhits;
    @SerializedName("parameters")
    @Expose
    private Parameters parameters;
    @SerializedName("records")
    @Expose
    private List<Record> records = null;

    public Integer getNhits() {
        return nhits;
    }

    public void setNhits(Integer nhits) {
        this.nhits = nhits;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

}
