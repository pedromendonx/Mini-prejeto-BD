package modelo.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class abstratoDao implements Closeable {

	protected Connection conexao;

	public abstratoDao() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://10.225.0.4:3306/20211164010033_miniProjeto", "20211164010033", "20211164010033+mendonça");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}