package com.joao.bookstore.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import com.joao.bookstore.domain.Categoria;
import com.joao.bookstore.domain.Livro;
import com.joao.bookstore.repositories.CategoriaRepository;
import com.joao.bookstore.repositories.LivroRepository;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Aventura", "Livros de aventuras");
        Categoria cat3 = new Categoria(null, "Romance", "Livros de romance");

        Livro l1 = new Livro(null, "Clean Code", "Robert M", "Lorem ipsum", cat1);
        Livro l2 = new Livro(null, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Lorem ipsum", cat2);
        Livro l3 = new Livro(null, "Crepusculo", "Stephen M", "Lorem ipsum", cat3);

        cat1.getLivros().addAll(Arrays.asList(l1, l2, l3));
        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3));
    }

}
