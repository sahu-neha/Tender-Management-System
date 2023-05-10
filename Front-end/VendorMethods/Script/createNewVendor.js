const loginForm = document.getElementById("loginform");
const usernameInput = document.getElementById("Username");
const passwordInput = document.getElementById("Password");
const vendorDiv = document.getElementById("vendor-data");

const displayVendorData = (vendor) => {
	// Create a table to display the vendor data
	const table = document.createElement("table");
	// Create table rows and cells for each vendor property
	const vendorIdRow = document.createElement("tr");
	const vendorIdLabel = document.createElement("td");
	vendorIdLabel.textContent = "Vendor ID:";
	const vendorIdValue = document.createElement("td");
	vendorIdValue.textContent = vendor.vendorId;
	vendorIdRow.appendChild(vendorIdLabel);
	vendorIdRow.appendChild(vendorIdValue);

	const usernameRow = document.createElement("tr");
	const usernameLabel = document.createElement("td");
	usernameLabel.textContent = "Username:";
	const usernameValue = document.createElement("td");
	usernameValue.textContent = vendor.username;
	usernameRow.appendChild(usernameLabel);
	usernameRow.appendChild(usernameValue);

	const passwordRow = document.createElement("tr");
	const passwordLabel = document.createElement("td");
	passwordLabel.textContent = "Password:";
	const passwordValue = document.createElement("td");
	passwordValue.textContent = vendor.password;
	passwordRow.appendChild(passwordLabel);
	passwordRow.appendChild(passwordValue);

	const isActiveRow = document.createElement("tr");
	const isActiveLabel = document.createElement("td");
	isActiveLabel.textContent = "Active:";
	const isActiveValue = document.createElement("td");
	isActiveValue.textContent = vendor.isActive ? "Yes" : "No";
	isActiveRow.appendChild(isActiveLabel);
	isActiveRow.appendChild(isActiveValue);

	const isEligibleRow = document.createElement("tr");
	const isEligibleLabel = document.createElement("td");
	isEligibleLabel.textContent = "Eligible:";
	const isEligibleValue = document.createElement("td");
	isEligibleValue.textContent = vendor.isEligible ? "Yes" : "No";
	isEligibleRow.appendChild(isEligibleLabel);
	isEligibleRow.appendChild(isEligibleValue);

	// Append the rows to the table
	table.appendChild(vendorIdRow);
	table.appendChild(usernameRow);
	table.appendChild(passwordRow);
	table.appendChild(isActiveRow);
	table.appendChild(isEligibleRow);

	// Create a button element that redirects to "homepage.html"
	const homeButton = document.createElement("button");
	homeButton.textContent = "View Vendor Portal";
	homeButton.addEventListener("click", () => {
		window.location.href = "homepage.html";
	});

	// Append the table and button to the vendor div
	vendorDiv.appendChild(table);
	vendorDiv.appendChild(homeButton);

	// Return the table element
	return table;
};

const clearVendorData = () => {
	// Remove all child nodes from the vendor div
	while (vendorDiv.firstChild) {
		vendorDiv.removeChild(vendorDiv.firstChild);
	}
};

loginForm.addEventListener("submit", async (event) => {
	event.preventDefault();

	const username = usernameInput.value;
	const password = passwordInput.value;

	if (username === "" || password === "") {
		swal({
			title: "",
			text: "Please fill in all fields",
			icon: "warning",
		});
		return;
	}

	try {
		const response = await fetch("http://localhost:8080/vendors", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify({ username, password }),
		});

		if (!response.ok) {
			// throw new Error("Failed to create vendor");
			swal({
				title: "",
				text: "Failed to create vendor",
				icon: "error",
			});
			return;
		}

		const vendor = await response.json();
		clearVendorData(); // Clear the vendor div before adding the new record
		loginForm.reset();
		swal({
			title: "",
			text: "Account created successfully!",
			icon: "success",
		});
		displayVendorData(vendor);
	} catch (error) {
		alert(error.message);
	}
});
