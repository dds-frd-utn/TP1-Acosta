var id_Cuenta;

$(function(){
	$("#ingresar").click(function(){
		$("#interfaz").hide();
		$("#login").hide();
		$("#interfaz2").show();
		id_Cuenta = $("#idCuenta").val();
	});
});

$(function(){
	$("#saldo").click(function(){
		$.ajax({
		url: "http://localhost:8080/acosta/rest/cuenta/" + id_Cuenta,
			method: "GET",
			success: function(data){
				$("img").remove();
				$("#seleccion").hide();
				$("#consulta").show();
				$("ul").append("<ol>"+"Su saldo es de: "+"</ol>"+"<ol>"+data.saldo+"</ol>");
				
			},
		});
	});
});	

$(function(){
	$("#volver").click(function(){
		$("ol").remove();
		$("#seleccion").show();
		$("#consulta").hide();
		$("#campoExtraccion").hide();
		$("#campoTransferencia").hide();
		$("#campoMovimientos").hide();
	});
});	

$(function(){
	$("#datos").click(function(){
		$.ajax({
			url: "http://localhost:8080/acosta/rest/cliente/" + id_Cuenta,
			method: "GET",
			success: function(data){
				$("img").remove();
				$("#seleccion").hide();
				$("#consulta").show();
				$("ul").append("<ol>"+"Nombre: "+data.nombre+"</ol>"+"<ol>"+"DNI: "+data.dni+"</ol>");
			},

		});
	});
});	

var fecha = '';

//parsear el dato fecha para mostrar solo AÑO-MES-DIA
$.fn.fecha = function(data) {

	fecha = '';
	
	for(var j = 0; j < 10; j++){
		fecha += data.fechaRealizacion[j];
	}

	return fecha
}

//funcion igual para las inversiones, distinto nombre de datoo!! (corregir en BD para usar misma funcion)
$.fn.fechaI = function(data) {

	fecha ='';
	
	for(var j = 0; j < 10; j++){
		fecha += data.fechaCreacion[j];
	}

	return fecha
}

$(function(){
	$("#movimientos").click(function(){
		$("img").remove();
		$("#seleccion").hide();
		$("#consulta").show();
		$("#campoMovimientos").show();
	});
});

$(function(){
	$("#emitidos").click(function(){
		$.ajax({
			url: "http://localhost:8080/acosta/rest/transaccion/emisor/" + id_Cuenta,
			method: "GET",
			success: function(data){
				$("img").remove();
				$("#seleccion").hide();
				$("#campoMovimientos").hide();
				for(var i in data){
					nombreCuenta(data[i].idReceptor);
					$("ul").append(
					$("<ol>"+"Fecha realizacion: "+$.fn.fecha(data[i])+" - Destinatario: "+nombreCliente+" - Monto: "+data[i].monto+"</ol>")
				)};
			},
		});
	});
});	

$(function(){
	$("#recibidos").click(function(){
		$.ajax({
			url: "http://localhost:8080/acosta/rest/transaccion/receptor/" + id_Cuenta,
			method: "GET",
			success: function(data){
				$("img").remove();
				$("#seleccion").hide();
				$("#consulta").show();
				$("#campoMovimientos").hide();
				for(var i in data){
					nombreCuenta(data[i].idEmisor);
					$("ul").append(
					$("<ol>"+"Fecha realizacion: "+$.fn.fecha(data[i])+" - Emisor: "+nombreCliente+" - Monto: "+data[i].monto+"</ol>")
				)};
			},
		});
	});
});	
var nombreCliente = '';

//obtener el nombre del cliente asociado a una cuenta
function nombreCuenta(id){
	$.ajax({
		async:false,
		type:'GET',
		url: 'http://localhost:8080/acosta/rest/cliente/' + id,
		success: function(data) {
			nombreCliente = data.nombre;
		}
	});
};


$(function(){
	$("#extraccion").click(function(){
		$("#seleccion").hide();
		$("#consulta").show();
		$("#campoExtraccion").show();
		$("#volver").show();
	});
});


