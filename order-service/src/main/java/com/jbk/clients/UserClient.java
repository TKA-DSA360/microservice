package com.jbk.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE", fallback = UserClientFallback.class)
public interface UserClient {

	@GetMapping("/users/exists/{userId}")
	Boolean isUserExists(@PathVariable long userId);
}
