package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeblogRepository codeblogRepository;

    //@PostConstruct
    public void savePost(){
        List<Post> postList = new  ArrayList<>();

        Post post1 = new Post();
        post1.setAutor("Arthur Nascimento");
        post1.setData(LocalDate.now());
        post1.setTitulo("Construindo Projeto em Java com Spring Boot / Maven");
        post1.setTexto("Descrição 1. do Projeto Blog Arthur: Blog criado com a linguagem Java utilizando o Spring Boot na aplicação (Spring MVC e Spring Security), banco de dados Postgres.");

        Post post2 = new Post();
        post2.setAutor("Arthur Nascimento");
        post2.setData(LocalDate.now());
        post2.setTitulo("Renderizando Páginas");
        post2.setTexto("Descrição 2. do Projeto Blog Arthur: Renderizando as páginas com HTML/Thymeleaf e o layout com Bootstrap.");

        postList.add(post1);
        postList.add(post2);

        for (Post post: postList){
            Post postSaved = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
