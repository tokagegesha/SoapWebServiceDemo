package com.gegesha.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.gegesha.demo.soap_web_service.GetPrice;
import com.gegesha.demo.soap_web_service.GetPriceResponse;
import com.gegesha.repository.ItemRepository;


@Endpoint
public class ItemEndpoint {
	
	private static final String NAMESPACE_URI = "http://gegesha.com/demo/soap-web-service";

	private ItemRepository itemRepository;

	@Autowired
	public ItemEndpoint(ItemRepository item) {
		this.itemRepository = item;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPrice")
	@ResponsePayload
	public GetPriceResponse getPrice(@RequestPayload GetPrice request) {
		GetPriceResponse response = new GetPriceResponse();
		response.setPrice(itemRepository.findItem(request.getItem()));
		
		return response;
	}
}
