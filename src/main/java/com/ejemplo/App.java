package com.ejemplo;

public class App {

    public static void main(String[] args) {
        System.out.println("INICIO");
        // Registrar el tiempo inicial
        long tiempoInicio = System.nanoTime();

        // Código cuyo tiempo de ejecución quieres medir
        Day1.partOneOne();
        Day1.partOneTwo();
        Day2.partTwoComplete();

        // Registrar el tiempo final
        long tiempoFin = System.nanoTime();

        // Calcular el tiempo transcurrido en nanosegundos
        long duracion = tiempoFin - tiempoInicio;

        // Convertir el tiempo a milisegundos (opcional)
        double duracionMilisegundos = duracion / 1_000_000.0;

        System.out.println("Tiempo de ejecución: " + duracionMilisegundos + " milisegundos");

    }

}
