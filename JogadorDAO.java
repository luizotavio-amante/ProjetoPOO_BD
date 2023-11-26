package DAO;

import Classes.Jogador;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorDAO extends ConnectionDAO {

    boolean sucesso = false;

    public boolean inserirJogador(Jogador jogador) {
        connectToDB();
        String sql = "INSERT INTO Jogador (nick_apelido, funcao, Org_idOrg, Status_jog_idStatus_jog) values(?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.nick_apelido);
            pst.setString(2, jogador.funcao);
            pst.setInt(3, jogador.Org_idOrg);
            pst.setInt(4, jogador.Status_jog_idStatus_jog);
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean atualizarJogador(int id, Jogador jogador) {
        connectToDB();
        String sql = "UPDATE jogador SET nick_apelido=?, funcao=? where idJogador=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.nick_apelido);
            pst.setString(2, jogador.funcao);
            pst.setInt(3, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deletarJogador(int id) {
        connectToDB();
        String sql = "DELETE FROM jogador where idJogador=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Jogador> buscarJogador() {
        ArrayList<Jogador> listaDeJogadores = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM jogador";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Jogadores: ");
            while (rs.next()) {
                Jogador jogadorAux = new Jogador();
                jogadorAux.nick_apelido = rs.getString("nick_apelido");
                jogadorAux.funcao = rs.getString("funcao");
                System.out.println("nick_apelido = " + jogadorAux.nick_apelido);
                System.out.println("funcao = " + jogadorAux.funcao);
                System.out.println("--------------------------------");
                listaDeJogadores.add(jogadorAux);
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaDeJogadores;
    }
}
