package model;

import interfaces.Emprestavel;

public class Livro implements Emprestavel {
    private int codigo;
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    @Override
    public void emprestar() {
        if (emprestado) {
            throw new IllegalStateException("Este livro já está emprestado.");
        }
        emprestado = true;
    }

    @Override
    public void devolver() {
        if (!emprestado) {
            throw new IllegalStateException("Este livro não está emprestado.");
        }
        emprestado = false;
    }

    @Override
    public String toString() {
        String status = emprestado ? "Emprestado" : "Disponível";
        return "Código: " + codigo
                + " | Título: " + titulo
                + " | Autor: " + autor
                + " | Status: " + status;
    }
}
