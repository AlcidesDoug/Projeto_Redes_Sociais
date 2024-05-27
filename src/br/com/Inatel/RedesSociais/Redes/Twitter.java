package br.com.Inatel.RedesSociais.Redes;

import br.com.Inatel.RedesSociais.Interfaces.Compartilhamentos;
import br.com.Inatel.RedesSociais.RedeAbstrata.RedeSocial;

public class Twitter extends RedeSocial implements Compartilhamentos {
    @Override
    public void postarFoto() {
        System.out.println("Postou uma foto no Twitter!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um vídeo no Twitter!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Postou um comentário no Twitter!");
    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhou uma postagem no Twitter!");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public void curtirPublicacao() {
        super.curtirPublicacao();
        System.out.println("Twitter!");
    }
}
