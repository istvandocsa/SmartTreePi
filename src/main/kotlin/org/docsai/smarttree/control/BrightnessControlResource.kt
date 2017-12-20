package org.docsai.smarttree.control

import org.docsai.smarttree.config.MQTTConfig
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/brightness")
class BrightnessControlResource(val mqttGateway: MQTTConfig.MQTTGateway) {

    @PostMapping("/{brightness}")
    fun onOff(@PathVariable("brightness") brightness: String): String {
        mqttGateway.publish("brightness", brightness)
        return brightness
    }
}