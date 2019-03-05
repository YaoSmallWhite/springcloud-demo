package com.yao.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 对经过zuul的请求过滤
 * @Author: ys1892
 * @Date: 2019-03-05
 * @Time: 14:24
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * 过滤类型，在zuul中定义了四种不同生命周期的过滤器类型
     *
     * @return pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要此过滤器执行过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String url = request.getRequestURL().toString();
        System.out.println("经过zuul请求的url为" + url);
//       获取token
        String token = request.getParameter("token");
        if (token == null || "".equals(token)) {
            //过滤该请求，不进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("error:token is empty!");
        }
        return null;
    }
}
