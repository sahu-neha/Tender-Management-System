const showVendorsButton = document.querySelector("#showVendorsButton");
const vendorsTable = document.querySelector("#vendorsTable tbody");

showVendorsButton.addEventListener("click", () => {
	fetch("http://localhost:8080/activeVendors")
		.then((response) => {
			if (response.ok) {
				return response.json();
			} else {
				throw new Error("Failed to retrieve vendors");
			}
		})
		.then((vendors) => {
			vendorsTable.innerHTML = "";

			vendors.forEach((vendor) => {
				const row = document.createElement("tr");

				const vendorIdCell = document.createElement("td");
				vendorIdCell.textContent = vendor.vendorId;
				row.appendChild(vendorIdCell);

				const usernameCell = document.createElement("td");
				usernameCell.textContent = vendor.username;
				row.appendChild(usernameCell);

				const isActiveCell = document.createElement("td");
				isActiveCell.textContent = vendor.isActive ? "Yes" : "No";
				row.appendChild(isActiveCell);

				const isEligibleCell = document.createElement("td");
				isEligibleCell.textContent = vendor.isEligible ? "Yes" : "No";
				row.appendChild(isEligibleCell);

				// const tenderListCell = document.createElement("td");
				// let tenderList = vendor.tenderList;
				// let tenderListString = "";
				// tenderList.forEach((tender) => {
				// 	tenderListString += tender.tenderId + ", ";
				// });
				// tenderListCell.textContent = tenderListString;
				// row.appendChild(tenderListCell);

				vendorsTable.appendChild(row);
			});
		})
		.catch((error) => {
			console.error(error);
			alert("Failed to retrieve vendors");
		});
});
