package br.com.Inatel.RedesSociais.Redes;

import br.com.Inatel.RedesSociais.RedeAbstrata.RedeSocial;

public class Instagram extends RedeSocial {
    @Override
    public void postarFoto() {
        System.out.println("Postou uma foto no Instagram!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um vídeo no Instagram!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Postou um comentário no Instagram!");
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
        System.out.println("Instagram!");
    }
}
