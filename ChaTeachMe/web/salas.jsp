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
        <table width="450" border="1" bordercolor="#000000">
            <tr>
              <td onmouseover="onover(this)" onmouseout="onout(this)"><div align="center" id="princMenu"><a href="index.html">Principal</a></div></td>
              <td onmouseover="onover(this)" onmouseout="onout(this)"><div align="center"><a href="salas.html">Salas abertas </a></div></td>
              <td onmouseover="onover(this)" onmouseout="onout(this)"><div align="center"><a href="cadastro.html">Cadastro</a></div></td>
              <td onmouseover="onover(this)" onmouseout="onout(this)"><div align="center"><a href="admin.html">Administra&ccedil;&atilde;o</a></div></td>
              <td onmouseover="onover(this)" onmouseout="onout(this)"><div align="center"><a href="professor.html">Professor</a></div>                
              <div align="center"></div>                <div align="center"></div></td>
              <td onmouseover="onover(this)" onmouseout="onout(this)"><div align="center"><a href="sair.html">Sair</a></div></td>
            </tr>
          </table>
        </div>
        <div align="center"></div></td>
    </tr>
    <tr>
      <td><div align="center">
        <p>&nbsp;</p>
        <table width="329" border="1">
          <tr>
            <td width="199"><div align="center">Sala</div></td>
            <td width="58"><div align="center">Usu&aacute;rios</div></td>
            <td width="50"><div align="center"></div></td>
          </tr>

            <%
               java.util.Collection salas = (java.util.Collection) getServletContext().getAttribute("salas");
               java.util.Iterator it_s = salas.iterator();
               while (it_s.hasNext()) {
                   dao.memory.SalaDAO sala = (dao.memory.SalaDAO) it_s.next();
              %>

          <tr>
            <td><div align="center"><%= sala.getTitulo() %></div></td>
            <td><div align="center">0</div></td>
            <td  onmouseover="onover(this)" onmouseout="onout(this)"><div align="center"><a href="ChaTeachMe/LoginServet?Entrar&sala=<%= sala.getTitulo() %>" >Entrar</a></div></td>
          </tr>

          <%
            }
            %>
        </table>
        <p>&nbsp;</p>
      </div></td>
    </tr>
  </table>
</div>
</body>
</html>