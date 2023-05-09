function deactivate() {
	const vendorId = document.getElementById("vendorId").value;

	if (vendorId == "") {
		// alert("Please fill in all fields");
		swal({
			title: "",
			text: "Please enter a vendor ID",
			icon: "warning",
		});
		return;
	}

	const url = `http://localhost:8080/deactivateVendor/${vendorId}`;

	fetch(url, {
		method: "PATCH",
	})
		.then((response) => response.text())
		.then((result) => {
			// alert("Vendor deactivated.");
			swal({
				title: "",
				text: "Vendor deactivated!",
				icon: "success",
			});
		})
		.catch((error) => {
			// alert(error);
			swal({
				title: "",
				text: "Vendor could not be deactivated.",
				icon: "error",
			});
		});
}
