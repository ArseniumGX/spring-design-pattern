package edu.arseniumgx.gof.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Endereco {

  @Id
  @Getter
  @Setter
  private String cep;
  @Getter
  @Setter
  private String logradouro;
  @Getter
  @Setter
  private String complemento;
  @Getter
  @Setter
  private String bairro;
  @Getter
  @Setter
  private String localidade;
  @Getter
  @Setter
  private String uf;
  @Getter
  @Setter
  private String ibge;
  @Getter
  @Setter
  private String gia;
  @Getter
  @Setter
  private String ddd;
  @Getter
  @Setter
  private String siafi;

  @Override
  public String toString() {
    return "Endereco{" +
            "cep='" + cep + '\'' +
            ", logradouro='" + logradouro + '\'' +
            ", complemento='" + complemento + '\'' +
            ", bairro='" + bairro + '\'' +
            ", localidade='" + localidade + '\'' +
            ", uf='" + uf + '\'' +
            ", ibge='" + ibge + '\'' +
            ", gia='" + gia + '\'' +
            ", ddd='" + ddd + '\'' +
            ", siafi='" + siafi + '\'' +
            '}';
  }
}
