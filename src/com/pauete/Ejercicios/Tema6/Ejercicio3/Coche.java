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

    public Coche() {

    }

    public Coche(String matricula) {
        this.matricula = matricula;
    }

    public Coche(int numPuertas, int numPlazas) {
        this.setNumPlazas(numPlazas);
        this.setNumPuertas(numPuertas);
    }

    public Coche(String marca, String modelo, String color) {
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
        JOptionPane.showMessageDialog(null, "Has avanzado " + (avanza ? km : 0) + "km");
    }

    public void tunear() {
        this.setKilometros(0);
        this.setTechoSolar(true);
        JOptionPane.showMessageDialog(null, "Ahora tienes un coche nuevecito");
    }

    public void tunear(String color) {
        this.tunear();
        this.setColor(color);
    }

    public void matricular(String matricula) {
        this.matricula = matricula;
        JOptionPane.showMessageDialog(null, "Has matriculado el coche como " + this.getMatricula());
    }

}
