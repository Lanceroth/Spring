package com.prueba.softcaribbean.dto;

public class Vendedor {
    private int nmvendedor;
    private String documento;
    private String dsnombres;
    private String dsapellido;
    private String dsdireccion;

    public int getNmvendedor() {
        return nmvendedor;
    }

    public void setNmvendedor(int nmvendedor) {
        this.nmvendedor = nmvendedor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDsnombres() {
        return dsnombres;
    }

    public void setDsnombres(String dsnombres) {
        this.dsnombres = dsnombres;
    }

    public String getDsapellido() {
        return dsapellido;
    }

    public void setDsapellido(String dsapellido) {
        this.dsapellido = dsapellido;
    }

    public String getDsdireccion() {
        return dsdireccion;
    }

    public void setDsdireccion(String dsdireccion) {
        this.dsdireccion = dsdireccion;
    }
}
