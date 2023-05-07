package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

	List<Bid> findByVendor(Integer vendorId);

	List<Bid> findByTender(Integer tenderId);

	/**
	 * This method retrieves the bid history of a vendor by vendorId.
	 *
	 * @param vendorId The vendorId of the vendor whose bid history is to be
	 *                 retrieved
	 * @return A ResponseEntity object containing the list of bids made by the
	 *         vendor and HTTP status code OK
	 * @Author HoshiyarJyani
	 */
	@Query("SELECT v.bidList FROM Vendor v WHERE v.vendorId = :vendorId")
	public List<Bid> findBidHistoryByVendorId(@Param("vendorId") Integer vendorId);

	/**
	 * This method retrieves the bid history of a Tender by TenderId.
	 *
	 * @param tenderId The tenderId of the tender whose bid history is to be
	 *                 retrieved
	 * @return A ResponseEntity object containing the list of bids made by the
	 *         vendor and HTTP status code OK
	 * @Author HoshiyarJyani
	 */
	@Query("SELECT t.bidList FROM Tender t WHERE t.tenderId = :tenderId")
	public List<Bid> findBidHistoryByTenderId(@Param("tenderId") Integer tenderId);

}
