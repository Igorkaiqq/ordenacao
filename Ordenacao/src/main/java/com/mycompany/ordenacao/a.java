/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.ordenacao;

import java.util.Scanner;

/**
 *
 * @author igork
 */
public class a {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Quantos números você deseja adicionar para fazer a ordenação?");
        int tamanho = leia.nextInt();

        int listaOriginal[] = new int[tamanho];
        int listaBolha[] = new int[tamanho];
        int listaInsercao[] = new int[tamanho];
        int listaSelecao[] = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            System.out.println("Digite um valor para inserir na posição " + i + ":");
            listaOriginal[i] = leia.nextInt();
        }

        for (int i = 0; i < tamanho; i++) {
            listaBolha[i] = listaOriginal[i];
            listaInsercao[i] = listaOriginal[i];
            listaSelecao[i] = listaOriginal[i];

        }

        System.out.println("Escolha a ordenação que você deseja realizar");
        System.out.println("1 - Bolha");
        System.out.println("2 - Inserção");
        System.out.println("3 - Seleção\n");

        int escolha = leia.nextInt();

        while (escolha != 0) {
            switch (escolha) {
                case 1:
                    mostrarVetorOriginal(listaOriginal);
                    bolha(listaBolha);
                    break;
                case 2:
                    mostrarVetorOriginal(listaOriginal);
                    insercao(listaInsercao);
                    break;
                case 3:
                    mostrarVetorOriginal(listaOriginal);
                    selecao(listaSelecao);
                    break;
                default:
                    System.out.println("Invalido");
            }
            System.out.println("\nEscolha a ordenação que você deseja realizar novamente");
            System.out.println("1 - Bolha");
            System.out.println("2 - Inserção");
            System.out.println("3 - Seleção");
            System.out.println("0 - Sair\n");

            escolha = leia.nextInt();
        }

        System.out.println("Você deseja comparar os métodos de ordenação?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int opcao = leia.nextInt();
        if (opcao == 1) {
            System.out.println("Qual comparação que você deseja fazer?");
            System.out.println("1 - Bolha com Inserção");
            System.out.println("2 - Bolha com Seleção");
            System.out.println("3 - Inserção com Seleção");
            opcao = leia.nextInt();

            while (opcao != 0) {
                switch (opcao) {
                    case 1:
                        bolha(listaBolha);
                        insercao(listaInsercao);
                        break;
                    case 2:
                        bolha(listaBolha);
                        selecao(listaSelecao);
                        break;
                    case 3:
                        insercao(listaInsercao);
                        selecao(listaSelecao);
                        break;
                    default:
                        System.out.println("Invalido");
                }

                System.out.println("Qual comparação que você deseja fazer?");
                System.out.println("1 - Bolha com Inserção");
                System.out.println("2 - Bolha com Seleção");
                System.out.println("3 - Inserção com Seleção");
                System.out.println("0 - Sair");
                opcao = leia.nextInt();

            }
        }

    }

    public static void mostrarVetorOriginal(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(" | " + lista[i]);
        }
        System.out.println("");
    }

    public static void bolha(int[] listaBolha) {
        long inicio = System.nanoTime();
        for (int i = 0; i < listaBolha.length; i++) {
            for (int j = 0; j < listaBolha.length - 1; j++) {
                if (listaBolha[j] > listaBolha[j + 1]) {
                    int aux = listaBolha[j];
                    listaBolha[j] = listaBolha[j + 1];
                    listaBolha[j + 1] = aux;
                }
            }
        }
        for (int i = 0; i < listaBolha.length; i++) {
            System.out.print(" | " + listaBolha[i]);
        }
        long fim = System.nanoTime();
        System.out.println("\nTempo de execução da ordenação por bolha: " + (fim - inicio) + " ns");
    }

    public static void insercao(int[] listaInsercao) {
        long inicio = System.nanoTime();
        for (int i = 1; i < listaInsercao.length; i++) {
            int aux = listaInsercao[i];
            int j = i - 1;
            while (j >= 0 && listaInsercao[j] > aux) {
                listaInsercao[j + 1] = listaInsercao[j];
                j--;
            }
            listaInsercao[j + 1] = aux;
        }
        for (int i = 0; i < listaInsercao.length; i++) {
            System.out.print(" | " + listaInsercao[i]);
        }
        long fim = System.nanoTime();
        System.out.println("\nTempo de execução da ordenação por insercao: " + (fim - inicio) + " ns");
    }

    public static void selecao(int[] listaSelecao) {
        long inicio = System.nanoTime();
        for (int i = 0; i < listaSelecao.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < listaSelecao.length; j++) {
                if (listaSelecao[j] < listaSelecao[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                int aux = listaSelecao[i];
                listaSelecao[i] = listaSelecao[indiceMenor];
                listaSelecao[indiceMenor] = aux;
            }
        }
        for (int i = 0; i < listaSelecao.length; i++) {
            System.out.print(" | " + listaSelecao[i]);
        }
        long fim = System.nanoTime();
        System.out.println("\nTempo de execução da ordenação por seleção: " + (fim - inicio) + " ns");
    }

    public static void compararBolhaInsercao(int[] listaBolha, int[] listaSelecao) {

    }

}
