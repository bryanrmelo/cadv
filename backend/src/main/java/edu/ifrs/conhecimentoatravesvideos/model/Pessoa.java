package edu.ifrs.conhecimentoatravesvideos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@MappedSuperclass
public abstract class Pessoa extends Entidade {

    @NotNull
    @Size(min = 3, max = 80)
    @Column(nullable = false, length = 80)
    private String nome;

    @NotNull
    @Size(min = 15, max = 15)
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Deve estar no formato (99) 99999-9999")
    @Column(nullable = false, length = 15)
    private String telefone;

    @NotNull
    @Size(min = 10, max = 80)
    @Email
    @Column(nullable = false, length = 80, unique = true)
    private String email;

    @NotNull
    @Past
    @Column(name = "data_nascimento", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
