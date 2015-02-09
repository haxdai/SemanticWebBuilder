<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title>Aplic. Web de jQuery Mobile</title>
<link href="jquery-mobile/jquery.mobile-1.3.0.min.css" rel="stylesheet" type="text/css"/>
<script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="jquery-mobile/jquery.mobile-1.3.0.min.js" type="text/javascript"></script>
<script>
  $(document).ready(function(e) {
    $.get('data.txt',function(data){
      $('#data-container').html(data);		    
    });
}); 
</script>
<style>
#data-container{
	font-size:10px;
	color:#C30;
	}
</style>
</head> 
<body> 

<div data-role="page" id="page">
	<div data-role="header">
	  <h1>Inicio</h1>
	</div>
	<div data-role="content">	
		<ul data-role="listview">
			<li><a href="#page2">Quienes Somos</a></li>
            <li><a href="#page3">Contactanos</a></li>
			<li><a href="#page4">Mi Página</a></li>
		</ul>		
	</div>
	<div data-role="footer">
		<h4>Jajs Software All CopyRights &copy;</h4>
	</div>
</div>

<div data-role="page" id="page2">
	<div data-role="header">
        <a href="#page" data-icon="back" data-iconpos="notext">Regresar</a>
		<h1>Quienes Somos?</h1>
	</div>
	<div id="data-container" data-role="content">	
		Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum	
        <a href="#page3" data-role="button">Contactanos</a>	
	</div>
	<div data-role="footer">
		<h4>Infotec-Jajs Software All CopyRights &copy;</h4>
	</div>
</div>

<div data-role="page" id="page3">
	<div data-role="header">
        <a href="#page" data-icon="back" data-iconpos="notext">Regresar</a>
		<h1>Contáctame</h1>
	</div>
	<div data-role="content">	
		Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum		
        <a href="#page2" data-role="button">Quienes Somos</a>	
	</div>
	<div data-role="footer">
		<h4>Infotec-Jajs Software All CopyRights &copy;</h4>
	</div>
</div>

<div data-role="page" id="page4">
	<div data-role="header">
        <a href="#page" data-icon="back" data-iconpos="notext">Regresar</a>
		<h1>Página cuatro</h1>
	</div>
	<div data-role="content">	
		Hola Mundo, Esroy en la mi Página	
        <a href="#page" data-role="button">Inicio</a	
	></div>
	<div data-role="footer">
		<h4>Infotec-Jajs Software All CopyRights &copy;</h4>
	</div>
</div>

</body>
</html>
