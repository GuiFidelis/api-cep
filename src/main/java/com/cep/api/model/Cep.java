package com.cep.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cep")
@NoArgsConstructor
@ToString(exclude="id")
@Getter @Setter
public class Cep {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @NotEmpty
    private String codigoLoja;

    @NotNull
    @NotEmpty
    private long faixaInicio;

    @NotNull
    @NotEmpty
    private long faixaFim;
    
}
