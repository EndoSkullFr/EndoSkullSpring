package fr.endoskull.EndoSkullSpring.controllers;

import fr.endoskull.EndoSkullSpring.utils.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping("/error")
    public Error handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            return new Error(HttpStatus.valueOf(statusCode).getReasonPhrase(), String.valueOf(request.getAttribute(RequestDispatcher.ERROR_MESSAGE)), statusCode);
        }
        return new Error("Did you went on /error manually ?", "Any", 0);
    }
}
