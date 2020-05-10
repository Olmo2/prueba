var visible = false;

$(".menu-toggle").click(function(e) {

	e.preventDefault();
	$("#wrapper").toggleClass("toggled");
	visible = !visible;
});

$("#page-body").click(function() {
	if (visible) {
		visible = false;
		$("#wrapper").toggleClass("toggled");
	}

});

$("#editarJuego").on("show.bs.modal", function(event) {
	var button = $(event.relatedTarget) // Button that triggered the modal
	var nombre = button.data("nombre") // Extract info from data-* attributes
	var id = button.data("id");
	var pegi = button.data("pegi");
	var plat = button.data("plat");
	var anio = button.data("anio");
	alert(plat);
	// If necessary, you could initiate an AJAX request here (and then do the
	// updating in a callback).
	// Update the modal's content. We'll use jQuery here, but you could use a
	// data binding library or other methods instead.
	var modal = $(this)
	modal.find(".modal-title").text("Editar Juego: " + nombre)
	modal.find(".modal-body #ID").val(id);
	modal.find(".modal-body #nombre").val(nombre);
	modal.find(".modal-body #pegi").val(pegi);
	modal.find(".modal-body #anio").val(anio);
	modal.find(".modal-body #" + plat).attr("name","plat.id");


});

// validacion del formulario
function validateForm() {
	var pegi = document.forms["editar"]["pegi"].value;
	var anio = document.forms["editar"]["anio"].value;
	var regpegi= /(3|7|12|16|18)/g
	var reganio = /^(19|20)\d{2}$/g
	var error=0;
		if (pegi<19 && regpegi.test(pegi)) {
			document.getElementById("spegi").innerHTML = "";
		} else {
			document.getElementById("spegi").innerHTML = "Introduce un código pegi válido: 3,7,12,16 ó 18";
			error++;
		}
		if (reganio.test(anio)) {
			document.getElementById("sanio").innerHTML = "";
		} else {
			document.getElementById("sanio").innerHTML = "Introduce un año con formato 'YYYY', del siglo 20 o 21 ";
			error++;
		}
		 
		if(error>0){
			return false
		}else{
			return true;
		}
		
}
