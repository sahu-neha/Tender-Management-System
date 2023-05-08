function assign() {
	const tenderId = document.getElementById("tenderId").value;
	const vendorId = document.getElementById("vendorId").value;

	const url = `http://localhost:8080/bid/assign`;

	fetch(url, {
		method: "PUT",
		body: JSON.stringify({
			tenderId: tenderId,
			vendorId: vendorId
		})
	})
		.then((response) => response.text())
		.then((result) => {
			alert(result);
		})
		.catch((error) => {
			alert(error);
		});
}