$(function(){
	$("#retirar").click(function(){
		var saldoActual;
		
		$.ajax({
			url: "http://localhost:8080/acosta/rest/cuenta/" + id_Cuenta,
			async:false,
			method: "GET",
			success: function(data){
				saldoActual = data.saldo;
			}
		});
		
		input_monto = $("#montoExt").val();
		
		var saldoFinal = (saldoActual - input_monto);
		
		let extraccion = {
			"id": id_Cuenta,
			"idCliente": id_Cuenta,
			"saldo": saldoFinal
		};
		
		$.ajax({
			url: 'http://localhost:8080/acosta/rest/cuenta/' + id_Cuenta,
			type: 'put',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(extraccion),
			
			success: function(){
				$("#campoExtraccion").hide();
				$("ul").append(
				"<ol>"+"Extracción exitosa. Por favor, retire sus billetes"+"</ol>");
			}
		});
	});
});


$(function(){
	$("#inversiones").click(function(){
		$.ajax({
			url: "http://localhost:8080/acosta/rest/inversiones/cuenta/" + id_Cuenta,
			method: "GET",
			success: function(data){
				$("img").remove();
				$("#seleccion").hide();
				$("#consulta").show();
				for(var i in data){
					nombreBono(data[i].idBono);
					$("ul").append(
						$("<ol>"+"Fecha creacion: "+$.fn.fechaI(data[i])+"- Nombre Bono: "+nommbre+"</ol>")
				)};
				$("#volver").show();
			},
		});
	});
});

var nommbre = '';

//obtener el nombre (string) de un bono asociado a una inversion
function nombreBono(id){
	$.ajax({
		async:false,
		type:'GET',
		url: 'http://localhost:8080/acosta/rest/bonos/' + id,
		success: function(data) {
			nommbre = data.nombre;
		}
	});
};

$(function(){
	$("#transferencia").click(function(){
		$("#seleccion").hide();
		$("#consulta").show();
		$("#campoTransferencia").show();
		$("#volver").show();
	});
});

$(function(){
	$("#confirmarTrans").click(function(){
		var saldoEmisor;
		var saldoReceptor;
		
		$.ajax({
			url: "http://localhost:8080/acosta/rest/cuenta/" + id_Cuenta,
			async:false,
			method: "GET",
			success: function(data){
				saldoEmisor = data.saldo;
			}
		});
		
		input_cuentaDestino = $("#destinatario").val();
		
		$.ajax({
			url: "http://localhost:8080/acosta/rest/cuenta/" + input_cuentaDestino,
			async:false,
			method: "GET",
			success: function(data){
				saldoReceptor = data.saldo;
			}
		});
		
		input_monto = $("#montoTransferencia").val();
		
		var saldoFinalEmisor = (saldoEmisor - input_monto);
		var saldoFinalReceptor = (saldoReceptor - (- input_monto));
		
		crearTransaccion(id_Cuenta,input_cuentaDestino);
		
		let cuentaEmisora = {
			"id": id_Cuenta,
			"idCliente": id_Cuenta,
			"saldo": saldoFinalEmisor
		};
		
		$.ajax({
			url: 'http://localhost:8080/acosta/rest/cuenta/' + id_Cuenta,
			type: 'put',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(cuentaEmisora),
		});
		
		let cuentaReceptora = {
			"id": input_cuentaDestino,
			"idCliente": input_cuentaDestino,
			"saldo": saldoFinalReceptor
		}
		
		$.ajax({
			url: 'http://localhost:8080/acosta/rest/cuenta/' + input_cuentaDestino,
			type: 'put',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(cuentaReceptora),
		});
	});
});


function crearTransaccion(emisor,receptor,monto){
	
		let infoTransaccion = {
			"estado": "realizado",
			"fechaRealizacion" : "Date.now()",
			"idEmisor": emisor,
			"idReceptor": receptor,
			"monto": monto
		}

		$.ajax({
			url: 'http://localhost:8080/acosta/rest/transaccion/',
			type: 'post',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(infoTransaccion),
			
			success: function(){
				$("#campoTransferencia").hide();
				$("ul").append("<ol>"+"Transacción exitosa"+"</ol>");
			}
		});
};

