const showTendersButton = document.querySelector("#showTendersButton");
const tendersTable = document.querySelector("#tendersTable tbody");

showTendersButton.addEventListener("click", () => {
	fetch("http://localhost:8080/tenders")
		.then((response) => {
			if (response.ok) {
				return response.json();
			} else {
				// throw new Error("Failed to retrieve tenders");
				swal({
					title: "",
					text: "Failed to retrieve tenders",
					icon: "error",
				});
				return;
			}
		})
		.then((tenders) => {
			swal({
				title: "",
				text: "Tenders retrieved successfully!",
				icon: "success",
			});

			tendersTable.innerHTML = "";

			tenders.forEach((tender) => {
				const row = document.createElement("tr");

				const tenderIdCell = document.createElement("td");
				tenderIdCell.textContent = tender.tenderId;
				row.appendChild(tenderIdCell);

				const titleCell = document.createElement("td");
				titleCell.textContent = tender.title;
				row.appendChild(titleCell);

				const descriptionCell = document.createElement("td");
				descriptionCell.textContent = tender.description;
				row.appendChild(descriptionCell);

				const imageCell = document.createElement("td");
				const image = document.createElement("img");
				image.src = tender.image;
				image.alt = tender.title;
				imageCell.appendChild(image);
				row.appendChild(imageCell);

				const creationDateCell = document.createElement("td");
				creationDateCell.textContent = tender.creationDate;
				row.appendChild(creationDateCell);

				const durationInDaysCell = document.createElement("td");
				durationInDaysCell.textContent = tender.durationInDays;
				row.appendChild(durationInDaysCell);

				const tenderPriceCell = document.createElement("td");
				tenderPriceCell.textContent = tender.tenderPrice;
				row.appendChild(tenderPriceCell);

				const assignedVendorCell = document.createElement("td");
				assignedVendorCell.textContent = tender.assignedVendor?.vendorId
					? tender.assignedVendor.vendorId
					: "Not assigned";
				row.appendChild(assignedVendorCell);

				tendersTable.appendChild(row);
			});
		})
		.catch((error) => {
			console.error(error);
			// alert("Failed to retrieve tenders");
			swal({
				title: "",
				text: "Failed to retrieve tenders",
				icon: "error",
			});
		});
});
