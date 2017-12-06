package org.docsai.smarttree.discovery

import org.docsai.smarttree.common.SmartTreeDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/discover")
class DiscoveryResource {

    @GetMapping()
    fun ping(): SmartTreeDetails = SmartTreeDetails
}