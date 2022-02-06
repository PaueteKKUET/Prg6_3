package com.pauete.Ejercicios.Tema6.Ejercicio3;

import javax.swing.*;

@SuppressWarnings("unused")
public class Coche {
    private String matricula;
    private String marca = "SEAT";
    private String modelo = "ALTEA";
    private String color = "#ffffff";
    private boolean techoSolar = false;
    private int kilometros = 0;
    private int numPuertas = 3;
    private int numPlazas = 5;

    //Ejercicio Final
    /**
     * El número actual de coches
     */
    public static int numcoches = 0;
    /**
     * El máximo de coches que se pueden fabricar
     */
    public static final int MAX_COCHES = 5;
    /**
     * Una colección de coches fabricados
     */
    public static Coche[] coches = new Coche[MAX_COCHES];

    public Coche() {
        coches[numcoches] = this;
        numcoches ++;
        this.matricula = matAleatiora();
    }

    public Coche(String matricula) {
        this();
        this.matricula = matricula;
    }

    public Coche(int numPuertas, int numPlazas) {
        this();
        this.setNumPlazas(numPlazas);
        this.setNumPuertas(numPuertas);
    }

    public Coche(String marca, String modelo, String color) {
        this();
        this.setColor(color);
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean tieneTechoSolar() {
        return techoSolar;
    }

    public void setTechoSolar(boolean techoSolar) {
        this.techoSolar = techoSolar;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = (kilometros >= 0) ? kilometros : this.kilometros;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = (numPuertas <= 5 && numPuertas > 0) ? numPuertas : this.numPuertas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = (numPlazas <= 7 && numPlazas > 0) ? numPlazas : this.numPlazas;
    }

    public void avanzar(int km) {
        boolean avanza = km > 0;
        if (avanza) { this.setKilometros(this.getKilometros() + km); }
    }

    public void tunear() {
        this.setKilometros(0);
        this.setTechoSolar(true);
    }

    public void tunear(String color) {
        this.tunear();
        this.setColor(color);
    }

    public void matricular(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Genera una matrícula pseudoaleatoria de 5 dígitos
     * @return una matrícula aleatoria.
     */
    private static String matAleatiora() {
        StringBuilder matricula = new StringBuilder();
        for (int i=0;i<5;i++) {
            matricula.append(String.valueOf( ((int) Math.floor(Math.random() * 10))));
        }
        return matricula.toString();
    }

    /**
     * Busca un coche entre todos los fabricados a partir de su matrícula
     * @param matricula la matrícula del coche
     * @return el coche
     * @throws Exception si no hay ningún coche con esa matrícula
     */
    public static Coche buscaCoche(String matricula) throws Exception {
        for (Coche coche : coches) {
            if (coche != null) {
                if (coche.getMatricula().equals(matricula)) {
                    return coche;
                }
            }
        }
        throw new Exception("Esa matrícula no pertenece a ningún coche");
    }

}
