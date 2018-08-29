package com.prosoccer.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class HealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		//TODO: implementar esto para cuando hay error
		return Health.up().build();
	}
}
