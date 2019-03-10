package br.com.mrkt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mrkt.model.Consumidor;
import br.com.mrkt.repository.ConnectionEMrktDB;
import br.com.mrkt.repository.IConnection;

public class ConsumidorDAO {
	
	private final IConnection conexao;
	private static ConsumidorDAO instance;
	
	
	private static final String VERIFICAR_EMAIL_EXISTENTE = "SELECT email FROM usuario (NOLOCK) WHERE email = ?";
	private static final String VERIFICAR_DOCUMENTO_EXISTENTE = "SELECT cpf FROM documento_pf (NOLOCK) WHERE cpf = ?";
	private static final String CADASTRAR_DADOS_CONSUMIDOR = "INSERT INTO usuario (email, senha, tipo_usuario, status) VALUES (?, ?, 1, 1)";
	private static final String CADASTRAR_DOCUMENTO_CONSUMIDOR = "INSERT INTO documento_pf (cpf) VALUES (?)";
	private static final String CADASTRAR_CONSUMIDOR = "INSERT INTO consumidor (nome, sobrenome, id_usuario, id_documento_pf) VALUES (?, ?, ?, ?)";
	
	
	/***
	 * Metodo contrutor que ja inicia a conexao com o Banco de Dados.
	 * @throws Exception
	 */
	public ConsumidorDAO() throws SQLException, ClassNotFoundException{
		this.conexao = new ConnectionEMrktDB();
	}
	
	
	/***
	 * metodo responsavel por criar uma instancia da classe ConsumidorDAO (Singleton Pattern).
	 * @return
	 * @throws Exception
	 */
	public static ConsumidorDAO getInstance() throws Exception {
		
		if (instance == null) {
			instance = new ConsumidorDAO(); 
		}
		return instance;
	}



	public Consumidor verificaEmailExistente(Consumidor consumidor) throws SQLException {
		
		try {
			PreparedStatement pstmt = conexao.getConnection().prepareStatement(VERIFICAR_EMAIL_EXISTENTE);
			pstmt.setString(1, consumidor.getUsuario().getEmail());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				consumidor.getUsuario().setEmail(null);
			}
			
		}catch(SQLException e) {
			
			throw new SQLException(e);
			
		}finally {
			conexao.close();
		}
		
		return consumidor;
	}



	public Consumidor verificarDocumentoExistente(Consumidor consumidor) throws SQLException {
		
		try {
			PreparedStatement pstmt = conexao.getConnection().prepareStatement(VERIFICAR_DOCUMENTO_EXISTENTE);
			pstmt.setString(1, consumidor.getDocumentoPF().getCpf());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				consumidor.getDocumentoPF().setCpf(null);
			}
			
		}catch(SQLException e) {
			
			throw new SQLException(e);
			
		}finally {
			
			conexao.close();
		}
		
		return consumidor;
		
	}



	public Consumidor cadastrarConsumidor(Consumidor consumidor) throws SQLException {
		
		try {
			PreparedStatement pstmtUsuario = conexao.getConnection().prepareStatement(CADASTRAR_DADOS_CONSUMIDOR, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmtUsuario.setString(1, consumidor.getUsuario().getEmail());
			pstmtUsuario.setString(2, consumidor.getUsuario().getSenha());
			pstmtUsuario.execute();
			
			ResultSet rsIdUsuario = pstmtUsuario.getGeneratedKeys();
			
			if(rsIdUsuario.next()) {
				
				PreparedStatement pstmtDocumentoPF = conexao.getConnection().prepareStatement(CADASTRAR_DOCUMENTO_CONSUMIDOR, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmtDocumentoPF.setString(1, consumidor.getDocumentoPF().getCpf());
				pstmtDocumentoPF.execute();
				
				ResultSet rsIdDocumentoPF = pstmtDocumentoPF.getGeneratedKeys();
				
				if(rsIdDocumentoPF.next()) {
					
					PreparedStatement pstmtConsumidor = conexao.getConnection().prepareStatement(CADASTRAR_CONSUMIDOR, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmtConsumidor.setString(1, consumidor.getNome());
					pstmtConsumidor.setString(2, consumidor.getSobrenome());
					pstmtConsumidor.setInt(3, rsIdUsuario.getInt("id_usuario"));
					pstmtConsumidor.setInt(4, rsIdDocumentoPF.getInt("id_documento_pf"));
					pstmtConsumidor.execute();
					
					ResultSet rsIdConsumidor = pstmtConsumidor.getGeneratedKeys();
					
					if(rsIdConsumidor.next()) {
						consumidor.setIdConsumidor(rsIdConsumidor.getInt("id_consumidor"));
					}else {
						consumidor = null;
					}
				}else {
					consumidor = null;
				}
			}else {
				consumidor = null;
			}
			
			conexao.commit();
			
		}catch(SQLException e) {
			
			conexao.rollback();
			throw new SQLException(e);
			
		}finally {
			
			conexao.close();
		}
		
		return consumidor;
	}



	public void cadastrarNotificacaoPendente(Consumidor consumidor) {
		// TODO Cadastrar notificacao pendente na base.
		
	}
	
	public String consultaPais() throws SQLException {
		
		String retorno = "";
		
		try {
			PreparedStatement pstmt = conexao.getConnection().prepareStatement("select nome from pais limit 1");
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				retorno = rs.getString("nome");
			}
			
		}catch(SQLException e) {
			
			conexao.close();
			throw new SQLException(e);
			
		}finally {
			
			//conexao.close();
		}
		
		return retorno;
	}
	
}
