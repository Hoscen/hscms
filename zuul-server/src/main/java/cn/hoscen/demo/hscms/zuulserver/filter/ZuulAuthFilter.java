package cn.hoscen.demo.hscms.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

//@Component
public class ZuulAuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
                //pre：路由之前
                //routing：路由之时
                //post： 路由之后
                //error：发送错误调用
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //过滤器的执行顺序，数字越小，表示优先级越高
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    /**
     * 这里可以写逻辑判断，是否要过滤，true为永远过滤。
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 简单模拟鉴权，在代理访问的url上必须加上传参?token=xxx,否则不让通过
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        //从参数url获取参数
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            requestContext.setSendZuulResponse(false);
            try {
                requestContext.getResponse().setContentType("text/html;charset=utf-8");
                requestContext.getResponse().getWriter().write("没有获取到token，权限不通过");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
