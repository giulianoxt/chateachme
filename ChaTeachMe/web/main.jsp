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

              <%@include file="inc/menu.jsp" %>


        </div>
        <div align="center"></div></td>
    </tr>
    <tr>
      <td><div align="center">
        <p>&nbsp;</p>
        <table width="200" border="1">
          <tr>
            <td><div align="center">Usu&aacute;rios cadastrados </div></td>
            <td> <div align="center">3 </div></td>
          </tr>
          <tr>
            <td><div align="center">Salas abertas </div>              <div align="center"></div></td>
            <td><div align="center">10</div>              <div align="center"></div></td>
          </tr>
          <tr>
            <td><div align="center">Usu&aacute;rios online </div></td>
            <td><div align="center">2</div></td>
          </tr>
        </table>
        <br />
        <form id="form1" name="form1" method="post" action="">
          <table width="188" border="1">

            <tr>
              <td width="52"><div align="left">Login:</div></td>
              <td width="120"><input type="text" name="textfield3" /></td>
            </tr>
            <tr>
              <td><div align="left">Senha:</div>
                  <div align="left"></div>
                <div align="left"></div>
                <div align="left"></div></td>
              <td><input type="password" name="textfield4" /></td>
            </tr>
          </table>
          <br />
          <label>
          <input type="submit" name="Submit" value="Entrar" />
          </label>
        </form>
        <p>&nbsp;</p>
      </div></td>
    </tr>
  </table>
</div>
</body>
</html>