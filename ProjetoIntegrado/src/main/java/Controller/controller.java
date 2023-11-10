package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CONEXAO.DAO;
import MODEL.JavaBeans;

//AQUI SÃO COLCADOS OS LINKS DOS BOSTÕES. O SERVELT VAI O REDIRECIONAMENTO PARA AS PAGINAS/ EXISTE ALGUNS PEQUENOS ADENDOS JÁ QUE ELE TAMBÉM PODE RECEBER DADOS DE OUTRO LUGAR POR EXEMPLO DOS FORMULARIO O "/INSERT" TRAZ A OS DADOS DA CAMADA QUE CRIA UMA NOVA SENHA. O URL... É OBRIGATORIO PARA O FUNCIONAMENTO. OUTRA COISA IMPORTANTE É NÃO ESQUECER DAS  {}  

@WebServlet(urlPatterns = { "/controller", "/main", "/novo" })

public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// AQUI CRIA UMA EXTENSÃO DA CLASSE DAO
	DAO conexao = new DAO();
	JavaBeans valores = new JavaBeans();

	public controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ESSA INSTACIA ARMAZENA AS REQUIZIÇÕES DO SERVLET ="/CONTROLLER" , "/MAIN"...
		// TODAS AS REQUZIÇÕES . O GETSERVLETPATH É EXTREMAMENTE IMPORTANTE PARA ISSO.
		String action = request.getServletPath();

		// VAI IMPRIMIR AS REQUIZIÇÕES ="/controller" "/main"...
		System.out.println(action);

		// ESSE PEDAÇO SIGNIFICA QUE ELE VAI ANALISAR QUAL É A REQUIZIÇÃO , E A RESPOSTA
		// VAI SER DE ACORDO COM O METODO
		if (action.equals("/main")) {
			cadastro(request, response);
		}

		else if (action.equals("/novo")) {
			novasenha(request, response);
		} else {
			response.sendRedirect("index.htm");
		}

		// TESTE DE CONEXÃO
		conexao.testedeconexao();

	}

	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SE A REQUIZIÇÃO FOR IGUA A MAIN ESSE METODO VAI SER CHAMADO NO
		// IF(ACTION.EQUALS("/MAIN")){} E ESSE VARIAVEL ABAIXO VAI RETORNAR COMO
		// RESPOSTA O REDIRECIONAMENTO PRA A CLASSE CADASTRO.JSP

		//response.sendRedirect("cadastro.jsp");
//AQUI SERÁ CRIADO UM OBJETO QUE VAI RECEBER OS DADOS DA CLASSE JAVABEANS
		ArrayList<JavaBeans> lista  = conexao.listarCadastros();
		for (int i = 0 ; i<lista.size(); i++) {
			
			System.out.println(lista.get(i).getIdcon());
			System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getSenha());
			
		}
		
	}

//REQUEST TRATA DAS REQUISIÇÕES QUE SÃO FEITAS PARA O SERVTLET = OS PEDIDOS QUE SÃO FEITOS

//RESPONSE ENVIA AS RESPOSTAS PARA ESSAS REQUISIÇÕES  = ENVIA AS RESPOSTAS PARA OS PEDIDOS

	
	
	// NOVO CADASTRO
	protected void novasenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ESSE METODO FUNCIONA DA MESMA MANEIRA DO METODO ACIMA

		
		// AQUI VAI SER FEITO UM TESTE PARA SABER SE OS PEDIDOS ESTÃO CHEGANDO PARA O
		// SERVTLET
		System.out.println(request.getParameter("usuario"));
		System.out.println(request.getParameter("senhacadastro"));

		
		// AQUI ELE VAI ENVIAR PRA CLASSE JAVABEANS AS SENHAS QUE FORAM ENVIADAS PARA O
		// FORMULARIO
		valores.setEmail(request.getParameter("usuario"));
		valores.setSenha(request.getParameter("senhacadastro"));

		
		// AGORA VAI SER PASSADO OS DADOS DO OBJETO CONTATOS PARA PARA O METODO DA
		// CLASSE DAO QUE ACABOU DE SER CRIADO

		
		conexao.Inserirdados(valores);
        
		
		//AQUI APÓS O  METODO SER ACIONADO ELE VAI REDIRECIONAR PARA CLASSE (MAIN) QUE VAI ACIONAR E ENVIAR PARA O DOCUMENTO (CADASTRO.JSP).
		response.sendRedirect("main");
	
	
	}

}
