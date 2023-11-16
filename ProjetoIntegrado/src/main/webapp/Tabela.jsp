<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- AS IMPORTAÇÕES SÃO DE EXTREMA IMPORTANCIA PARA CHAMAR AS CLASSES E EXIBIR OS DADOS-->
    <%@ page import = "MODEL.JavaBeans" %>
    
    <%@ page import = "java.util.ArrayList"%>
    
    <%
    
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("dados");
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabela de Contatos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" 
integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" 
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" 
integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" 
crossorigin="anonymous"></script>

</head>
<body>
<!-- ESSA É A TABELA DE RESGISTRO DE CONTATOS , AQUI É MISTURADO JAVA COM HTML -->
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">E-MAIL</th>
      <th scope="col">SENHA</th>

    </tr>
  </thead>
  <tbody>
  
    <tr>      
    
    <% for(int i = 0 ; i<lista.size() ; i++){%>
    <!-- NESSE CASO PARA MOSTRAR OS DADOS É NECESSARIO COLOCAR O (=). SEMPRE QUE FOR COLOCAR ALGUM  
    DADO EM JAVA É NECESSARIO COLOCAR O SINAL DE MAIO E MENOR <>  ,  COM A PORCENTAGEM %% E COM O 
    SINAL DE = -->
    
    
      <td><%=lista.get(i).getIdcon() %></td>
      <td><%=lista.get(i).getEmail() %></td>
      <td><%=lista.get(i).getSenha() %></td>
      
    </tr>
  
    
    <%}%>
    <!-- AQUI É NECESSARIO COLOCAR ESSE ESQUEMA DE SEPARA AS CHAVES PARA OS ELEMENTOS FICAREM UM EMBAIXO DO OUTRO. -->
    </tbody>
    
</table>
</body>
</html>