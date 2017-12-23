package org.docsai.smarttree.control

import org.docsai.smarttree.config.MQTTConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pattern")
class PatternControlResource(val mqttGateway: MQTTConfig.MQTTGateway) {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(this.javaClass)
    }

    @PostMapping("/{pattern}")
    fun setPattern(@PathVariable("pattern") pattern: String): String {
        LOG.info("setPattern: $pattern")
        mqttGateway.publish("pattern", pattern)
        return pattern
    }
}