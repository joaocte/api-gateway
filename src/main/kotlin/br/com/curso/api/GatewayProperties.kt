package br.com.curso.api

import io.micronaut.context.annotation.ConfigurationProperties


@ConfigurationProperties("gateway")
data class GatewayProperties(var services: Set<String>)