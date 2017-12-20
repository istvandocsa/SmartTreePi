package org.docsai.smarttree.control

import org.docsai.smarttree.config.MQTTConfig
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.awt.Color

@RestController
@RequestMapping("/color")
class ColorControlResource(val mqttGateway: MQTTConfig.MQTTGateway) {

    @PostMapping("/{color}")
    fun onOff(@PathVariable("color") colorHsb: Map<String, Double>): String {
        val rgbMessage = hsbToRGBMessage(colorHsb)
        mqttGateway.publish("color", rgbMessage)
        return rgbMessage
    }

    private fun hsbToRGBMessage(colorHsb: Map<String, Double>): String {
        val hue = colorHsb.getOrDefault("hue", 350.5).toFloat()
        val saturation = colorHsb.getOrDefault("saturation", 0.7138).toFloat()
        val brightness = colorHsb.getOrDefault("brightness", 0.6524).toFloat()

        val rgb = Color.HSBtoRGB(hue, saturation, brightness)

        val red = rgb shr 16 and 0xFF
        val green = rgb shr 8 and 0xFF
        val blue = rgb and 0xFF

        return "" + red + "_" + green + "_" + blue
    }
}