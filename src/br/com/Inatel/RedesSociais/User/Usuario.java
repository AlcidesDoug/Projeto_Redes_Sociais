package br.com.Inatel.RedesSociais.User;

import br.com.Inatel.Excecoes.InvalidUserException;
import br.com.Inatel.Excecoes.RedeSocialException;
import br.com.Inatel.RedesSociais.Interfaces.Compartilhamentos;
import br.com.Inatel.RedesSociais.Interfaces.VideoConferencia;
import br.com.Inatel.RedesSociais.RedeAbstrata.RedeSocial;
import br.com.Inatel.RedesSociais.Redes.Facebook;
import br.com.Inatel.RedesSociais.Redes.GooglePlus;
import br.com.Inatel.RedesSociais.Redes.Instagram;
import br.com.Inatel.RedesSociais.Redes.Twitter;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Usuario {

    private String nome;
    private String email;
    private Set<RedeSocial> redesSociais;

    public Usuario(String nome, String email, RedeSocial[] redesSociaisArray) throws InvalidUserException, RedeSocialException {
        if (nome == null || nome.isEmpty() || email == null || email.isEmpty()) {
            throw new InvalidUserException("Nome e email não podem ser nulos ou vazios!");
        }
        this.nome = nome;
        this.email = email;
        this.redesSociais = new HashSet<>();

        boolean encontrouCompartilhamento = false;

        for (RedeSocial rede : redesSociaisArray) {
            if (rede != null) {
                if (!this.redesSociais.add(rede)) {
                    throw new RedeSocialException("Não pode adicionar redes sociais duplicadas!");
                }
                if (rede instanceof Compartilhamentos) {
                    encontrouCompartilhamento = true;
                }
            }
        }

        if (!encontrouCompartilhamento) {
            throw new RedeSocialException("É necessário pelo menos uma rede social que suporte compartilhamento de posts");
        }
    }

    public void usarRedesSociais() {
        System.out.println("Usuário: " + nome + ", Email: " + email + " praticou as seguintes ações:");
        int count = 0;
        for (RedeSocial rede : redesSociais) {
            if (count == 0) {
                rede.postarFoto();
                rede.postarVideo();
                rede.postarComentario();
            } else if (count == 1) {
                if (rede instanceof Compartilhamentos) {
                    ((Compartilhamentos) rede).compartilhar();
                }
                if (rede instanceof VideoConferencia) {
                    ((VideoConferencia) rede).fazStreaming();
                }
                rede.curtirPublicacao();
            }
            count++;
            if (count >= 2) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Usuário: " + nome + ", Email: " + email;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();

            if (nome == null || nome.isEmpty() || email == null || email.isEmpty()) {
                throw new InvalidUserException("Nome e email não podem ser nulos ou vazios!");
            }


            RedeSocial[] redes = new RedeSocial[2];
            boolean twitterSelecionado = false;
            boolean instagramSelecionado = false;

            for (int i = 0; i < redes.length; i++) {
                System.out.println("Escolha a rede social " + (i + 1) + ":");
                System.out.println("1. Facebook");
                System.out.println("2. Twitter");
                System.out.println("3. GooglePlus");
                System.out.println("4. Instagram");

                if (!scanner.hasNextInt()) {
                    throw new RedeSocialException("Código Inválido!");
                }

                int escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        redes[i] = new Facebook();
                        break;
                    case 2:
                        redes[i] = new Twitter();
                        twitterSelecionado = true;
                        break;
                    case 3:
                        redes[i] = new GooglePlus();
                        break;
                    case 4:
                        redes[i] = new Instagram();
                        instagramSelecionado = true;
                        break;
                    default:
                        System.out.println("Escolha inválida. Tente novamente.");
                        i--;
                }
            }


            if (redes[0] instanceof Instagram && redes[1] != null) {
                RedeSocial temp = redes[0];
                redes[0] = redes[1];
                redes[1] = temp;
            }

            if (twitterSelecionado && instagramSelecionado) {
                throw new RedeSocialException("Impossível utilizar as redes Instagram e Twitter ao mesmo tempo - Não há métodos o suficiente!");
            }

            Usuario usuario = new Usuario(nome, email, redes);
            usuario.usarRedesSociais();
        } catch (InvalidUserException | RedeSocialException e) {
            System.out.println("Erro ao criar usuário ou usar redes sociais: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }


}
