function assign() {
	const tenderId = document.getElementById("tenderId").value;
	const vendorId = document.getElementById("vendorId").value;

	if (vendorId == "" || tenderId == "") {
		// alert("Please fill in all fields");
		swal({
			title: "",
			text: "Please fill in all fields",
			icon: "warning",
		});
		return;
	}

	const url = `http://localhost:8080/bid/assign`;

	fetch(url, {
		method: "PUT",
		headers: {
			"Content-Type": "application/json",
			Accept: "application/json",
		},
		body: JSON.stringify({
			tenderId: tenderId,
			vendorId: vendorId,
		}),
	})
		.then((response) => {
			return response.text();
		})
		.then((result) => {
			// alert("Tender assigned to vendor.");
			swal({
				title: "",
				text: "Tender assigned to vendor!",
				icon: "success",
			});
		})
		.catch((error) => {
			// alert(error);
			swal({
				title: "",
				text: "Error!",
				icon: "error",
			});
		});
}
