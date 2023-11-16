<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "MODEL.JavaBeans" %>
    
    <%@ page import = "java.util.ArrayList"%>
    
    <%
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
    for(int i = 0 ; i<lista.size() ; i++){
    //ACIMA FORAM FEITAS IMPORTAÇÕES PARA QUE SEJA POSSIVEL O RESCEBIMENTO DA CLASSE CONTROLLER
    //AS IMPORTAÇÕES SÃO DE EXTREMA IMPORTACIA!!! 
    	
    	
    	//AQUI É FEITO UM TESTE PARA TER CERTEZA QUE O DOCUMENT CADASTRO.JSP ESTÁ RECEBENDO O DADOS
    	//DA CLASSE CONTROLLER. 
    	
    	out.println(lista.get(i).getIdcon());
    	out.println(lista.get(i).getEmail());
    	out.println(lista.get(i).getSenha());
    	
    }
    %>
<!DOCTYPE html>
<html lang = "pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Tabela Cadatro</title>
</head>
<body>


<h1>TABELA DE CADASTROS </h1>
<!-- AQUI SERÁ FEITA A TABELA PARA  A EXIBIÇÃO DOS DADOS DO BANCO DE DADOS MISTURANDO HTML COM O 
DOCUMENTO JSP -->
<table id="tabela">
<thead>

<tr>
   <th>ID</th>
   <th>E-MAIL</th>
   <th>SENHA</th>
</tr>

</thead>
<tbody>
<%for(int i = 0 ; i<lista.size() ; i++){%>
	
	<tr>
	
	<td><%= lista.get(i).getIdcon() %></td>
	<td><%= lista.get(i).getEmail() %></td>
	<td><%= lista.get(i).getSenha() %></td>
	
	
	
	</tr>
	
	<%} %> 
</tbody>
</table>

</body>
</html>