package com.onb.employeeRegistration.init;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.onb.employeeRegistration.domain.ERSAccount;
import com.onb.employeeRegistration.service.ERSAccountService;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private ERSAccountService ersAccountService;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
		
	}
	
	private String determineTargetUrl(Authentication authentication) {
        boolean isAdmin = false;
        boolean isBranchHead = false;
        boolean isDepartmentHead = false;
        ERSAccount ersAccount = ersAccountService.getERSAccountByUsername(authentication.getName());
        
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ADMINISTRATOR")) {
                isAdmin = true;
            } else if (grantedAuthority.getAuthority().equals("BRANCH_HEAD")) {
                isBranchHead = true;
            }else if (grantedAuthority.getAuthority().equals("DEPARTMENT_HEAD")) {
                isDepartmentHead = true;
            }
        }
 
        if (isAdmin) {
            return "/branch";
        } 
        else if (isBranchHead) {
            return "/branch/view/"+ersAccount.getEmployee().getDepartment().getBranch().getId();
        }
        else if (isDepartmentHead){
        	return "/department/view/"+ersAccount.getEmployee().getDepartment().getId();
        }
        else {
            throw new IllegalStateException();
        }
    }
	
	private void handle(HttpServletRequest request,
		      HttpServletResponse response, Authentication authentication) throws IOException {
		
		if (response.isCommitted()) {
            return;
		}  
		String targetUrl = determineTargetUrl(authentication);
		request.getSession().setAttribute("targetUrl", targetUrl);
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

}
