function viewBids() {
	const tenderId = document.getElementById("tenderId").value;

	const url = `http://localhost:8080/tenders/bid/${tenderId}`;

	fetch(url, {
		method: "GET",
	})
		.then((response) => response.text())
		.then((result) => {
			alert(result);
			// const bids = JSON.parse(result);
			// console.log(bids);
			// const table = document.getElementById("bidsTable");
			// table.innerHTML = "";
			// const header = document.createElement("tr");

			// const bidIdHeader = document.createElement("th");
			// bidIdHeader.textContent = "Bid ID";
			// header.appendChild(bidIdHeader);

			// const vendorIdHeader = document.createElement("th");
			// vendorIdHeader.textContent = "Vendor ID";
			// header.appendChild(vendorIdHeader);

			// const vendorNameHeader = document.createElement("th");
			// vendorNameHeader.textContent = "Vendor Name";
			// header.appendChild(vendorNameHeader);

			// const bidPriceHeader = document.createElement("th");
			// bidPriceHeader.textContent = "Bid Price";
			// header.appendChild(bidPriceHeader);

			// const bidDateHeader = document.createElement("th");
			// bidDateHeader.textContent = "Bid Date";
			// header.appendChild(bidDateHeader);

			// const statusHeader = document.createElement("th");
			// statusHeader.textContent = "Status";
			// header.appendChild(statusHeader);

			// table.appendChild(header);

			// bids.forEach((bid) => {
			// 	const row = document.createElement("tr");

			// 	const bidId = document.createElement("td");
			// 	bidId.textContent = bid.bidId;
			// 	row.appendChild(bidId);

			// 	const vendorId = document.createElement("td");
			// 	vendorId.textContent = bid.vendorId;
			// 	row.appendChild(vendorId);

			// 	const vendorName = document.createElement("td");
			// 	vendorName.textContent = bid.vendorName;
			// 	row.appendChild(vendorName);

			// 	const bidPrice = document.createElement("td");
			// 	bidPrice.textContent = bid.bidPrice;
			// 	row.appendChild(bidPrice);

			// 	const bidDate = document.createElement("td");
			// 	bidDate.textContent = bid.bidDate;
			// 	row.appendChild(bidDate);

			// 	const status = document.createElement("td");
			// 	status.textContent = bid.status;
			// 	row.appendChild(status);

			// 	table.appendChild(row);
			// });
		})
		.catch((error) => {
			alert(error);
		});
}
