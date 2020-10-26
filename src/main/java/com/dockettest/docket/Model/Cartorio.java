package com.dockettest.docket.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cartorio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeCartorio;
    private String enderecoCartorio;

    @JoinColumn(name="certidao_id")
    @OneToMany(cascade = CascadeType.ALL)
    public Set<Certidao> certidoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCartorio() {
        return nomeCartorio;
    }

    public void setNomeCartorio(String nomeCartorio) {
        this.nomeCartorio = nomeCartorio;
    }

    public String getEnderecoCartorio() {
        return enderecoCartorio;
    }

    public void setEnderecoCartorio(String enderecoCartorio) {
        this.enderecoCartorio = enderecoCartorio;
    }

    public Set<Certidao> getCertidoes() {
        return certidoes;
    }

    public void setCertidoes(Set<Certidao> certidoes) {
        this.certidoes = certidoes;
    }

    @Override
    public String toString() {
        return "Cartorio [certidoes=" + certidoes + ", enderecoCartorio=" + enderecoCartorio + ", id=" + id
                + ", nomeCartorio=" + nomeCartorio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cartorio other = (Cartorio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Cartorio() {
    }

    public Cartorio(Long id, String nomeCartorio, String enderecoCartorio, Set<Certidao> certidoes) {
        this.id = id;
        this.nomeCartorio = nomeCartorio;
        this.enderecoCartorio = enderecoCartorio;
        this.certidoes = certidoes;
    }

    public Cartorio(String nomeCartorio, String enderecoCartorio, Set<Certidao> certidoes) {
        this.nomeCartorio = nomeCartorio;
        this.enderecoCartorio = enderecoCartorio;
        this.certidoes = certidoes;
    }

    
}
