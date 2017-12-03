package org.docsai.smarttree.config

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class StatelessAuthenticationFilter : OncePerRequestFilter() {

    private val header = "ClientId"

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val clientId: String? = request.getHeader(header)

        SecurityContextHolder.getContext().authentication = if (clientId == LambdaUser.clientId) LambdaUser else null

        filterChain.doFilter(request, response)
    }
}
