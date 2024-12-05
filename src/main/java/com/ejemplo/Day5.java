package com.ejemplo;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dxr and translated by Chatgpt
 */
public class Day5 {
    public static void main(String[] args) throws IOException {
        // Leer archivo
        BufferedReader reader = new BufferedReader(new FileReader("./Day5.txt"));

        String[] parts = reader.lines().collect(Collectors.joining("\n")).split("\n\n");
        reader.close();

        // Procesar data1
        List<int[]> data1 = Arrays.stream(parts[0].split("\n"))
                .map(line -> Arrays.stream(line.split("\\|"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .collect(Collectors.toList());

        // Procesar data2
        List<int[]> data2 = Arrays.stream(parts[1].split("\n"))
                .map(line -> Arrays.stream(line.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .collect(Collectors.toList());

        // Construir el "store" usando un mapa con conjuntos
        Map<Integer, Set<Integer>> store = new HashMap<>();
        for (int[] pair : data1) {
            store.computeIfAbsent(pair[0], k -> new HashSet<>()).add(pair[1]);
        }

        // Función crit (definida como un Comparator)
        Comparator<Integer> crit = (a, b) -> store.getOrDefault(a, Collections.emptySet()).contains(b) ? -1 : 1;

        // Calcular mid
        int mid = data2.stream()
                .filter(line -> isOk(line, store, crit).isValid)
                .mapToInt(line -> line[line.length / 2])
                .sum();

        // Calcular mid2
        int mid2 = data2.stream()
                .filter(line -> !isOk(line, store, crit).isValid)
                .mapToInt(line -> {
                    int[] sortedLine = isOk(line, store, crit).sortedLine;
                    return sortedLine[sortedLine.length / 2];
                })
                .sum();

        // Imprimir resultados
        System.out.println(mid + " " + mid2);
    }

    // Función is_ok para validar y ordenar una línea
    private static IsOkResult isOk(int[] line, Map<Integer, Set<Integer>> store, Comparator<Integer> crit) {
        // Convertir línea a lista para ordenar
        List<Integer> sortedList = Arrays.stream(line)
                .boxed()
                .sorted(crit)
                .collect(Collectors.toList());

        // Convertir la lista ordenada de vuelta a un arreglo
        int[] sortedLine = sortedList.stream().mapToInt(i -> i).toArray();

        // Verificar si la línea original y la ordenada son iguales
        boolean isValid = Arrays.equals(line, sortedLine);
        return new IsOkResult(isValid, sortedLine);
    }

    // Clase auxiliar para almacenar los resultados de is_ok
    private static class IsOkResult {
        boolean isValid;
        int[] sortedLine;

        IsOkResult(boolean isValid, int[] sortedLine) {
            this.isValid = isValid;
            this.sortedLine = sortedLine;
        }
    }
}
