<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<f:view>

  <h:form id="form_new_user">
    Nome: <h:inputText id="new_user_nome" value="#{gerenciadorUsuario.nome}"></h:inputText> <br/>
    E-Mail: <h:inputText id="new_user_email" value="#{gerenciadorUsuario.email}"></h:inputText> <br/>
    Usuário: <h:inputText id="new_user_usuario" value="#{gerenciadorUsuario.login}"></h:inputText> <br/>
    Senha: <h:inputText id="new_user_senha" value="#{gerenciadorUsuario.senha}"></h:inputText> <br/>        
    <h:commandButton action="#{gerenciadorUsuario.cadastrarUsuario}" value="Cadastrar"></h:commandButton>
    
  </h:form>
</f:view>
</body>
</html>