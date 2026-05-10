package main;

import jakarta.persistence.*;
import model.Emprestimo;
import model.Livro;
import model.Membro;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
        EntityManager em = emf.createEntityManager();

        try{
            Livro livro = new Livro();
            livro.setTitulo("Dracula");
            livro.setAutor("Cleiton");
            livro.setIsbn("14562");
            livro.setAno(2003);

            Membro membro = new Membro();
            membro.setNome("Cleiton");
            membro.setEmail("Manodograugrau@gmail.com");
            membro.setTelefone("74991186561");


            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setMembro(membro);
            emprestimo.setLivro(livro);
            emprestimo.setDataEmprestimo(LocalDate.now());
            emprestimo.setDataDevolucao(LocalDate.now());

            em.getTransaction().begin();
            em.persist(livro);
            em.persist(membro);
            em.persist(emprestimo);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }finally {
            emf.close();
            em.close();
        }
    }
}
