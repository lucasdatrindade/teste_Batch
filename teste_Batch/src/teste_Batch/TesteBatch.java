package teste_Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteBatch {

	 public static void main(String[] args) throws SQLException {
			Connection connection = Connections.getConnection();
			String SQL = "insert into tb_customer_account values (?,?,?,?,?)";
			int batchSize = 250;
			int count = 0;
			int[] result;			
			
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(SQL);
			
			for(int i=1;i<= 2000;i++){
				
				int rand = (int)(Math.random()*1000);
				
				pstmt.setNull(1, i);
				pstmt.setInt(2,100000 + i);
				pstmt.setString(3,"Customer"+i);
				pstmt.setString(4,"A");
				pstmt.setInt(5, rand);
				pstmt.addBatch();
				  
				count++;
			  
				if(count % batchSize == 0){
				  System.out.println("Insere no banco");
				  result = pstmt.executeBatch();
				  System.out.println("Linhas inseridas no banco de dados: "+ result.length);
				  connection.commit();
			    }			  
			}
	        
	        //REALIZAR CALCULOS APOS DADOS INSERIDOS
	        String SQL2 = "SELECT Tb_customer_account.* FROM Tb_customer_account WHERE vl_total > 560 "
	        		+ "AND (id_customer > 1500 AND id_customer < 2700) ORDER BY vl_total DESC";
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(SQL2);
	        
	        int i = 0;
	        float media = 0;
	        while (rs.next()) {
	        	
	        	int id = rs.getInt("id_customer");
	        	String cpf_cnpj = rs.getString("cpf_cnpj");
	        	String name = rs.getString("nm_customer");
	        	String status = rs.getString("is_active");
	        	int valor = rs.getInt("vl_total");
	        	
	        	System.out.println("Id: " + id + ", CPF/CNPJ: " + cpf_cnpj + 
	        			", nome: " + name + ", status: " + status + ", valor: " + valor +"\n");
	        	media += valor;
	        	i++;
	        }
	        System.out.println("Valor total: " + media);
	        System.out.println("Numeo de ocorrencias: " + i);
	        System.out.println("Média do valor total dos Ids (entre 1500 e 2700): " + media / i);

				
	        if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) connection.close();
	 }
}
