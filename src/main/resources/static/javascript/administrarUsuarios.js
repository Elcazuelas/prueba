function eliminar(id) {
	Swal.fire({
		title: "Está seguro de eliminar este usuario?",
		text: "No se puede anular esta acción!",
		icon: "warning",
		showCancelButton: true,
		confirmButtonColor: "#3085d6",
		cancelButtonColor: "#d33",
		confirmButtonText: "Si, eliminar!",
		cancelButtonText: "Cancelar"
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				url: "/eliminar/" + id,
				success: function (res) {
					console.log(res);
				}
			});
			Swal.fire({
				title: "Exito!",
				text: "El usuario fue eliminado.",
				icon: "success"
			}).then((ok) => {
				if (ok) {
					location.href = "/admin"
				}
			});
		}
	});
}