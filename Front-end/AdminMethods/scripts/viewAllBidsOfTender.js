function viewBids() {
	const tenderId = document.getElementById("tenderId").value;

	if (tenderId == "") {
		// alert("Please enter a tender ID");
		swal({
			title: "",
			text: "Please enter a tender ID",
			icon: "warning",
		});
		return;
	}

	const url = `http://localhost:8080/tenders/bid/${tenderId}`;

	fetch(url, {
		method: "GET",
	})
		.then((response) => response.text())
		.then((result) => {
			// alert(result);
			swal({
				title: "",
				text: "Bids retrieved successfully!",
				icon: "success",
			});

			const bids = JSON.parse(result);
			console.log(bids);
			const table = document.getElementById("bid-list");
			table.innerHTML = "";
			const header = document.createElement("tr");

			const bidIdHeader = document.createElement("th");
			bidIdHeader.textContent = "Bid ID";
			header.appendChild(bidIdHeader);

			const tenderIdHeader = document.createElement("th");
			tenderIdHeader.textContent = "Tender ID";
			header.appendChild(tenderIdHeader);

			const tenderTitleHeader = document.createElement("th");
			tenderTitleHeader.textContent = "Tender Title";
			header.appendChild(tenderTitleHeader);

			const vendorIdHeader = document.createElement("th");
			vendorIdHeader.textContent = "Vendor ID";
			header.appendChild(vendorIdHeader);

			const vendorNameHeader = document.createElement("th");
			vendorNameHeader.textContent = "Vendor Name";
			header.appendChild(vendorNameHeader);

			const bidPriceHeader = document.createElement("th");
			bidPriceHeader.textContent = "Bid Price";
			header.appendChild(bidPriceHeader);

			const bidDateHeader = document.createElement("th");
			bidDateHeader.textContent = "Duration in Days";
			header.appendChild(bidDateHeader);

			const statusHeader = document.createElement("th");
			statusHeader.textContent = "Status";
			header.appendChild(statusHeader);

			table.appendChild(header);

			if (bids.size == 0) {
				// alert("No bids found for the given tender ID");
				swal({
					title: "",
					text: "No bids found for the given tender ID",
					icon: "error",
				});
				return;
			}

			bids.forEach((bid) => {
				const row = document.createElement("tr");

				const bidId = document.createElement("td");
				bidId.textContent = bid.id;
				row.appendChild(bidId);

				const tenderId = document.createElement("td");
				tenderId.textContent = bid.tender.tenderId;
				row.appendChild(tenderId);

				const tenderTitle = document.createElement("td");
				tenderTitle.textContent = bid.tender.title;
				row.appendChild(tenderTitle);

				const vendorId = document.createElement("td");
				vendorId.textContent = bid.vendor.vendorId;
				row.appendChild(vendorId);

				const vendorName = document.createElement("td");
				vendorName.textContent = bid.vendor.username;
				row.appendChild(vendorName);

				const bidPrice = document.createElement("td");
				bidPrice.textContent = bid.bidAmount;
				row.appendChild(bidPrice);

				const bidDate = document.createElement("td");
				bidDate.textContent = bid.durationInDays;
				row.appendChild(bidDate);

				const status = document.createElement("td");
				status.textContent = bid.bidStatus;
				row.appendChild(status);

				table.appendChild(row);
			});
		})
		.catch((error) => {
			swal({
				title: "",
				text: "No bids found for the given tender ID",
				icon: "error",
			});
			// alert("No bids found for the given tender ID");
		});
}
