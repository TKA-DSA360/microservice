package com.jbk.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

	@GetMapping("/users/exists/{uid}")
	Boolean isUserExists(@PathVariable("uid") Long userId);

}
