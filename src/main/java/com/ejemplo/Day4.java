package com.ejemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

    // --- Day 4: Ceres Search ---

    static Scanner scan;
    static ArrayList<String> matriz = new ArrayList<>();
    static int contador = 0;

    public static void main(String[] args) {
        readFile();
        xmasSamx();
        // masSam();
    }

    public static void readFile() {
        try {
            scan = new Scanner(new File("./Day4.txt"));
            while (scan.hasNext()) {
                matriz.add(scan.next());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // JUEGO 1
    public static void xmasSamx() {

        for (int x = 0; x < matriz.size(); x++) {
            horizontalAdelante(matriz.get(x));
            horizontalAtras(matriz.get(x));
            for (int y = 0; y < matriz.get(x).toCharArray().length; y++) {
                if (matriz.get(x).toCharArray()[y] == 'X') {
                    verticalUp(x, y);
                    verticalDown(x, y);
                    diagonalIzquierdaUp(x, y);
                    diagonalDerechaUp(x, y);
                    diagonalIzquierdaDown(x, y);
                    diagonalDerechaDown(x, y);
                }

            }
        }
        System.out.println("RESULTADO --> " + contador);
    }

    public static int posX(int posX) {
        if (posX < 0)
            posX = 0;

        if (posX >= matriz.size())
            posX = matriz.size() - 1;

        return posX;
    }

    public static int posY(int posY) {

        if (posY < 0)
            posY = 0;

        if (posY >= matriz.get(0).toCharArray().length)
            posY = matriz.get(0).toCharArray().length - 1;
        return posY;
    }

    public static void horizontalAdelante(String fila) {
        String regex = "XMAS";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        matcher = pattern.matcher(fila);

        while (matcher.find()) {
            System.out.println(matcher.group());
            contador++;
        }
    }

    public static void horizontalAtras(String fila) {
        String regex = "SAMX";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        matcher = pattern.matcher(fila);

        while (matcher.find()) {
            System.out.println(matcher.group());
            contador++;
        }
    }

    public static void verticalUp(int x, int y) {
        try {

            if (matriz.get(x + 1).toCharArray()[y] == 'M') {
                if (matriz.get(x + 2).toCharArray()[y] == 'A') {
                    if (matriz.get(x + 3).toCharArray()[y] == 'S') {
                        contador++;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void verticalDown(int x, int y) {
        try {

            if (matriz.get(x - 1).toCharArray()[y] == 'M') {
                if (matriz.get(x - 2).toCharArray()[y] == 'A') {
                    if (matriz.get(x - 3).toCharArray()[y] == 'S') {
                        contador++;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void diagonalDerechaDown(int x, int y) {
        try {

            if (matriz.get(x + 1).toCharArray()[y + 1] == 'M') {
                if (matriz.get(x + 2).toCharArray()[y + 2] == 'A') {
                    if (matriz.get(x + 3).toCharArray()[y + 3] == 'S') {
                        contador++;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void diagonalIzquierdaDown(int x, int y) {
        try {

            if (matriz.get(x + 1).toCharArray()[y - 1] == 'M') {
                if (matriz.get(x + 2).toCharArray()[y - 2] == 'A') {
                    if (matriz.get(x + 3).toCharArray()[y - 3] == 'S') {
                        contador++;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void diagonalDerechaUp(int x, int y) {
        try {

            if (matriz.get(x - 1).toCharArray()[y + 1] == 'M') {
                if (matriz.get(x - 2).toCharArray()[y + 2] == 'A') {
                    if (matriz.get(x - 3).toCharArray()[y + 3] == 'S') {
                        contador++;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void diagonalIzquierdaUp(int x, int y) {
        try {

            if (matriz.get(x - 1).toCharArray()[y - 1] == 'M') {
                if (matriz.get(x - 2).toCharArray()[y - 2] == 'A') {
                    if (matriz.get(x - 3).toCharArray()[y - 3] == 'S') {
                        contador++;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    // JUEGO 2
    public static void masSam() {
        // searchMS(0, 0);
        for (int x = 0; x < matriz.size(); x++) {
            for (int y = 0; y < matriz.get(x).toCharArray().length; y++) {
                System.out.println(x + "-" + y);
                if (matriz.get(x).toCharArray()[y] == 'A') {
                    searchMS(x, y);
                }

            }
        }
        System.out.println("RESULTADO --> " + contador);
    }

    public static void searchMS(int x, int y) {
        try {
            int masCount = 0;
            for (int xx : Arrays.asList(-1, 1)) {
                for (int yy : Arrays.asList(-1, 1)) {
                    if (matriz.get((x + xx)).toCharArray()[y + yy] == 'M') {
                        if (matriz.get(x - xx).toCharArray()[y - yy] == 'S') {
                            masCount++;
                        }
                    }
                }
            }
            if (masCount == 2) {
                contador++;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
