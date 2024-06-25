package org.example.literalura.utils;

public enum Idioma {
    ES("es"),
    EN("en"),
    FR("fr"),
    PT("pt");
    ;
    private String abbreviacion;

    Idioma(String abbreviacion) {
        this.abbreviacion = abbreviacion;
    }

    public static Idioma fromString(String text){
        for (Idioma lenguaje : Idioma.values()){
            if(lenguaje.abbreviacion.equalsIgnoreCase(text)){
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("Ningun lenguaje encontrado: " + text);
    }

    public String getIdioma(){
        return this.abbreviacion;
    }
}
