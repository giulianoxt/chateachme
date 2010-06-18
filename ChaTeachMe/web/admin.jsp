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
      <td>

          <%
                String administrador = (String) getServletContext().getAttribute("administrador");
                if (administrador != null) {
            %>
          <div align="center">
        <p>&nbsp;</p>
        <table width="656" height="155" border="0" cellpadding="5" cellspacing="0">

            
          <tr>
            <td width="333"><!--<div align="center">
              <p>A B C D E F G H I J K L M N O<br /> 
                P Q R S T U V W X Y Z 0/9<br />
                  <br />
                    P&aacute;ginas: [1] 2 3 4 5 <br />
                  <br />
              </p>
              </div>-->
			  <div align="center" style="overflow:scroll; height:100px">
			    <table width="200" border="1">
                  <tr>
                    <td><div align="center">Usu&aacute;rio</div></td>
                    <td><div align="center"></div></td>
                    </tr>

                  <%
                    java.util.Collection usuarios = (java.util.Collection)getServletContext().getAttribute("usuarios");
                    java.util.Iterator it = usuarios.iterator();
                    while (it.hasNext()) {
                        dao.IUsuarioDAO usuario = (dao.IUsuarioDAO) it.next();
                  %>
                  <tr>
                    <td><div align="center"><%= usuario.getNome() %></div></td>
                    <td><div align="center"><a href="admin_ver.html">Ver</a></div></td>
                   </tr>
                 <% } %>				
                </table>
			  </div></td>
            <td width="257" valign="top" bgcolor="#DBDDDC">Informa&ccedil;&atilde;o sobre Exemplo01<br />
              <br />
              Nome: Exemplo Um<br />
              E-Mail : exemplo01@exemplo.com<br />
              Usu&aacute;rio: Exemplo01<br />
              <br />
              <br />
			  <div align="center">
			    <label>
			    <input type="submit" name="Submit" value="Excluir" />
			    </label>
			    <label></label>
			  </div>
			  
			  </td>
          </tr>

                <tr>
            <td bgcolor="#DBDDDC"><div align="center">
			
			<div align="center" style="overflow:scroll; height:100px">
			    <table width="200" border="1">
                  <tr>
                    <td><div align="center">Sala</div></td>
                    <td>Situa&ccedil;&atilde;o</td>
                    <td><div align="center"></div></td>
                    <td>&nbsp;</td>
                  </tr>

                  <%
                    java.util.Collection salas = (java.util.Collection)getServletContext().getAttribute("salas");
                    java.util.Iterator it2 = salas.iterator();
                    while (it2.hasNext()) {
                        dao.ISalaDAO sala = (dao.ISalaDAO)it2.next();
                        String open;
                        if (sala.isSalaAberta().booleanValue())
                            open = "Aberta";
                        else
                            open = "Fechada";
                  %>
                  <tr>
                    <td><div align="center"><%= sala.getTitulo() %></div></td>
                    <td><div align="center"><%= open %></div></td>
                    <td><div align="center"><a href="admin_ver.html">Excluir</a></div></td>
                    <td><div align="center">Fechar</div></td>
                  </tr>
                  <% } %>
                </table>
  
			  </div>
			
			</div></td>
            <td>&nbsp;</td>
          </tr>
        </table>

        <%
            } else {
         %>
         <br/><br/><br/>
        <div align="center">
            É necessário realizar o login.
        </div>
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
