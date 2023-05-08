function deactivate() {
	const vendorId = document.getElementById("vendorId").value;

	const url = `http://localhost:8080/banVendorFromBidding/${vendorId}`;

	fetch(url, {
		method: "PATCH",
	})
		.then((response) => response.text())
		.then((result) => {
			alert("Vendor banned from bidding.");
		})
		.catch((error) => {
			alert(error);
		});
}
