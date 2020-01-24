package br.com.tt.comunicador.tela;
import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Usuario;
import java.util.ArrayList;

public class MenuEntrar {
    private final ArrayList<Usuario> usuarios;
    private final Util util;

    public MenuEntrar(Util util, ArrayList<Usuario> usuarios) {
        this.util = util;
        this.usuarios = usuarios;
    }

    public Usuario entrar(){
        util.printaAewPorGentiliza("Informe seu username (new) para novo usuario");
        String usernameDigitado = util.entraComAInformacaoAewManolo();

        if(usernameDigitado.equals("new")){
            util.printaAewPorGentiliza("What's ur name?");
            String nome = util.entraComAInformacaoAewManolo();
            util.printaAewPorGentiliza("What's ur USERname?");
            String userName = util.entraComAInformacaoAewManolo();
            util.printaAewPorGentiliza("Qual seu estado?");
            String estado = util.entraComAInformacaoAewManolo();
            util.printaAewPorGentiliza("When u was born? (dd/mm/yyyy)");
            String dataNascimento = util.entraComAInformacaoAewManolo();


            Usuario novoUsuario = new Usuario(nome, userName, dataNascimento, estado);
            usuarios.add(novoUsuario);
            return novoUsuario;
        }

        for(Usuario umUser : usuarios){
            if(umUser.getUsername().equals(usernameDigitado)){
                util.printaAewPorGentiliza("LOGADO!");
                return umUser;
            }
        }
        util.printaAewPorGentiliza("ERROUUU!!!!");

        return null;
    }

}
