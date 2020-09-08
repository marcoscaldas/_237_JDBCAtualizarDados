package application;     //  PROGRAMA PARA ALTERAR SALARIO DO VENDEDOR

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args)  {
		
		Connection conn = null;
		PreparedStatement st =null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"UPDATE seller "  // espa�os tambem contam para dar erros
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsaffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsaffected );
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		}
}
