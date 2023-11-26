package DAO;

import Classes.Campeonato;

import java.sql.SQLException;
import java.util.ArrayList;

public class CampeonatoDAO extends ConnectionDAO{

    boolean sucesso = false;

    public boolean inserirCampeonato(Campeonato campeonato) {
        connectToDB();
        String sql = "INSERT INTO Campeonato (premiacao, times_inscritos, data) values(?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, campeonato.premiacao);
            pst.setInt(2, campeonato.times_inscritos);
            pst.setString(3, campeonato.data);
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

    public boolean atualizarCampeonato(int id, Campeonato campeonato) {
        connectToDB();
        String sql = "UPDATE campeonato SET premiacao=?, times_inscritos=?, data=?  where idCampeonato=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, campeonato.premiacao);
            pst.setInt(2, campeonato.times_inscritos);
            pst.setString(3, campeonato.data);
            pst.setInt(4, id);
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

    public boolean deletarCampeonato(int id) {
        connectToDB();
        String sql = "DELETE FROM campeonato where idCampeonato=?";

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

    public ArrayList<Campeonato> buscarCampeonato() {
        ArrayList<Campeonato> listaDeCampeonatos = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM campeonato";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Campeonatos: ");
            while (rs.next()) {
                Campeonato campeonatoAux = new Campeonato();
                campeonatoAux.premiacao = rs.getDouble("premiacao");
                campeonatoAux.times_inscritos = rs.getInt("times_inscritos");
                campeonatoAux.data = rs.getString("data");
                System.out.println("premiacao = " + campeonatoAux.premiacao);
                System.out.println("times_inscritos = " + campeonatoAux.times_inscritos);
                System.out.println("data = " + campeonatoAux.data);
                System.out.println("--------------------------------");
                listaDeCampeonatos.add(campeonatoAux);
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

        return listaDeCampeonatos;
    }
}
