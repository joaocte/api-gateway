package br.com.curso.api

import io.micronaut.context.annotation.Factory
import io.micronaut.http.client.LoadBalancer
import io.micronaut.http.client.loadbalance.DiscoveryClientLoadBalancerFactory
import jakarta.inject.Singleton
import java.util.*
import java.util.function.Consumer

@Factory
class GatewayLoadBalancersFactory {
    @Singleton
    fun serviceLoadBalancers(
        gatewayProperties: GatewayProperties,
        factory: DiscoveryClientLoadBalancerFactory,
    ): Map<String, LoadBalancer> {
        val services = gatewayProperties.services
        val loadBalancers: MutableMap<String, LoadBalancer> = HashMap()
        services!!.forEach(Consumer { serviceName: String ->
            loadBalancers[serviceName] = factory.create(serviceName)
        })
        return Collections.unmodifiableMap(loadBalancers)
    }
}