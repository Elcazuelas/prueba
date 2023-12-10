function eliminar(id) {
	Swal.fire({
		title: "Está seguro de eliminar esta empresa?",
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
				url: "/eliminarEmpresa/" + id,
				success: function (res) {
					console.log(res);
				}
			});
			Swal.fire({
				title: "Exito!",
				text: "La empresa fue eliminada.",
				icon: "success"
			}).then((ok) => {
				if (ok) {
					location.href = "/administrarEmpresas"
				}
			});
		}
	});
}