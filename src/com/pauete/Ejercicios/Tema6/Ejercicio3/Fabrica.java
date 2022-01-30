package com.pauete.Ejercicios.Tema6.Ejercicio3;

import javax.swing.*;

public class Fabrica {
    public static void main(String[] args) {
        //Coche 1
        Coche car1 = new Coche();
        car1.setMatricula("1234-DF");
        car1.setModelo("Toledo");
        car1.setColor("azul");
        car1.avanzar(200);

        //Coche 2
        Coche car2 = new Coche("5678-AG");
        car2.setMarca("Fiat");
        car2.setModelo("Uno");
        car2.tunear("rojo");
        car2.setTechoSolar(true);
        car2.avanzar(300);
        car2.setNumPlazas(2);

        //Coche 3
        Coche car3 = new Coche("BMW", "850", "gris");
        car3.setMatricula("9012-HH");
        car3.avanzar(400);
        car3.setNumPuertas(5);

        //Coche 4
        Coche car4 = new Coche(5, 7);
        car4.setMatricula("3456-XS");
        car4.setMarca("VW");
        car4.setModelo("Caddy");
        car4.tunear();
        car4.avanzar(500);

        Coche[] coches = new Coche[] {
                car1, car2, car3, car4
        };

        for (Coche coche : coches) {
            JOptionPane.showMessageDialog(null, caracteristicas(coche));
        }

    }

    public static String caracteristicas(Coche coche) {
        return new StringBuilder()
                .append("Matrícula: ").append(coche.getMatricula()).append("\n")
                .append("Marca: ").append(coche.getMarca()).append("\n")
                .append("Modelo: ").append(coche.getModelo()).append("\n")
                .append("Color: ").append(coche.getColor()).append("\n")
                .append("Techo solar: ").append(coche.tieneTechoSolar() ? "Sí" : "No").append("\n")
                .append("Kilometros: ").append(coche.getKilometros()).append("\n")
                .append("Puertas: ").append(coche.getNumPuertas()).append("\n")
                .append("Plazas: ").append(coche.getNumPlazas())
                .toString();

    }
}