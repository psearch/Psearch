<%@page import="java.sql.SQLException"%>
<%@page import="banco.BD"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<meta Http-Equiv="Cache-Control" Content="no-cache">
<meta Http-Equiv="Pragma" Content="no-cache">
<meta Http-Equiv="Expires" Content="0">

<title>PSearch</title>

<style type="text/css">
<%@include file="_css/map.css" %>
</Style>


<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDfmXMCQ3dfJKd_wAKe4Gh0_JmgJNKD_EY&sensor=SET_FALSE"></script>

<script>


function scrool() {
    document.getElementById("ranking").style.overflow = "scroll";
}





	function rodar() {
		document.f.oculto.value = document.f.pro.value;
	}

	var geocoder;
	var map;

	function initialize() {
		var styles = [ {
			stylers : [ {
				hue : "#000099"
			}, {
				saturation : -30
			} ]
		}, {
			featureType : "road",
			elementType : "geometry",
			stylers : [ {
				lightness : 100
			}, {
				visibility : "simplified"
			} ]
		}, {
			featureType : "road",
			elementType : "labels",
			stylers : [ {
				visibility : "on"
			} ]
		} ];

		var styledMap = new google.maps.StyledMapType(styles, {
			name : "Styled Map"
		});

		geocoder = new google.maps.Geocoder();
		var latlng = new google.maps.LatLng(-34.397, 150.644);

		var mapOptions = {
			zoom : 16,

			center : new google.maps.LatLng(-23.5505199, -46.63330939999997),

		};

		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
		map.mapTypes.set('map_style', styledMap);
		map.setMapTypeId('map_style');
	}

	function codeAddress() {

		var address = document.getElementById('address').value;
		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				map.setCenter(results[0].geometry.location);

				marker = new google.maps.Marker({
					icon : "_img/iconuser.png",
					map : map,
					animation : google.maps.Animation.DROP,
					position : results[0].geometry.location

				});

				google.maps.event.addListener(marker, 'click', function() {
					infowindow.open(map, marker);
				});

			}

			else {
				alert('Erro ao obter coordenadas ' + status + geocoder);
			}
		});

	}
	function loadXMLFile() {
		var filename = 'pontos.xml';
		$.ajax({
			type : "GET",
			url : filename,
			dataType : "xml",
			success : parseXML,
			error : onXMLLoadFailed
		});

		function onXMLLoadFailed() {
			alert("Ocorreu um erro durante a execução");
		}

		function parseXML(xml) {
			var markers = [];

			var latlngbounds = new google.maps.LatLngBounds();
			var bounds = new google.maps.LatLngBounds();
			$(xml)
					.find("ocorrencia")
					.each(
							function() {

								var nme = $(this).find('Name').text();

								var lat = $(this).find('Latitude').text();
								var lng = $(this).find('Longitude').text();
								var markerCoords = new google.maps.LatLng(
										parseFloat(lat), parseFloat(lng));
								var rua = $(this).find('endereco').text();
								
								var email = $(this).find('mail').text();

								var tel = $(this).find('telefone').text();
								
								
								var contentString = '<div  id="content"> <table></tr></td><tr><td  linhaspan="6"></tr></td>'
										+ '<tr><td>Nome: '
										+ nme
										+ '</td></tr><tr><td>Endereço: '
										+ rua
										+ '</td></tr><tr><td>Email:'+email
										+ '</tr></td>'
										+ '</td></tr><tr><td>Telefone :'+tel
										+ '</tr></td><tr><td></table>';

								var infowindow = new google.maps.InfoWindow({
									content : contentString,

								});

								var marker = new google.maps.Marker({

									animation : google.maps.Animation.DROP,
									position : markerCoords,
									title : nme,
									icon : "_img/proficon.png",

									map : map

								});

								google.maps.event.addListener(marker, 'click',
										function() {
											infowindow.open(map, marker);

										});

								map.setCenter(markerCoords);

							});

		}

		function setDescPro() {

		}

	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body  onload="loadXMLFile();scrool()">


	<header id="panel">

		<input id="address" class="inputs" type="textbox"> <input type="submit"
			value="Minha Localização" onclick="codeAddress()">



		 <form action="maps.jsp" method="get" name="f">
			<input  style="visibility: hidden" type="text" name="oculto">
			
			<select style="visibility: hidden" name="pro"
				onchange="rodar()">
				<option value="ola mundo">Selecione uma profissão</option>


				<%/*
					BD bd = new BD();
					bd.getConnection();
					String sql = "select descricao from categoria_prof ";
					bd.st = bd.con.prepareStatement(sql);
					bd.rs = bd.st.executeQuery();
					while (bd.rs.next()) {

						out.println("<option value=" + bd.rs.getString("descricao")
								+ ">" + bd.rs.getString("descricao") + "</option>");
					}
				*/%>
			
			

			</select>
		</form>
		
	
		</header>
			<input style="visibility: hidden" action="map.jsp" method="get" type='submit'
			value="localizar profissionais" onclick="loadXMLFile()">


	


        
        	<div  class="table"  id="ranking">
                <table >
                <tbody >
                    <tr >
                        <td id="titulo">
                          Ranking
                        </td>
                    </tr>
                    
                    <tr>
                        <td >
                            linha 1
                        </td>
                    </tr>
                    <tr>
              
                        <td>
                            linha 2
                        </td>
                    </tr>
                    <tr>
                       
                        <td>
                            linha 2
                        </td>
                    </tr>
                    <tr>
                      
                        <td>
                            linha 3
                        </td>
                    </tr>
                    <tr>
                       
                        <td>
                            linha 4
                        </td>
                    </tr>
                    <tr>
                       
                        <td>
                            linha5
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha6
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha7
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha8
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha9
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha10
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha10
                        </td>
                    </tr>
                    <tr >
                        <td id="titulo">
                           Top 10
                        </td>
                    </tr>
                    
                    <tr>
                        <td >
                            linha 1
                        </td>
                    </tr>
                    <tr>
              
                        <td>
                            linha 2
                        </td>
                    </tr>
                    <tr>
                       
                        <td>
                            linha 2
                        </td>
                    </tr>
                    <tr>
                      
                        <td>
                            linha 3
                        </td>
                    </tr>
                    <tr>
                       
                        <td>
                            linha 4
                        </td>
                    </tr>
                    <tr>
                       
                        <td>
                            linha5
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha6
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha7
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha8
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha9
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha10
                        </td>
                    </tr>
                     <tr>
                       
                        <td>
                            linha10
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        
        
   
	<div id="map-canvas">

</div>
</body>
</html>

