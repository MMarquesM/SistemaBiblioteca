package service;

import java.util.ArrayList;
import model.Livro;

public class BibliotecaService {
    private ArrayList<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        if (buscarPorCodigoSemExcecao(livro.getCodigo()) != null) {
            throw new IllegalArgumentException("Já existe um livro com esse código.");
        }
        livros.add(livro);
    }

    public ArrayList<Livro> listarLivros() {
        return livros;
    }

    public Livro buscarLivro(int codigo) throws LivroNaoEncontradoException {
        Livro livro = buscarPorCodigoSemExcecao(codigo);
        if (livro == null) {
            throw new LivroNaoEncontradoException(
                    "Não foi encontrado um livro com o código " + codigo + ".");
        }
        return livro;
    }

    private Livro buscarPorCodigoSemExcecao(int codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }

    public void emprestarLivro(int codigo)
            throws LivroNaoEncontradoException {
        Livro livro = buscarLivro(codigo);
        livro.emprestar();
    }

    public void devolverLivro(int codigo)
            throws LivroNaoEncontradoException {
        Livro livro = buscarLivro(codigo);
        livro.devolver();
    }
}
