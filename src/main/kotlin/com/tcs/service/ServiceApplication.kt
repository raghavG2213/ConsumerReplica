package com.tcs.service

import io.eventuate.tram.spring.consumer.jdbc.TramConsumerJdbcAutoConfiguration
import io.eventuate.tram.spring.optimisticlocking.OptimisticLockingDecoratorConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@EnableAutoConfiguration(exclude = arrayOf(
//		DataSourceAutoConfiguration::class,
		JdbcRepositoriesAutoConfiguration::class,
 TramConsumerJdbcAutoConfiguration::class))
@Import(OptimisticLockingDecoratorConfiguration::class)
class ServiceApplication

fun main(args: Array<String>) {
	runApplication<ServiceApplication>(*args)
}
