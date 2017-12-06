package org.docsai.smarttree.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.MessagingGateway
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory
import org.springframework.integration.mqtt.core.MqttPahoClientFactory
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler
import org.springframework.integration.mqtt.support.MqttHeaders
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload


@Configuration
class MQTTConfig {

    @Bean
    fun mqttClientFactory(@Value("\${smart_tree.mqtt.host}") host: String): MqttPahoClientFactory {
        val factory = DefaultMqttPahoClientFactory()
        factory.setServerURIs(host)
        return factory
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    fun mqttOutbound(mqttClientFactory: MqttPahoClientFactory): MessageHandler {
        val messageHandler = MqttPahoMessageHandler("Pi", mqttClientFactory)
        messageHandler.setDefaultTopic("default")
        return messageHandler
    }

    @Bean
    fun mqttOutboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
    interface MQTTGateway {

        fun publish(@Header(MqttHeaders.TOPIC) topic: String, @Payload data: String)

    }
}