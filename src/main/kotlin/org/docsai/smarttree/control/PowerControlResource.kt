package org.docsai.smarttree.control

import org.docsai.smarttree.config.MQTTConfig
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/power")
class PowerControlResource(val mqttGateway: MQTTConfig.MQTTGateway) {

    @PostMapping("/{state}")
    fun onOff(@PathVariable("state") powerState: String): String {
        mqttGateway.publish("power", powerState)
        return powerState
    }
}