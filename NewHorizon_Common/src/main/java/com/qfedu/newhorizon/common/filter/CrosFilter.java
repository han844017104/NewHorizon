package com.qfedu.newhorizon.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CrosFilter")
public class CrosFilter implements Filter {
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpServletRequest request=(HttpServletRequest)req;
        //response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age","2000");
        response.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-with,Content-Type,Accept");
        response.setHeader("Access-Control-Allow-Credentials","true");
        chain.doFilter(req,resp);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
