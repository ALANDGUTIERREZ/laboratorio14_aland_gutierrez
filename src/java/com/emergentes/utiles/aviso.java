package com.emergentes.utiles;
public class aviso {
    private int id;
    private  String titulo;
    private  String contenido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    @Override
    public String toString(){
        return "aviso ("+"id=" + id+ ", titulo=" +titulo+", contenido"+contenido+")";
    }
}
