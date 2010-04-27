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
        function go_form() {
            var dataString = 'texto=' + window.btoa($('#texto').val()) + '&tipo_texto=' + $('#tipo_texto').val();

            $.ajax({
                type: "POST",
                url: "ChatServlet?EnviarMensagem",
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
                            
                        }
                        else
                        {
                            alert("Erro ao enviar a mensagem");
                        }
                    }
            });

            return false;
        }

        var scroll_i = 0;

        function processReq()
        {
          var dataString = '';

            $.getJSON("ChatServlet?GetMensagens",
                function (data)
                {
                   var date = new Date();
                   var arr = data[0];
                   for(var i = 0; i < arr.length; i+=2)
                       {
                           //alert(arr[i]);
                           $("#msgs").append("<table width=\"450\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">" +
                                             "<tr>" +
                                             "<td width=\"109\"><div align=\"center\"> " + arr[i] + " </div></td>" +
                                              "<td width=\"77\"><div align=\"center\">" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "</div></td>" +
                                             "<td width=\"242\"><div align=\"left\"> " + arr[i+1] + " </div></td>" +
                                             "</tr>" +
                                             "</table>" +
                                             "<br />");

                            scroll_i += 10;
                            $("div.msgs").scrollTop(scroll_i);
                       }
                });

                setTimeout("processReq()", 3000);
        } 
</script>
    <body onload="processReq()">
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
			Boolean sala_ok = (Boolean) getServletContext().getAttribute("sala_ok");
			if (login_ok.booleanValue() && sala_ok.booleanValue())
			{
		%>
        <table width="600" border="1">
          <tr>
            <td width="133"><div align="center">VIDEO AQUI </div></td>
            <td width="451"><div align="center"><%= getServletContext().getAttribute("titulo") %></div></td>
          </tr>
          <tr>
            <td colspan="2"><div id="msgs" align="center" style="overflow:scroll; height: 300px">
              
			  <%
			  	java.util.Collection msgs = (java.util.Collection) getServletContext().getAttribute("mensagens");
				java.util.Iterator it_msg = msgs.iterator();
                                while (it_msg.hasNext())
				{
					dao.IMensagemDAO i_msg = (dao.IMensagemDAO) it_msg.next();
			  %>
			  <table width="450" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="109"><div align="center"><%= i_msg.getUsuario().getLogin() %></div></td>
                  <td width="77"><div align="center"><%= i_msg.getDataEnvio().getHours() %>:<%= i_msg.getDataEnvio().getMinutes() %>:<%= i_msg.getDataEnvio().getSeconds() %></div></td>
                  <td width="242"><div align="left">
                          <%
                           if (i_msg.getTipo().equals("texto"))
                           {
                          %>
                          <%= i_msg.getMensagem() %>
                          <%
                           }
                           else if (i_msg.getTipo().equals("latex"))
                           {
                          %>
                          <img src="http://www.codecogs.com/gif.latex?<%= i_msg.getMensagem() %>" />
                          <%
                           }
                          %>
                      </div></td>
                </tr>
              </table>
              <br />
			  <%
			   }
			  %>

            </div></td>
          </tr>
          <tr>
            <td colspan="2"><div align="center">
                    <form id="form1" name="form1" method="post" action="" onsubmit="return go_form()">
                <table width="476" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="235"><label>
                      <textarea name="texto" cols="40" id="texto" style="background-color:#00CCFF; font-family: Verdana, Arial, Helvetica, sans-serif; font-size:10px; border:none"></textarea>
                    </label></td>
                    <td width="73"><label>
                      <div align="center">
                        <select name="tipo_texto" id="tipo_texto" style="background-color:#00CCFF; font-family: Verdana, Arial, Helvetica, sans-serif; font-size:10px; border:none">
                          <option value="texto">Texto</option>
                          <option value="latex">Latex</option>
                        </select>
                        </div>
                    </label></td>
                    <td width="168"><div align="center">
                      <label>
                      <input name="enviarBtn" type="submit" id="enviarBtn" value="Enviar" style="width: 50px; height: 50px" />
                      </label>
                      <input name="enviarBtn2" type="submit" id="enviarBtn2" value="Visualizar Latex" style="width: auto; height: 50px" />
                    </div></td>
                  </tr>
                </table>
                  </form>
              </div></td>
          </tr>
        </table>
		
		    <%
			  }
			  else if (!login_ok.booleanValue())
			  {
			%>
			É necessário fazer o login!
		    <%
			  }
			  else if (!sala_ok.booleanValue())
			  {
			%>
				A sala requisitada não foi encontrada!
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
