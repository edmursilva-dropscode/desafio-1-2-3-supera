package com.snailmatriz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnailMatriz {

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "S";

        // Loop para permitir várias execuções do programa
        while (continuar.equalsIgnoreCase("S")) {
            // Orientações para o usuário sobre as entradas necessárias
            System.out.println("Bem-vindo ao desafio da Matriz em Espiral!");

            // Solicitar ao usuário o tamanho da matriz (número de linhas e colunas)
            System.out.println("Digite o tamanho da matriz (n x n): ");
            int n = entradaValida(scanner, "Tamanho da matriz: ");

            // Criar a matriz com base no tamanho informado
            int[][] matriz = new int[n][n];

            // Solicitar ao usuário os valores para cada posição da matriz
            System.out.println("Digite os valores da matriz, linha por linha: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("Elemento [%d][%d]: ", i + 1, j + 1);
                    matriz[i][j] = entradaValida(scanner, "");
                }
            }

            // Exibir a matriz para o usuário
            System.out.println("\nMatriz fornecida:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matriz[i][j] + "\t");
                }
                System.out.println();
            }

            // Exibir a matriz percorrida em espiral
            System.out.println("\nOrdem espiral dos elementos:");
            System.out.println(percorrerMatrizEspiral(matriz));

            // Perguntar ao usuário se ele deseja continuar
            System.out.print("Deseja tentar novamente? (S/N): ");
            continuar = scanner.next();

            // Valida a resposta do usuário (aceita apenas "S" ou "N")
            while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                System.out.print("Entrada inválida. Deseja tentar novamente? (S/N): ");
                continuar = scanner.next();
            }
        }

        System.out.println("Programa encerrado. Obrigado por participar!");
        // Fechando o scanner
        scanner.close();
    }

    // Método para obter entrada válida do usuário
    private static int entradaValida(Scanner scanner, String mensagem) {
        int valor = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpa o buffer
            }
        }
        return valor;
    }

    // Método para percorrer a matriz em espiral
    public static List<Integer> percorrerMatrizEspiral(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();

        if (matriz == null || matriz.length == 0) {
            return resultado;  // Retorna lista vazia se a matriz estiver vazia
        }

        int topo = 0, base = matriz.length - 1;
        int esquerda = 0, direita = matriz[0].length - 1;

        // Enquanto houver elementos para percorrer
        while (topo <= base && esquerda <= direita) {
            // Percorrer da esquerda para a direita
            for (int i = esquerda; i <= direita; i++) {
                resultado.add(matriz[topo][i]);
            }
            topo++;  // Move o topo para baixo

            // Percorrer de cima para baixo na coluna da direita
            for (int i = topo; i <= base; i++) {
                resultado.add(matriz[i][direita]);
            }
            direita--;  // Move a coluna da direita para a esquerda

            if (topo <= base) {
                // Percorrer da direita para a esquerda
                for (int i = direita; i >= esquerda; i--) {
                    resultado.add(matriz[base][i]);
                }
                base--;  // Move a base para cima
            }

            if (esquerda <= direita) {
                // Percorrer de baixo para cima na coluna da esquerda
                for (int i = base; i >= topo; i--) {
                    resultado.add(matriz[i][esquerda]);
                }
                esquerda++;  // Move a coluna da esquerda para a direita
            }
        }

        return resultado;  // Retorna a lista de elementos na ordem espiral
    }
    
}
