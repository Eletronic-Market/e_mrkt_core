package br.com.mrkt.resource;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mrkt.dao.ConsumidorDAO;
import br.com.mrkt.model.Consumidor;
import br.com.mrkt.model.DocumentoPF;
import br.com.mrkt.model.Usuario;
import br.com.mrkt.notification.NotificacoesConsumidor;

/***
 * Recurso para registro de usuarios na aplicacao.
 * @author Lenno Sousa
 * @date Mar 9, 2019
 */
@Path("registro")
public class RegistroResource {
	
	/***
	 * Recurso responsavel por registrar o usuario consumidor.
	 * @param nome
	 * @param sobrenome
	 * @param cpf
	 * @param email
	 * @param senha
	 * @return statusRegistro
	 * @throws Exception 
	 */
	@PUT
	@Path("/consumidor/{nome}/{sobrenome}/{cpf}/{email}/{senha}/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registroConsumidor(
			@PathParam("nome") String nome, 
			@PathParam("sobrenome") String sobrenome,
			@PathParam("cpf") String cpf,
			@PathParam("email") String email, 
			@PathParam("senha") String senha) throws Exception {
		
		Response statusRegistro = null;
		
		try {
			
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setSenha(senha);
					
			DocumentoPF documentoPF = new DocumentoPF();
			documentoPF.setCpf(cpf);
						
			Consumidor consumidor = new Consumidor();
			consumidor.setNome(nome);
			consumidor.setSobrenome(sobrenome);
			consumidor.setUsuario(usuario);
			consumidor.setDocumentoPF(documentoPF);

			ConsumidorDAO consumidorDAO = ConsumidorDAO.getInstance();
			
			consumidor = consumidorDAO.verificaEmailExistente(consumidor);
					
			if(consumidor.getUsuario().getEmail() != null) {
					
				consumidor = consumidorDAO.verificarDocumentoExistente(consumidor);
				
				if(consumidor.getDocumentoPF().getCpf() != null) {
						
					consumidor = consumidorDAO.cadastrarConsumidor(consumidor);
						
					if(consumidor != null) {
							
						NotificacoesConsumidor notificacoesConsumidor = new NotificacoesConsumidor();
							
						if(notificacoesConsumidor.notificacaoCadastroConsumidor(consumidor)) {
								
							statusRegistro = Response.status(Response.Status.OK).build(); //Registro realizado com sucesso.
								
							//TO-DO on App
							//Informar que os dados foram cadastrados com sucesso.
							//Pedir para entrar no endereco de e-mail cadastrado e clicar no link para confirmar o cadastro.
								
						}else {
								
							//Informar o tipo de notificacao que nao foi enviada.
							consumidor.getNotificacaoPendente().setTipoNotificacao("");
							
							//Cadastrar notificacao pendente no banco de dados junto com o tipo de usuario.
							consumidorDAO.cadastrarNotificacaoPendente(consumidor);
							
							//TO-DO on Back-End
							//1 - Criar uma Thread para verificar de tempos em tempos a tabela com notificacoes pendentes.
							//2 - caso possua registro nessa tabela, ira recupera-los.
							//3 - Selecionar os dados do tipo de usuario atrelado a essa notificacao pendente e realizar o envio.
							//4 - Se a notificacao for reenviada com sucesso, apagar o registro na de notificacao pendente na tabela.
							//5 - Caso nao seja possivel reenviar a notificacao, mantem o registro e grave tais infos em logs.
							
							//TO-DO on App
							//Informar que os dados foram cadastrados e que em instante ira receber um email de confirmacao.
							
							statusRegistro = Response.status(Response.Status.CREATED).build(); //Falta enviar notificacao.
						}
					}else {
						
						statusRegistro = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(); //No momento nao foi possivel realizar o registro.
					}
				}else {
					
					statusRegistro = Response.status(Response.Status.CONFLICT).build(); //CPF ja cadastrado.
				}
			}else {
				
				statusRegistro = Response.status(Response.Status.PRECONDITION_FAILED).build(); //Email ja cadastrado no sistema.
			}		
		}catch(SQLException | ClassNotFoundException ex) {
			
			Logger.getLogger(ConsumidorResource.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return statusRegistro;
	}
	
	
	@PUT
	@Path("/supermercado/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registroSupermercado() {return Response.ok().build();}
	
	
	
}
