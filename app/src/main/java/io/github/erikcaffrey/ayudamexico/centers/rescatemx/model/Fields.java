
package io.github.erikcaffrey.ayudamexico.centers.rescatemx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Fields implements Serializable
{

    @SerializedName("entidad")
    @Expose
    private String entidad;
    @SerializedName("nombre_del_centro_de_acopio")
    @Expose
    private String nombreDelCentroDeAcopio;
    @SerializedName("zona")
    @Expose
    private String zona;
    @SerializedName("estatus")
    @Expose
    private long estatus;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("nombre_contacto")
    @Expose
    private String nombreContacto;
    @SerializedName("colonia")
    @Expose
    private String colonia;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("id2")
    @Expose
    private String id2;
    @SerializedName("delegacion_o_municipio")
    @Expose
    private String delegacionOMunicipio;
    @SerializedName("calle")
    @Expose
    private String calle;
    @SerializedName("fecha_de_creacion")
    @Expose
    private String fechaDeCreacion;
    @SerializedName("ciudad")
    @Expose
    private String ciudad;
    @SerializedName("verificado_por")
    @Expose
    private String verificadoPor;
    @SerializedName("direccion_agregada")
    @Expose
    private String direccionAgregada;
    @SerializedName("tipo_de_centro_de_acopio")
    @Expose
    private String tipoDeCentroDeAcopio;
    @SerializedName("ultima_actualizacion")
    @Expose
    private String ultimaActualizacion;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("numero_exterior")
    @Expose
    private String numeroExterior;
    @SerializedName("link_google_maps")
    @Expose
    private String linkGoogleMaps;
    @SerializedName("coordenadas")
    @Expose
    private List<Double> coordenadas = null;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("actualizado_por")
    @Expose
    private String actualizadoPor;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("necesidades")
    @Expose
    private String necesidades;
    @SerializedName("horarios")
    @Expose
    private String horarios;
    private final static long serialVersionUID = 8112165948689012649L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fields() {
    }

    /**
     * 
     * @param nombreContacto
     * @param nombreDelCentroDeAcopio
     * @param fechaDeCreacion
     * @param linkGoogleMaps
     * @param ultimaActualizacion
     * @param colonia
     * @param horarios
     * @param id
     * @param twitter
     * @param numeroExterior
     * @param coordenadas
     * @param lat
     * @param ciudad
     * @param tipoDeCentroDeAcopio
     * @param lon
     * @param id2
     * @param telefono
     * @param necesidades
     * @param verificadoPor
     * @param actualizadoPor
     * @param tipo
     * @param entidad
     * @param zona
     * @param direccionAgregada
     * @param estatus
     * @param calle
     * @param delegacionOMunicipio
     */
    public Fields(String entidad, String nombreDelCentroDeAcopio, String zona, long estatus, String tipo, String nombreContacto, String colonia, String twitter, String id2, String delegacionOMunicipio, String calle, String fechaDeCreacion, String ciudad, String verificadoPor, String direccionAgregada, String tipoDeCentroDeAcopio, String ultimaActualizacion, long id, String numeroExterior, String linkGoogleMaps, List<Double> coordenadas, double lon, String telefono, String actualizadoPor, double lat, String necesidades, String horarios) {
        super();
        this.entidad = entidad;
        this.nombreDelCentroDeAcopio = nombreDelCentroDeAcopio;
        this.zona = zona;
        this.estatus = estatus;
        this.tipo = tipo;
        this.nombreContacto = nombreContacto;
        this.colonia = colonia;
        this.twitter = twitter;
        this.id2 = id2;
        this.delegacionOMunicipio = delegacionOMunicipio;
        this.calle = calle;
        this.fechaDeCreacion = fechaDeCreacion;
        this.ciudad = ciudad;
        this.verificadoPor = verificadoPor;
        this.direccionAgregada = direccionAgregada;
        this.tipoDeCentroDeAcopio = tipoDeCentroDeAcopio;
        this.ultimaActualizacion = ultimaActualizacion;
        this.id = id;
        this.numeroExterior = numeroExterior;
        this.linkGoogleMaps = linkGoogleMaps;
        this.coordenadas = coordenadas;
        this.lon = lon;
        this.telefono = telefono;
        this.actualizadoPor = actualizadoPor;
        this.lat = lat;
        this.necesidades = necesidades;
        this.horarios = horarios;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getNombreDelCentroDeAcopio() {
        return nombreDelCentroDeAcopio;
    }

    public void setNombreDelCentroDeAcopio(String nombreDelCentroDeAcopio) {
        this.nombreDelCentroDeAcopio = nombreDelCentroDeAcopio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public long getEstatus() {
        return estatus;
    }

    public void setEstatus(long estatus) {
        this.estatus = estatus;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getDelegacionOMunicipio() {
        return delegacionOMunicipio;
    }

    public void setDelegacionOMunicipio(String delegacionOMunicipio) {
        this.delegacionOMunicipio = delegacionOMunicipio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getVerificadoPor() {
        return verificadoPor;
    }

    public void setVerificadoPor(String verificadoPor) {
        this.verificadoPor = verificadoPor;
    }

    public String getDireccionAgregada() {
        return direccionAgregada;
    }

    public void setDireccionAgregada(String direccionAgregada) {
        this.direccionAgregada = direccionAgregada;
    }

    public String getTipoDeCentroDeAcopio() {
        return tipoDeCentroDeAcopio;
    }

    public void setTipoDeCentroDeAcopio(String tipoDeCentroDeAcopio) {
        this.tipoDeCentroDeAcopio = tipoDeCentroDeAcopio;
    }

    public String getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(String ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getLinkGoogleMaps() {
        return linkGoogleMaps;
    }

    public void setLinkGoogleMaps(String linkGoogleMaps) {
        this.linkGoogleMaps = linkGoogleMaps;
    }

    public List<Double> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<Double> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getNecesidades() {
        return necesidades;
    }

    public void setNecesidades(String necesidades) {
        this.necesidades = necesidades;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

}
