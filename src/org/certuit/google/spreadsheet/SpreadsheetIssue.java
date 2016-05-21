package org.certuit.google.spreadsheet;


import java.util.Date;

/**
 * Created by andre on 5/20/16.
 */
public class SpreadsheetIssue {

    private int id;
    private Date fecha;
    private String registrado;
    private String casoUso;
    private String seccion;
    private String descripcion;
    private String tipo;
    private String prioridad;
    private String impacto;
    private String estatus;


//    Integer.parseInt(     row.get(0).toString()),   row.get(0).toStrin row.get(0).toS  row.get(0).toS  row.get(0).toString()


    public SpreadsheetIssue(int id, Date fecha, String registrado, String casoUso, String seccion, String descripcion, String tipo, String prioridad, String impacto, String estatus) {
        this.id = id;
        this.fecha = fecha;
        this.registrado = registrado;
        this.casoUso = casoUso;
        this.seccion = seccion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.impacto = impacto;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    public String getCasoUso() {
        return casoUso;
    }

    public void setCasoUso(String casoUso) {
        this.casoUso = casoUso;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
