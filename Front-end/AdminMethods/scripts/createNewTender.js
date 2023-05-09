// let input = document.querySelectorAll("#form form input");

// input.forEach((input) => {
// 	input.setAttribute("size", input.getAttribute("placeholder").length-8);
// });

const adminForm = document.getElementById("adminForm");
const title = document.getElementById("titleTender");
const description = document.getElementById("description");
const image = document.getElementById("image");
const creationDate = document.getElementById("creationDate");
const durationInDays = document.getElementById("durationInDays");
const tenderPrice = document.getElementById("tenderPrice");
const tenderDiv = document.getElementById("tender-data");

const displayTenderData = (tender) => {
	swal({
		title: "",
		text: "Tender created successfully!",
		icon: "success",
	});

	// Create a table to display the tender data
	const table = document.createElement("table");

	// Create table rows and cells for each tender property
	const tenderIdRow = document.createElement("tr");
	const tenderIdLabel = document.createElement("td");
	tenderIdLabel.textContent = "tender ID:";
	const tenderIdValue = document.createElement("td");
	tenderIdValue.textContent = tender.tenderId;
	tenderIdRow.appendChild(tenderIdLabel);
	tenderIdRow.appendChild(tenderIdValue);

	const titleRow = document.createElement("tr");
	const titleLabel = document.createElement("td");
	titleLabel.textContent = "title:";
	const titleValue = document.createElement("td");
	titleValue.textContent = tender.title;
	titleRow.appendChild(titleLabel);
	titleRow.appendChild(titleValue);

	const descriptionRow = document.createElement("tr");
	const descriptionLabel = document.createElement("td");
	descriptionLabel.textContent = "description:";
	const descriptionValue = document.createElement("td");
	descriptionValue.textContent = tender.description;
	descriptionRow.appendChild(descriptionLabel);
	descriptionRow.appendChild(descriptionValue);

	const imageRow = document.createElement("tr");
	const imageLabel = document.createElement("td");
	imageLabel.textContent = "Image:";
	const imageValue = document.createElement("td");
	const imageT = document.createElement("img");
	imageT.src = tender.image;
	imageT.alt = tender.title;
	imageRow.appendChild(imageLabel);
	imageRow.appendChild(imageT);

	const creationDateRow = document.createElement("tr");
	const creationDateLabel = document.createElement("td");
	creationDateLabel.textContent = "Creation Date:";
	const creationDateValue = document.createElement("td");
	creationDateValue.textContent = tender.creationDate;
	creationDateRow.appendChild(creationDateLabel);
	creationDateRow.appendChild(creationDateValue);

	const durationInDaysRow = document.createElement("tr");
	const durationInDaysLabel = document.createElement("td");
	durationInDaysLabel.textContent = "Duration In Days:";
	const durationInDaysValue = document.createElement("td");
	durationInDaysValue.textContent = tender.durationInDays;
	durationInDaysRow.appendChild(durationInDaysLabel);
	durationInDaysRow.appendChild(durationInDaysValue);

	const tenderPriceRow = document.createElement("tr");
	const tenderPriceLabel = document.createElement("td");
	tenderPriceLabel.textContent = "Tender Price:";
	const tenderPriceValue = document.createElement("td");
	tenderPriceValue.textContent = tender.tenderPrice;
	tenderPriceRow.appendChild(tenderPriceLabel);
	tenderPriceRow.appendChild(tenderPriceValue);

	const statusRow = document.createElement("tr");
	const statusLabel = document.createElement("td");
	statusLabel.textContent = "Status:";
	const statusValue = document.createElement("td");
	statusValue.textContent = tender.status;
	statusRow.appendChild(statusLabel);
	statusRow.appendChild(statusValue);

	const assignedVendorRow = document.createElement("tr");
	const assignedVendorLabel = document.createElement("td");
	assignedVendorLabel.textContent = "Assigned Vendor:";
	const assignedVendorValue = document.createElement("td");
	assignedVendorValue.textContent = tender.assignedVendor
		? tender.assignedVendor.vendorId
		: "N/A";
	assignedVendorRow.appendChild(assignedVendorLabel);
	assignedVendorRow.appendChild(assignedVendorValue);

	// Append the rows to the table
	table.appendChild(tenderIdRow);
	table.appendChild(titleRow);
	table.appendChild(descriptionRow);
	table.appendChild(imageRow);
	table.appendChild(creationDateRow);
	table.appendChild(durationInDaysRow);
	table.appendChild(tenderPriceRow);
	table.appendChild(statusRow);
	table.appendChild(assignedVendorRow);

	// Append the table to the tender div
	tenderDiv.appendChild(table);
};

adminForm.addEventListener("submit", async (event) => {
	event.preventDefault();

	let obj = {
		title: document.getElementById("titleTender").value,
		description: document.getElementById("description").value,
		image: document.getElementById("image").value,
		creationDate: document.getElementById("creationDate").value,
		durationInDays: document.getElementById("durationInDays").value,
		tenderPrice: document.getElementById("tenderPrice").value,
	};

	try {
		const response = await fetch("http://localhost:8080/tenders", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(obj),
		});

		console.log(response);

		const tender = await response.json();
		swal({
			title: "",
			text: "Tender created successfully",
			icon: "success",
		});
		displayTenderData(tender);
	} catch (error) {
		// alert(error.message);
		swal({
			title: "",
			text: "Tender creation failed",
			icon: "error",
		});
	}

	adminForm.reset();
});
