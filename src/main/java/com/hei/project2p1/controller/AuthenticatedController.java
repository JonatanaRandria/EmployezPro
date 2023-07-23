package com.hei.project2p1.controller;

import com.hei.project2p1.model.EmployeeEntity;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.List;

@Controller
@Component
public class AuthenticatedController implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("user") == null) {
            // Si l'utilisateur n'est pas authentifié, redirigez vers la page de connexion
            if (!isLoginPageRequest(request)) {
                response.sendRedirect(request.getContextPath() + "/login");
                return false; // Arrêtez le traitement de la requête
            }
        }

        return true; // Autoriser la requête à continuer vers le contrôleur
    }
    private boolean isLoginPageRequest(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        return requestURI.equals(contextPath + "/login") || requestURI.equals(contextPath + "/login/");
    }


}
