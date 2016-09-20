package br.com.codefield.exemplos.app_completo.api.modelo;

import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author carlos.oliveira
 * @since 2016-09-20
 */
@Entity
@Table(name = "CF_EX_PRODUTO")
@Setter
public class Produto implements Serializable {

    private Long id;
    private String nome;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(name = "NOME")
    public String getNome() {
        return nome;
    }
}
