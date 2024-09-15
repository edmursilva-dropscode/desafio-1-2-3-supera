package com.floressamambaia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FloresSamambaia {

    // Método que verifica se o círculo do caçador cobre o círculo da flor
    public static String tentativaDesenhar(int r1, int x1, int y1, int r2, int x2, int y2) {
        // Calcula a distância entre os centros dos dois círculos
        double distanciaCentros = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Verifica se o círculo do caçador cobre completamente o círculo da flor
        if (distanciaCentros + r2 <= r1) {
            return "RICO";
        } else {
            return "MORTO";
        }
    }

    // Método para capturar entrada válida (apenas números inteiros >= 0)
    public static int entradaValida(Scanner scanner, String mensagem) {
        int valor = -1;
        while (valor < 0) {
            System.out.print(mensagem);
            try {
                valor = scanner.nextInt();
                if (valor < 0) {
                    System.out.println("Entrada inválida. Por favor, digite um número maior ou igual a 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite apenas números.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        return valor;
    }

    public static void main(String[] args) {
        // Criando um scanner para capturar entradas do usuário
        Scanner scanner = new Scanner(System.in);
        String continuar = "S";

        // Loop para permitir várias execuções do programa
        while (continuar.equalsIgnoreCase("S")) {
            // Orientações para o usuário sobre as entradas necessárias
            System.out.println("Bem-vindo ao desafio da Flor de Samambaia!");

            // Capturando dados de entrada do usuário para o círculo do caçador
            int r1 = entradaValida(scanner, "Digite o valor do raio R1 (círculo do caçador): ");
            int x1 = entradaValida(scanner, "Digite o valor da coordenada X1 (círculo do caçador): ");
            int y1 = entradaValida(scanner, "Digite o valor da coordenada Y1 (círculo do caçador): ");

            // Capturando dados de entrada do usuário para o círculo da flor
            int r2 = entradaValida(scanner, "Digite o valor do raio R2 (círculo da flor): ");
            int x2 = entradaValida(scanner, "Digite o valor da coordenada X2 (círculo da flor): ");
            int y2 = entradaValida(scanner, "Digite o valor da coordenada Y2 (círculo da flor): ");

            // Chamando o método para verificar se o caçador está "RICO" ou "MORTO"
            String resultado = tentativaDesenhar(r1, x1, y1, r2, x2, y2);

            // Exibindo o resultado ao usuário
            System.out.println("Resultado: " + resultado);

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
}
