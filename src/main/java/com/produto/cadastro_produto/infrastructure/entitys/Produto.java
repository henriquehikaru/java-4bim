package com.produto.cadastro_produto.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "produto")
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "descricao", unique = true)
    private String descricao;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "preco")
    private Double preco;
}
