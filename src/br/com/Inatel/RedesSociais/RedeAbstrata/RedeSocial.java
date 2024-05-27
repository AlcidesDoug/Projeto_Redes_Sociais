package br.com.Inatel.RedesSociais.RedeAbstrata;

public abstract class RedeSocial {
    protected String senha;
    protected int numAmigos;

    public abstract void postarFoto();
    public abstract void postarVideo();
    public abstract void postarComentario();

    public void curtirPublicacao() {
        System.out.println("Curtiu uma publicação no: ");
    }
}
