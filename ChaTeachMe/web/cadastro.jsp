<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<style type="text/css">
<!--
body,td,th {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: bold;
}
-->
</style>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<script src="js/jquery-1.4.2.js">
</script>
<script language="javascript">
	var overColor = "lightblue";
	var outColor = "white";
	function onover(obj){
		obj.style.backgroundColor = overColor;
	}
	function onout(obj){
		obj.style.backgroundColor = outColor;
	}
        function go_form(){
            var dataString = 'nome=' + $("#nome").val() + "&email=" + $("#email").val() + "&login=" + $("#login").val() + "&senha=" + $("#senha").val();

            $.ajax({
                type: "POST",
                url: "CadastroServlet?Cadastrar",
                data: dataString,
                error:
                    function error(XMLHttpRequest, textStatus, errorThrown) {
                        alert("Error: " + textStatus + "; " + errorThrown);
                    },
                success:
                    function(data, textStatus, XMLHttpRequest) {
                        //$("#login_box").html("Logado com sucesso!");
                        if (data == 'true')
                        {
                            $("#table_form").fadeOut('fast', function()
                            {
                               $("#msg").html("Usuário cadastrado com sucusso!");
                            });
                            $("#Submit").fadeOut('fast', function() {});
                        }
                        else
                        {
                            alert(data);
                        }
                    }
            });

            return false;
        }
</script>
<body>
<div align="center">
  <table width="715" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="538" align="center"><img src="img/logo.png" width="500" height="200" /></td>
     </tr>
    <tr>
      <td><div align="center">
        <%@include file="inc/menu.jsp" %>
      </div>
        <div align="center"></div></td>
    </tr>
    <tr>
      <td><div align="center">
        <p>&nbsp;</p>
        <form id="form1" name="form1" method="post" action="" onsubmit="return go_form()">
            <table width="188" border="1" id="table_form">
            <tr>
              <td width="52"><div align="left">Nome:</div></td>
              <td width="120"><label>
                <input name="nome" type="text" id="nome" /> 
              </label></td>
            </tr>
            <tr>
              <td><div align="left">E-Mail:</div></td>
              <td><input name="email" type="text" id="email" /></td>
            </tr>
            <tr>
              <td><div align="left">Login:</div></td>
              <td><input name="login" type="text" id="login" /></td>
            </tr>
            <tr>
              <td><div align="left">Senha:</div>                <div align="left"></div>                <div align="left"></div>                <div align="left"></div></td>
              <td><input name="senha" type="password" id="senha" /></td>
            </tr>
          </table>
          <br />
          <label>
          <input type="submit" name="Submit" value="Enviar" id="Submit"/>
          </label>
          <div align="center" id="msg"></div>
        </form>
        <p>&nbsp;</p>
      </div></td>
    </tr>
  </table>
</div>
</body>
</html>
