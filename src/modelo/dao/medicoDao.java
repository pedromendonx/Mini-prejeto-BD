package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.entidade.Medico;

public class medicoDao extends abstratoDao {
    
    public boolean adicionar (Medico medico) {
        boolean sucesso;
        String sql = "insert into medico (nome, matricula, especialidade, salario) values (?, ?, ?, ?)";
         try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setInt(2, medico.getMatricula());
            stmt.setString(3, medico.getEspecialidade());
            stmt.setFloat(4, medico.getSalario());

            sucesso = stmt.executeUpdate() == 1;
         } catch (Exception e) {
           sucesso = false;
         }
         return sucesso;
    }

    public Medico BuscarPorMatricula(int matricula)  {
        Medico medico = null;
        String sql = "select * from medico where matricula = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            ResultSet st = stmt.executeQuery();

            if (st.next()) 
                medico = new Medico(st.getString("nome"), st.getInt("matricula"), st.getString("especialidade"), st.getFloat("salario"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }
}
