package ar.edu.proyectosort.zapando;

/**
 * Created by adm on 21/12/2017.
 */

public class Entidad {
    private int imgFoto;
    private String titulo;
    private String contenido;

    public Entidad(int imgFoto, String titulo, String contenido){
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getImgFoto() {return imgFoto;}

    public String getTitulo() {return titulo;}

    public String getContenido() {return contenido;}

}
