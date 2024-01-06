package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.entidade.Paciente;

public class pacienteDao extends abstratoDao{
    public boolean adicionar (Paciente paciente) {
        boolean sucesso;
        String sql = "insert into paciente (nome, cpf, doenca) values (?, ?, ?)";
         try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getDoenca());

            sucesso = stmt.executeUpdate() == 1;
         } catch (Exception e) {
           sucesso = false;
         }
         return sucesso;
    }

    public Paciente BuscarPorCpf (String cpf) {
        Paciente paciente = null;
        String sql = "select * from paciente where cpf = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet st = stmt.executeQuery();

            if (st.next()) 
                paciente = new Paciente(st.getString("nome"), st.getString("cpf"), st.getString("doenca"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }
}

