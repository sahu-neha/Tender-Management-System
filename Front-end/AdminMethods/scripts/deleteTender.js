function deactivate() {
	const tenderId = document.getElementById("tenderId").value;

	const url = `http://localhost:8080/tenders/${tenderId}`;

	fetch(url, {
		method: "DELETE",
	})
		.then((response) => response.text())
		.then((result) => {
			alert(result);
		})
		.catch((error) => {
			alert(error);
		});
}
