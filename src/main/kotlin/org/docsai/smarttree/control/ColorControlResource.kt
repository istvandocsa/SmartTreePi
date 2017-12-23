package org.docsai.smarttree.control

import org.docsai.smarttree.config.MQTTConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.awt.Color

@RestController
@RequestMapping("/color")
class ColorControlResource(val mqttGateway: MQTTConfig.MQTTGateway) {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(this.javaClass)
    }

    @PostMapping
    fun setColor(@RequestBody colorHsb: Map<String, Double>): String {
        LOG.info("setColor: $colorHsb")
        val rgbMessage = hsbToRGBMessage(colorHsb)
        mqttGateway.publish("color", rgbMessage)
        return rgbMessage
    }

    private fun hsbToRGBMessage(colorHsb: Map<String, Double>): String {
        val hue = colorHsb.getOrDefault("hue", 350.5).toFloat() / 360.0f
        val saturation = colorHsb.getOrDefault("saturation", 0.7138).toFloat()
        val brightness = colorHsb.getOrDefault("brightness", 0.6524).toFloat()

        val color = Color.getHSBColor(hue, saturation, brightness)

        return "" + color.red + "_" + color.green + "_" + color.blue
    }
}