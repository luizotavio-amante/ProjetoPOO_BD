package DAO;

import Classes.Status_jog;

import java.sql.SQLException;
import java.util.ArrayList;

public class Status_jogDAO extends ConnectionDAO {

    boolean sucesso = false;

    public boolean inserirStatus(Status_jog status) {
        connectToDB();
        String sql = "INSERT INTO Status_jog (kills, deaths, horas_p_dia) values(?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, status.kills);
            pst.setInt(2, status.deaths);
            pst.setString(3, status.horas_p_dia);
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

    public boolean atualizarStatus(int id, Status_jog status) {
        connectToDB();
        String sql = "UPDATE Status_jog SET kills=?, deaths=?, horas_p_dia=? where idstatus_jog=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, status.kills);
            pst.setInt(2, status.deaths);
            pst.setString(3, status.horas_p_dia);
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

    public boolean deletarStatus(int id) {
        connectToDB();
        String sql = "DELETE FROM status_jog where idstatus_jog=?";

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

    public ArrayList<Status_jog> buscarStatus() {
        ArrayList<Status_jog> listaDeStatus = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM status";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Status: ");
            while (rs.next()) {
                Status_jog statusAux = new Status_jog();
                statusAux.kills = rs.getInt("kills");
                statusAux.deaths = rs.getInt("deaths");
                statusAux.horas_p_dia = rs.getString("horas_p_dia");
                System.out.println("kills = " + statusAux.kills);
                System.out.println("deaths = " + statusAux.deaths);
                System.out.println("horas_p_dia = " + statusAux.horas_p_dia);
                System.out.println("--------------------------------");
                listaDeStatus.add(statusAux);
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
        return listaDeStatus;
    }
}
