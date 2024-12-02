package com.ejemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

    // --- Day 2: Red-Nosed Reports ---

    public static void partTwoComplete() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("Day2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] filaRead;
        int safeResults = 0;
        while (scan.hasNextLine()) {
            filaRead = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            safeResults += (filaRead[0] > filaRead[1]) ? descendentCheck(filaRead) : ascendentCheck(filaRead);
        }

        System.out.println("RESULTADO FINAL --> " + safeResults);
    }

    public static int descendentCheck(int[] line) {
        int contador = 0;
        for (int i = 0; i < line.length - 1; i++) {
            // esto comentado es de la parte 1 del 2.
            // if (line[i] < line[i + 1] | line[i] == line[i + 1] | (line[i] - line[i + 1])>
            // 3)
            // return 0;

            // INICIO - parte 2 del 2
            if (line[i] < line[i + 1] | line[i] == line[i + 1] | (line[i] - line[i + 1]) > 3)
                contador++;

            // FINAL - parte 2 del 2
            if (contador > 1)
                return 0;
        }

        return 1;
    }

    public static int ascendentCheck(int[] line) {
        int contador = 0;
        for (int i = 0; i < line.length - 1; i++) {
            // esto comentado es de la parte 1 del 2.
            // if (line[i] > line[i + 1] | line[i] == line[i + 1] | (line[i + 1] - line[i])>
            // 3)
            // return 0;
            // INICIO - parte 2 del 2
            if (line[i] > line[i + 1] | line[i] == line[i + 1] | (line[i + 1] - line[i]) > 3)
                contador++;
            // FINAL - parte 2 del 2
            if (contador > 1)
                return 0;
        }

        return 1;
    }
}
