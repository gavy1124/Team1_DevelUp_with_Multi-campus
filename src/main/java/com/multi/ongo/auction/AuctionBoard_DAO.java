package com.multi.ongo.auction;

import java.util.List;

public interface AuctionBoard_DAO {
	
	//중고거래?���?
	public int writeProd(AuctionBoard_DTO dto);
	 
	//중고거래 ?��체조?��
	public List<AuctionBoard_DTO> boardlist();
	
	//중고거래 게시�??���?
	public AuctionBoard_DTO auctionRead(int auction_number);

	
	//중고거래 게시�? ?��?��?��?��(?��?��)
	int update(AuctionBoard_DTO dto);
	
	
	//중고거래 게시�? ?��?��
	int auctionDelete(String id);
}