package main;

import java.util.Scanner;
import personagens.*;
import armas.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura e criação do primeiro personagem
        System.out.println("Digite as informações do primeiro personagem (tipo saude forca destreza arma):");
        Personagem p1 = criarPersonagem(scanner);

        // Leitura e criação do segundo personagem
        System.out.println("Digite as informações do segundo personagem (tipo saude forca destreza arma):");
        Personagem p2 = criarPersonagem(scanner);

        // Impressão do status inicial dos personagens
        System.out.println("\nStatus inicial dos personagens:");
        p1.printStatus();
        p2.printStatus();

        // Processar a sequência de ataques
        while (true) {
            System.out.println("Digite a sequência de ataques (atacante defensor) ou 0 para terminar:");
            int aIndex = scanner.nextInt();
            if (aIndex == 0)
                break;
            int bIndex = scanner.nextInt();

            Personagem a;
            Personagem b;

            if (aIndex == 1) {
                a = p1;
            } else {
                a = p2;
            }

            if (bIndex == 1) {
                b = p1;
            } else {
                b = p2;
            }

            // Atacante realiza o ataque
            a.atacar(b);

            // Imprimir o status dos personagens após o ataque
            System.out.println("\nStatus após o ataque:");

            // Se 'a' ataca 'b', aparece primeiro o status de 'a'
            if (aIndex == 1) {
                a = p1;
                p1.printStatus();
                // Se não, 'a' se defende de 'b'
            } else {
                a = p2;
                p2.printStatus();
            }
            
            // Se 'b' ataca 'a', aparece primeiro o status de 'b'
            if (bIndex == 1) {
                b = p1;
                p1.printStatus();
                // Se não, 'b' se defende de 'a'
            } else {
                b = p2;
                p2.printStatus();
            }
        }

        scanner.close();
    }

    private static Personagem criarPersonagem(Scanner scanner) {
        int tipo = scanner.nextInt();
        double saude = scanner.nextDouble();
        double forca = scanner.nextDouble();
        double destreza = scanner.nextDouble();
        int armaTipo = scanner.nextInt();

        switch (tipo) {
            case 1: // Mago
                ArmaMago armaMago;
                // Verificando o tipo de arma
                if (armaTipo == 1) {
                    armaMago = new Transmutacao();
                    return new Mago(saude, forca, destreza, armaMago);
                } else if (armaTipo == 2) {
                    armaMago = new Psikappa();
                    return new Mago(saude, forca, destreza, armaMago);
                } else {
                    throw new IllegalArgumentException("Tipo de arma inválida");
                }

            case 2: // Paladino
                ArmaPaladino armaPaladino;
                // Verificando o tipo de arma
                if (armaTipo == 1) {
                    armaPaladino = new Espada();
                    return new Paladino(saude, forca, destreza, armaPaladino);
                } else if (armaTipo == 2) {
                    armaPaladino = new Lanca();
                    return new Paladino(saude, forca, destreza, armaPaladino);
                } else {
                    throw new IllegalArgumentException("Tipo de arma inválida");
                }

            case 3: // Clerigo
                ArmaClerigo armaClerigo;
                // Verificando o tipo de arma
                if (armaTipo == 1) {
                    armaClerigo = new Martelo();
                    return new Clerigo(saude, forca, destreza, armaClerigo);
                } else if (armaTipo == 2) {
                    armaClerigo = new Maca();
                    return new Clerigo(saude, forca, destreza, armaClerigo);
                } else {
                    throw new IllegalArgumentException("Tipo de arma inválida");
                }
            default:
                throw new IllegalArgumentException("Tipo de personagem inválido");
        }
    }
}
