package DAO;

import Classes.Org;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrgDAO extends ConnectionDAO{

    boolean sucesso = false;

    public boolean inserirOrg(Org org) {
        connectToDB();
        String sql = "INSERT INTO Org (nome, membros_time) values(?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, org.nome);
            pst.setInt(2, org.membros_time);
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

    public boolean atualizarOrg(int id, Org org) {
        connectToDB();
        String sql = "UPDATE Org SET nome=?, membros_time=? where idOrg=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, org.nome);
            pst.setInt(2, org.membros_time);
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

    public boolean deletarOrg(int id) {
        connectToDB();
        String sql = "DELETE FROM Org where idOrg=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
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

    public ArrayList<Org> buscarOrg() {
        ArrayList<Org> listaDeOrganizacoes = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM org";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Organizacoes: ");
            while (rs.next()) {
                Org orgAux = new Org();
                orgAux.nome = rs.getString("nome");
                orgAux.membros_time = rs.getInt("membros_time");
                System.out.println("nome = " + orgAux.nome);
                System.out.println("membros_time = " + orgAux.membros_time);
                System.out.println("--------------------------------");
                listaDeOrganizacoes.add(orgAux);
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

        return listaDeOrganizacoes;
    }
}
