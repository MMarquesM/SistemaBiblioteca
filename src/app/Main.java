package app;

import java.util.Scanner;
import model.Livro;
import service.BibliotecaService;
import service.LivroNaoEncontradoException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BibliotecaService biblioteca = new BibliotecaService();
        int opcao = -1;

        // Livros iniciais para facilitar a demonstração dos testes.
        biblioteca.cadastrarLivro(new Livro(1, "Dom Casmurro", "Machado de Assis"));
        biblioteca.cadastrarLivro(new Livro(2, "O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
        biblioteca.cadastrarLivro(new Livro(3, "Capitães da Areia", "Jorge Amado"));

        while (opcao != 0) {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro pelo código");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarLivro(scanner, biblioteca);
                        break;
                    case 2:
                        listarLivros(biblioteca);
                        break;
                    case 3:
                        buscarLivro(scanner, biblioteca);
                        break;
                    case 4:
                        emprestarLivro(scanner, biblioteca);
                        break;
                    case 5:
                        devolverLivro(scanner, biblioteca);
                        break;
                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void cadastrarLivro(Scanner scanner, BibliotecaService biblioteca) {
        try {
            System.out.print("Código: ");
            int codigo = Integer.parseInt(scanner.nextLine());

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            biblioteca.cadastrarLivro(new Livro(codigo, titulo, autor));
            System.out.println("Livro cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("O código precisa ser um número inteiro.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarLivros(BibliotecaService biblioteca) {
        if (biblioteca.listarLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\n--- LIVROS CADASTRADOS ---");
        for (Livro livro : biblioteca.listarLivros()) {
            System.out.println(livro);
        }
    }

    private static void buscarLivro(Scanner scanner, BibliotecaService biblioteca) {
        try {
            System.out.print("Digite o código do livro: ");
            int codigo = Integer.parseInt(scanner.nextLine());
            Livro livro = biblioteca.buscarLivro(codigo);
            System.out.println("Livro encontrado: " + livro);
        } catch (NumberFormatException e) {
            System.out.println("Digite um código numérico válido.");
        } catch (LivroNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void emprestarLivro(Scanner scanner, BibliotecaService biblioteca) {
        try {
            System.out.print("Digite o código do livro: ");
            int codigo = Integer.parseInt(scanner.nextLine());
            biblioteca.emprestarLivro(codigo);
            System.out.println("Livro emprestado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Digite um código numérico válido.");
        } catch (LivroNaoEncontradoException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void devolverLivro(Scanner scanner, BibliotecaService biblioteca) {
        try {
            System.out.print("Digite o código do livro: ");
            int codigo = Integer.parseInt(scanner.nextLine());
            biblioteca.devolverLivro(codigo);
            System.out.println("Livro devolvido com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Digite um código numérico válido.");
        } catch (LivroNaoEncontradoException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
