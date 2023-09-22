package edu.arseniumgx.gof.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  private String nome;

  @ManyToOne
  @Getter
  @Setter
  private Endereco endereco;
}
