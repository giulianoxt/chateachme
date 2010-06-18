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
<script language="javascript" src="js/jquery-1.4.2.js">
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
	
    function go_form_cad_sala(){
		var ip1_int = parseInt($("#ip1").val()) << 24;
		var ip2_int = parseInt($("#ip2").val()) << 16;
		var ip3_int = parseInt($("#ip3").val()) << 8;
		var ip4_int = parseInt($("#ip4").val());
		var ip = ip1_int + ip2_int + ip3_int + ip4_int;
        var dataString = 'titulo=' + $("#titulo").val() + '&ip=' + ip + '&descricao=' + $("#descricao").val();

        $.ajax({
            type: "POST",
            url: "ProfessorServlet?CadastrarSala",
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
                            alert("Sala cadastrada com sucesso!");
							$("#salas_table").append("<tr>" +
                  					"<td><div align=\"center\">" + $("#titulo").val() + "</div></td>" +
                  					"<td><div align=\"center\">" +
                    				"<input type=\"submit\" name=\"Submit2\" value=\"Abrir\" />" +
                  					"</div></td>" +
                  					"<td><div align=\"center\">" +
                    				"<input type=\"submit\" name=\"Submit3\" value=\"Excluir\" />" +
                  					"</div></td>" +
                					"</tr>");
                        }
                        else
                        {
                            alert("Erro ao tentar cadastrar sala!");
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
		
		<%
			Boolean login_ok = (Boolean) getServletContext().getAttribute("login_ok");
			if (login_ok.booleanValue())
			{
		%>

                <form method="post" action="" onsubmit="return go_form_cad_sala()">
        <table width="656" height="155" border="0" cellpadding="5" cellspacing="0">
          <tr>
            <td width="333"><div align="center">Cadastrar sala:<br />
              <table width="312" border="1">
                <tr>
                  <td width="135"><div align="left">T&iacute;tulo:</div></td>
                  <td width="141"><div align="left">
                    <label>
                    <input type="text" name="titulo" id="titulo" />
                    </label>
                  </div></td>
                </tr>
                <tr>
                  <td><div align="left">IP ( C&acirc;mera ): </div></td>
                  <td><div align="left">
                    <input name="ip1" type="text" id="ip1" size="3" />
                  .
                  <input name="ip2" type="text" id="ip2" size="3" />
                  .
                  <input name="ip3" type="text" id="ip3" size="3" />
                  .
                  <input name="ip4" type="text" id="ip4" size="3" />
                  </div></td>
                </tr>

                <tr>
                  <td>Descri&ccedil;&atilde;o:</td>
                  <td><textarea name="descricao" id="descricao"></textarea></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td><input type="submit" name="Submit72" value="Enviar" /></td>
                </tr>
              </table>
                    </form>
			  
</div></td>
            <td width="257" valign="top" bgcolor="#DBDDDC"><div align="center">
              <table width="200" border="1" id="salas_table">
                <tr>
                  <td><div align="center">Sala</div></td>
                  <td><div align="center"></div></td>
                  <td><div align="center"></div></td>
                </tr>


                  <%
                     java.util.Collection salas = (java.util.Collection)getServletContext().getAttribute("salas");
                     java.util.Iterator it = salas.iterator();

                     while (it.hasNext()) {
                         dao.ISalaDAO sala = (dao.ISalaDAO) it.next();
                  %>
                <tr>
                    <td><div align="center"><%= sala.getTitulo()%></div></td>
                  <td><div align="center">
                    <input type="submit" name="Submit2" value="Abrir" />
                  </div></td>
                  <td><div align="center">
                    <input type="submit" name="Submit3" value="Excluir" />
                  </div></td>
                </tr>
                  <% } %>
              </table>
            </div></td>
          </tr>
        </table>
		
		<%
		 }
		 else
		 {
		%>
		É necessário realizar o login!
		<%
		}
		%>
        <p>&nbsp;</p>
      </div></td>
    </tr>
  </table>
</div>
</body>
</html>
