<html>
	<head>
		<title>HHZ Coffee Machine says hello</title>
		<!-- link rel="stylesheet" href="style.css" type="text/css"/-->
		<style type="text/css">
			h2{color:red}
		</style>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<header>
			<h1>Coffee Machine</h1>
		</header>
		
		<div id="main">
			<section id="register">
				<h2>Register here</h2>
				<p><font color="red">${message}</font></p>
				<form action="/coffeemachine-web/index" method="post">
					<table border="0" cellspacing="2" cellpadding="2">
					  <tbody>
						<tr>
						  <td align="right">Matrikelnummer:</td>
						  <td>
							<input maxlength="10" name="id" size="25" type="text" />
						  </td>
						</tr>
						<tr>
						  <td align="right">Vorname:</td>
						  <td>
							<input maxlength="10" name="firstname" size="25" type="text" />
						  </td>
						</tr>
						<tr>
						  <td align="right">Nachname:</td>
						  <td>
							<input maxlength="10" name="lastname" size="25" type="text" />
						  </td>
						</tr>
						<tr>
							<td align="center"> </td>
							<td><input type="submit" value="Registrieren" /><td>
						</tr>
					  </tbody>
					</table>
				</form>
			</section>
			
			<section id="login">
				<h2>Kaffee gekocht und bereits registriert?</h2>
				<h3>     --> dann hier die Arbeit festhalten:</h3>
				<table border="0" cellspacing="2" cellpadding="2">
				  <tbody>
					<tr>
					  <td align="right">Matrikelnummer:</td>
					  <td>
						<input maxlength="10" name="id" size="25" type="text" />
					  </td>
					</tr>
					<tr>
						<td align="center"> </td>
						<td><input type="submit" value="Eintragen" /><td>
					</tr>
				  </tbody>
				</table>
			</section>
			
		</div>
	  	
	  	<footer>
	  		<ul>
	  			<li>Kontakt</li>
	  			<li>Impresum</li>
	  		</ul>
	  	</footer>
	   
	    
	</body>
</html>