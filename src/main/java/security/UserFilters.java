package security;


import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class UserFilters implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        User user = (User) httpRequest.getSession().getAttribute("user");
        String role = null;
        try {
            role = user.getRole();
        } catch (Exception e) {
            servletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(servletRequest, servletResponse);
        }
        if ("admin".equals(role)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if ("user".equals(role)) {
            httpServletResponse.sendRedirect("/user");
        } else {
            httpServletResponse.sendRedirect("/WEB-INF/login.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}
