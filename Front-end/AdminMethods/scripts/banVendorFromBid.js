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

	const url = `http://localhost:8080/banVendorFromBidding/${vendorId}`;

	fetch(url, {
		method: "PATCH",
	})
		.then((response) => response.text())
		.then((result) => {
			// alert("Vendor banned from bidding.");
			swal({
				title: "",
				text: "Vendor banned from bidding!",
				icon: "success",
			});
		})
		.catch((error) => {
			// alert(error);
			swal({
				title: "",
				text: "Vendor could not be banned.",
				icon: "error",
			});
		});
}
