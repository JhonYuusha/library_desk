package com.joaovictor;

import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    String titulo;
    boolean emprestado;

    Livro(String titulo) {
        this.titulo = titulo;
        this.emprestado = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Biblioteca ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o título do livro: ");
                    String titulo = sc.nextLine();
                    livros.add(new Livro(titulo));
                    System.out.println("Livro cadastrado!");
                }
                case 2 -> {
                    System.out.println("\nLista de livros:");
                    for (int i = 0; i < livros.size(); i++) {
                        Livro l = livros.get(i);
                        System.out.println((i+1) + ". " + l.titulo + (l.emprestado ? " (Emprestado)" : ""));
                    }
                }
                case 3 -> {
                    System.out.print("Digite o número do livro para empréstimo: ");
                    int num = sc.nextInt() - 1;
                    livros.get(num).emprestado = true;
                    System.out.println("Livro emprestado!");
                }
                case 4 -> {
                    System.out.print("Digite o número do livro para devolução: ");
                    int num = sc.nextInt() - 1;
                    livros.get(num).emprestado = false;
                    System.out.println("Livro devolvido!");
                }
                case 0 -> running = false;
            }
        }

        sc.close();
    }
};