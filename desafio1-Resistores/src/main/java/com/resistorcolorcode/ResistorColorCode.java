package com.resistorcolorcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ResistorColorCode {

    // Mapeia números para suas respectivas cores
    private static final Map<String, String> colorCodes = new HashMap<>();
    // Mapeia multiplicadores ('', 'k', 'M') para seus valores exponenciais
    private static final Map<String, Integer> multipliers = new HashMap<>();

    static {
        // Inicializa o mapeamento de números para cores
        colorCodes.put("0", "preto");
        colorCodes.put("1", "marrom");
        colorCodes.put("2", "vermelho");
        colorCodes.put("3", "laranja");
        colorCodes.put("4", "amarelo");
        colorCodes.put("5", "verde");
        colorCodes.put("6", "azul");
        colorCodes.put("7", "violeta");
        colorCodes.put("8", "cinza");
        colorCodes.put("9", "branco");

        // Inicializa o mapeamento de multiplicadores
        multipliers.put("", 0);   // Nenhum multiplicador, valor base
        multipliers.put("k", 3);  // Multiplicador 'k', 10^3
        multipliers.put("M", 6);  // Multiplicador 'M', 10^6
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);      
        String continuar = "S";  // Inicializa a variável continuar

        // Orientações para o usuário sobre as entradas necessárias
        System.out.println("Bem-vindo ao desafio Resistores – Código de Cores!");
        
        // Loop para permitir várias execuções do programa
        while (continuar.equalsIgnoreCase("S")) {
            System.out.println("Digite o valor do resistor (ou pressione ENTER para sair):");
            String input = scanner.nextLine().trim();  // Remove espaços extras

            // Verifica se a entrada é vazia ou null e sai do programa
            if (input.isEmpty()) {
                break;
            }

            try {
                // Converte o valor de resistência para código de cores
                String result = convertToColorCode(input);
                System.out.println("Código de cores: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida: " + e.getMessage());
            }

            // Pergunta ao usuário se deseja continuar
            System.out.print("Deseja tentar novamente? (S/N): ");
            continuar = scanner.nextLine();

            // Valida a resposta do usuário (aceita apenas "S" ou "N")
            while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                System.out.print("Entrada inválida. Deseja tentar novamente? (S/N): ");
                continuar = scanner.nextLine();
            }

            // Limpar o console (funciona no Windows; ajuste conforme necessário para outros sistemas)
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }        
        
        System.out.println("Programa encerrado. Obrigado por participar!");
     // Fechando o scanner
        scanner.close();
    }

    private static String convertToColorCode(String input) {
        // Verifica se a entrada termina com " ohms"
        if (!input.toLowerCase().endsWith(" ohms")) {
            throw new IllegalArgumentException("A entrada deve terminar com ' ohms'");
        }

        // Remove " ohms" da entrada e obtém o valor e multiplicador
        String value = input.substring(0, input.length() - 5).trim();
        String multiplier = "";

        if (value.endsWith("k") || value.endsWith("M")) {
            multiplier = value.substring(value.length() - 1);
            value = value.substring(0, value.length() - 1);
        }

        double numericValue;
        try {
            numericValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor numérico inválido: " + value);
        }

        // Obtém o expoente do multiplicador
        int exponent = multipliers.getOrDefault(multiplier, 0);

        // Ajusta o valor numérico e o expoente para se ajustar ao formato de resistência
        while (numericValue >= 100) {
            numericValue /= 10;
            exponent++;
        }

        // Garante que o valueString tenha pelo menos 2 dígitos
        String valueString = String.format("%.0f", numericValue);
        if (valueString.length() == 1) {
            valueString = "0" + valueString;
        }

        // Define as cores para o primeiro e segundo dígito
        String firstColor = colorCodes.get(valueString.charAt(0) + "");
        String secondColor = colorCodes.get(valueString.charAt(1) + "");
        String thirdColor;
        String fourthColor = "dourado";  // A última cor é sempre dourado

        // Inverte a ordem das cores para valores com multiplicadores 'k' e 'M'
        if (multiplier.equals("k") || multiplier.equals("M")) {
            firstColor = colorCodes.get(valueString.charAt(1) + "");
            secondColor = colorCodes.get(valueString.charAt(0) + "");
        }

        // Define a terceira cor com base no multiplicador
        switch (multiplier) {
            case "k":
                thirdColor = "vermelho";  // Multiplicador 'k' é vermelho
                break;
            case "M":
                thirdColor = "verde";    // Multiplicador 'M' é verde
                break;
            default:
                thirdColor = colorCodes.get(String.valueOf(exponent)); // Para valores sem multiplicador
        }

        // Retorna o código de cores formatado
        return String.format("%s %s %s %s", firstColor, secondColor, thirdColor, fourthColor);
    }
}
