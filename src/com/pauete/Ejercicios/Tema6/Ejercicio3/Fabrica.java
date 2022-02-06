package com.pauete.Ejercicios.Tema6.Ejercicio3;

import javax.swing.*;

public class Fabrica {
    public static void main(String[] args) {

        int option = 0;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("""
                        Fábrica de Coches de PaueteKKUET. Selecciona una de las siguientes opciones:
                        1 - Fabricar coche (conociendo matrícula)
                        2 - Fabricar coche (a partir del nº de puertas y el nº de plazas)
                        3 - Fabricar coche (a partir de la marca, el modelo y el color)
                        4 - Fabricar coche (sin datos)
                        5 - Tunear coche (pintándolo de un color)
                        6 - Tunear cohce (sin pintarlo)
                        7 - Avanzar kilómetros
                        8 - Mostrar características de un coche
                        9 - Salir del programa
                        """));
                if (option < 1 || option > 9) {
                    throw  new Exception();
                }

                switch (option) {
                    case 1 -> {
                        if (!sitioDisponible()) {
                            noHaySitioParaOtroCochePorqueElGarajeEsDemasiadoChiquitoPorLoQueNoHaremosOtroCocheQueNosQuiteSitioVital();
                            throw new Exception();
                        }
                        String matricula = JOptionPane.showInputDialog("Indroduce la matrícula");
                        Coche coche = new Coche(matricula);
                        JOptionPane.showMessageDialog(null, caracteristicas(coche));
                    }
                    case 2 -> {
                        if (!sitioDisponible()) {
                            noHaySitioParaOtroCochePorqueElGarajeEsDemasiadoChiquitoPorLoQueNoHaremosOtroCocheQueNosQuiteSitioVital();
                            throw new Exception();
                        }
                        int puertas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de puertas"));
                        int plazas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de plazas"));
                        Coche coche = new Coche(puertas, plazas);
                        JOptionPane.showMessageDialog(null, caracteristicas(coche));
                    }
                    case 3 -> {
                        if (!sitioDisponible()) {
                            noHaySitioParaOtroCochePorqueElGarajeEsDemasiadoChiquitoPorLoQueNoHaremosOtroCocheQueNosQuiteSitioVital();
                            throw new Exception();
                        }
                        String marca = JOptionPane.showInputDialog("Indroduce la marca");
                        String modelo = JOptionPane.showInputDialog("Indroduce el modelo");
                        String color = JOptionPane.showInputDialog("Indroduce el color");
                        Coche coche = new Coche(marca, modelo, color);
                        JOptionPane.showMessageDialog(null, caracteristicas(coche));
                    }
                    case 4 -> {
                        if (!sitioDisponible()) {
                            noHaySitioParaOtroCochePorqueElGarajeEsDemasiadoChiquitoPorLoQueNoHaremosOtroCocheQueNosQuiteSitioVital();
                            throw new Exception();
                        }
                        Coche coche = new Coche();
                        JOptionPane.showMessageDialog(null, caracteristicas(coche));
                    }
                    case 5 -> {
                        try {
                            Coche coche = Coche.buscaCoche(JOptionPane.showInputDialog("Introduce la matrícula del coche"));
                            String color = JOptionPane.showInputDialog("Elige un color");
                            coche.tunear(color);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    case 6 -> {
                        try {
                            Coche coche = Coche.buscaCoche(JOptionPane.showInputDialog("Introduce la matrícula del coche"));
                            coche.tunear();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    case 7 -> {
                        try {
                            Coche coche = Coche.buscaCoche(JOptionPane.showInputDialog("Introduce la matrícula del coche"));
                            coche.avanzar(Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos km?")));
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    case 8 -> {
                        try {
                            Coche coche = Coche.buscaCoche(JOptionPane.showInputDialog("Introduce la matrícula del coche"));
                            JOptionPane.showMessageDialog(null, caracteristicas(coche));
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    case 9 -> {
                        JOptionPane.showMessageDialog(null, "Ten un buen día, tarde, noche, o lo que proceda");
                    }
                }
            } catch (Exception e) {}
        } while (option != 9);
    }

    /**
     * Comprueba si hay sitio disponible en el garaje
     * @return
     */
    public static boolean sitioDisponible() {
        return Coche.numcoches < Coche.MAX_COCHES;
    }

    /**
     * Informa al usuario de que no hay sitio para más coches porque tiene un garaje pequeñito
     */
    public static void noHaySitioParaOtroCochePorqueElGarajeEsDemasiadoChiquitoPorLoQueNoHaremosOtroCocheQueNosQuiteSitioVital() {
        JOptionPane.showMessageDialog(null, """
                No hay sitio para más coches.
                Puedes comprar una ampliación
                por solo 9'95.
                """);
    }

    /**
     * Muestra las caracterçisticas de un coche
     * @param coche el coche
     * @return las características
     */
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