package com.rita.gaieski.apiteste.model;
import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.*;


@Component
// essas anotação fazem parte do Lombok que eu nao disse
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

// BD - entidade - Cliente - Classe no Java é Cliente
// JPA - Java Persistence API
@Entity
@Table(name= "cliente")


public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long id;

    @Column(name = "nome") // aqui é a coluna do BD
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

}//fim
// Mapeamento de JPA

// aqui ele indica onde cada dado irá entrar...

