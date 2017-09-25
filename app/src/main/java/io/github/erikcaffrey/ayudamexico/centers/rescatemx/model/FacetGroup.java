
package io.github.erikcaffrey.ayudamexico.centers.rescatemx.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FacetGroup implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("facets")
    @Expose
    private List<Facet> facets = null;
    private final static long serialVersionUID = -6898506775488473912L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FacetGroup() {
    }

    /**
     * 
     * @param facets
     * @param name
     */
    public FacetGroup(String name, List<Facet> facets) {
        super();
        this.name = name;
        this.facets = facets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Facet> getFacets() {
        return facets;
    }

    public void setFacets(List<Facet> facets) {
        this.facets = facets;
    }

}
