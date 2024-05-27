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
            int atacanteIndex = scanner.nextInt();
            if (atacanteIndex == 0)
                break;
            int defensorIndex = scanner.nextInt();

            Personagem atacante;
            Personagem defensor;

            if (atacanteIndex == 1) {
                atacante = p1;
            } else {
                atacante = p2;
            }

            if (defensorIndex == 1) {
                defensor = p1;
            } else {
                defensor = p2;
            }

            // Atacante realiza o ataque
            atacante.atacar(defensor);

            // Imprimir o status dos personagens após o ataque
            System.out.println("\nStatus após o ataque:");
            p1.printStatus();
            p2.printStatus();
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
                if (armaTipo == 1) {
                    armaMago = new Transmutacao();
                } else {
                    armaMago = new Psikappa();
                }
                return new Mago(saude, forca, destreza, armaMago);
            case 2: // Paladino
                ArmaPaladino armaPaladino;
                if (armaTipo == 1) {
                    armaPaladino = new Espada();
                } else {
                    armaPaladino = new Lanca();
                }
                return new Paladino(saude, forca, destreza, armaPaladino);
            case 3: // Clerigo
                ArmaClerigo armaClerigo;
                if (armaTipo == 1) {
                    armaClerigo = new Martelo();
                } else {
                    armaClerigo = new Maca();
                }
                return new Clerigo(saude, forca, destreza, armaClerigo);
            default:
                throw new IllegalArgumentException("Tipo de personagem inválido");
        }
    }
}
