package com.ejemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    // --- Day 3: Mull It Over ---

    static Pattern pattern;
    static Matcher matcher;

    public static void main(String[] args) {

        Scanner scan = null;
        try {
            scan = new Scanner(new File("Day3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String archivoLeido = "";
        while (scan.hasNextLine()) {
            archivoLeido += scan.nextLine();
        }
        detectarXmuls(archivoLeido);
    }

    public static void detectarXmuls(String cadena) {
        // Definir el patrón regex
        String patron = "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)";

        // Compilar el patrón y crear el matcher
        pattern = Pattern.compile(patron);
        matcher = pattern.matcher(cadena);

        int resultado = 0;
        // Buscar y mostrar todas las coincidencias
        boolean operacion = true;
        System.out.println("Secuencias encontradas:");
        while (matcher.find()) {

            switch (matcher.group()) {
                case "do()":
                    operacion = true;
                    break;
                case "don't()":
                    operacion = false;
                    break;
                default:
                    int X = Integer.parseInt(matcher.group(1)); // Primer número (n)
                    int Y = Integer.parseInt(matcher.group(2)); // Segundo número (m)
                    if (operacion)
                        resultado += multiplica(X, Y);
                    break;
            }
        }

        System.out.println("RESULTADO --> " + resultado);

    }

    public static int multiplica(int x, int y) {
        return x * y;
    }
}
