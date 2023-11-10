package CADASTRO_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import CONEXAO.DAO;
import MODEL.JavaBeans;

public class cadastro_dao {

	/***
	 * CRUD c = CREATE r = READ u = UPDATE d = DELETE
	 */
	public void save(JavaBeans contato) {
		/**
		 * ESSE METODO SERVE PARA SALVAR OS CADASTROS QUE SERÃO FEITOS PELOS USUARIOS
		 * ESSA FRASE AO LADO DO SQL SERVE É USADA NO MYSAQL PARA INSERIR ALGUM DADO NA
		 * TABELA
		 */

		String sql = "INSERT INTO  credenciais (email , senha , datacadastro) VALUES(? , ? , ?)";

		/*
		 * Essa criação de objeto vai ajudar na criação da conexão com o banco de dados
		 */
		Connection con = null;

		/* Essa estrutura vai ajudar a na conexão da estrutura de java com o msql */
		PreparedStatement pstm = null;

		try {

			// ESSA PARTE VAI CRIAR UMA CONEXÃO COM O BACO DE DADOS
			con = DAO.createConnectionMysql();

			// ELE VAI PREPARA A CONEXÃO (ELE ESPERA QUE VOCÊ PASSE UMA STRING PARA ELE (O
			// SQL QUE FOI CRIADO))
			pstm = con.prepareStatement(sql);

			/*
			 * AQUI ELE ADICIONA OS VALORE DA CLASSE JAVABEANS E QUE SÃO ESPERADOS PELA
			 * QUERY
			 */
			pstm.setString(1, contato.getEmail());
			pstm.setString(2, contato.getSenha());
			
			// AQUI ELE VAI EXECUTAR A CONEXÃO
			pstm.execute();
		}
		// SE HOUVER UMA EXEÇÃO ELE VAI PRINTAR A ELA
		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			try {
				//FECHAR CONEXÃO
				// SE A CONEXÃO FOR DIFERENTE DE VAZIO ELE FECHAR ELA
				if (pstm != null) {
					pstm.close();
				}
				if (con != null) {
					con.close();
				}
			}
           //SE HOUVER UMA EXEÇÃO ELE VAI IMPRIMIR ELA 
			catch (Exception e2) {
				System.out.println(e2);
			}

		}

	}

}
