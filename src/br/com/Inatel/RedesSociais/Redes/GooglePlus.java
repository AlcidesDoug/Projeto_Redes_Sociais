package br.com.Inatel.RedesSociais.Redes;

import br.com.Inatel.RedesSociais.Interfaces.Compartilhamentos;
import br.com.Inatel.RedesSociais.Interfaces.VideoConferencia;
import br.com.Inatel.RedesSociais.RedeAbstrata.RedeSocial;

public class GooglePlus extends RedeSocial implements VideoConferencia, Compartilhamentos {
    @Override
    public void fazStreaming() {
        System.out.println("Realizou uma vídeo conferência no Google Plus!");
    }

    @Override
    public void postarFoto() {
        System.out.println("Postou uma foto no Google Plus!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um vídeo no Google Plus!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Postou um comentário no Google Plus!");
    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhou uma postagem no Google Plus!");
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
        System.out.println("Google Plus!");
    }
}
