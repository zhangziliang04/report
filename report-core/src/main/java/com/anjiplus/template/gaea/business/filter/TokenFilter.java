package com.anjiplus.template.gaea.business.filter;


import com.alibaba.fastjson.JSONObject;
import com.anji.plus.gaea.bean.ResponseBean;
import com.anji.plus.gaea.cache.CacheHelper;
import com.anji.plus.gaea.utils.JwtBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 简单的鉴权
 * Created by raodeming on 2021/6/24.
 */
@Component
@Order(Integer.MIN_VALUE + 99)
public class TokenFilter implements Filter {
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private JwtBean jwtBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();

        if(uri.equals("/")){
            response.sendRedirect("/index.html");
            return;
        }
        if (!uri.startsWith("/login")
                && !uri.startsWith("/static")
                && !uri.startsWith("/file/download/")
                && !uri.contains("index.html")) {

            //获取token
            String authorization = request.getHeader("Authorization");
            if (StringUtils.isBlank(authorization)) {
                error(response);
                return;
            }

            String username = jwtBean.getUsername(authorization);
//            String uuid = jwtBean.getUUID(authorization);

            if (!cacheHelper.exist(username)) {
                error(response);
                return;
            }

            //延长有效期
            cacheHelper.stringSetExpire(username, authorization, 3600);


            //在线体验版本
            if (username.equals("guest")
                    && !uri.endsWith("/dataSet/testTransform")
                    && !uri.endsWith("/reportDashboard/getData")
                    && !uri.startsWith("/dict")
                    && !uri.startsWith("/dict")
            ) {
                //不允许删除
                String method = request.getMethod();
                if ("post".equalsIgnoreCase(method)
                        || "put".equalsIgnoreCase(method)
                        || "delete".equalsIgnoreCase(method)
                ) {
                    ResponseBean responseBean = ResponseBean.builder().code("50001").message("在线体验版本，不允许此操作。请自行下载本地运行").build();
                    response.getWriter().print(JSONObject.toJSONString(responseBean));
                    return;
                }
            }
        }

        //执行
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private void error(HttpServletResponse response) throws IOException {
        ResponseBean responseBean = ResponseBean.builder().code("50014").message("The Token has expired").build();
        response.getWriter().print(JSONObject.toJSONString(responseBean));
    }
}
