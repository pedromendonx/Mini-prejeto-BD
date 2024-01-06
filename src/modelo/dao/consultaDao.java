package modelo.dao;
import modelo.entidade.Consulta;
import modelo.entidade.Medico;
import modelo.entidade.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class consultaDao extends abstratoDao {
    public boolean adicionar (int matricula, String cpf, LocalDateTime horario, float valor) {
        boolean sucesso;
        String sql = "insert into consulta (id_medico, id_paciente) values" + "((select id from medico where matricula = ?), (select id from paciente where cpf = ?), (select * from consulta where horario = ?), (select * from consulta where valor = ?))";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            stmt.setString(2, cpf);
            stmt.setObject(3, horario);
            stmt.setFloat(4, valor);

            sucesso = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            sucesso = false;
        }

        return sucesso;

    }

    public boolean remover (int matricula, String cpf, LocalDateTime horario) {
        boolean sucesso;
        String sql = "delete from consulta where id_medico = (select id from medico where matricula = ?)" + " and id_paciente = (select id from paciente where cpf = ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, matricula);
            stmt.setString(2, cpf);
            stmt.setObject(3, horario);

            sucesso = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            sucesso = false;
        }
        return sucesso;

    }

    public boolean atualizar (int matricula, String cpf, LocalDateTime novoHorario) {
        boolean sucesso;
        String sql = "update consulta set horario = ? where id_medico = (select id from medico where matricula = ?)" + " and id_paciente = (select id from paciente where cpf = ?)"; 

        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, matricula);
            stmt.setString(2, cpf);
            stmt.setObject(3, novoHorario);

            sucesso = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            sucesso = false;
            e.printStackTrace();
        }
        return sucesso;
    }

    public boolean ConsultarConsulta (Medico medico, Paciente paciente, Consulta consulta) {
        boolean sucesso = false;
        String sql = "select count(*) from consulta where id_medico = ? and id_paciente = ? and horario = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setObject(1, medico);
            stmt.setObject(2, paciente);
            stmt.setObject(3, consulta);

            try (ResultSet st = stmt.executeQuery()) {
                if (st.next()) {
                    int cont = st.getInt(1);
                    sucesso = cont > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Falha na verificação: " + e.getMessage());
        }
        return sucesso;
    }

    public List<Consulta> listar() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "select medico.*, paciente.* from consulta inner join medico on" + "medico.id = consulta.id_medico inner join paciente on paciente.id = consulta.id_paciente";

        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet st = stmt.executeQuery()) {

            while (st.next()) {

                Medico m = new Medico(st.getString("medico.nome"), st.getInt("medico.matricula"), st.getString("medico.especialidade"), st.getFloat("medico.salario"));
                Paciente p = new Paciente(st.getString("paciente.nome"), st.getString("paciente.cpf"), st.getString("paciente.doenca")); 
                Consulta c = new Consulta(m, p, st.getObject("consulta.horario", LocalDateTime.class), st.getFloat("consulta.valor"));

                consultas.add(c);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}