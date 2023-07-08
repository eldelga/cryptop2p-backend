package com.desapp.backendcryptop2p.component;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.desapp.backendcryptop2p.model.User;

import java.util.Date;

@Aspect
@Component

public class TimeLogAspect {

@Around("@within(org.springframework.web.bind.annotation.RestController) ")
    public Object time(ProceedingJoinPoint pjp) throws Throwable {
        String email = getEmailLoggedUser(pjp.getArgs());
        long initTime = new Date().getTime();
        var obj = pjp.proceed();
        LogManager.getLogger(this.getClass()).warn("-----> Time Log (" + initTime + " " + email + " " + pjp.getSignature().getDeclaringTypeName() + ":"
                + pjp.getSignature().getName() + "): " + (new Date().getTime() - initTime) + "ms");
        return obj;
    }

    private String getEmailLoggedUser(Object[] signatureArgs){
        String email = "No logged User";
        for (Object arg : signatureArgs) {
            if (arg instanceof UsernamePasswordAuthenticationToken) {
                UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) arg;
                if (authentication.getPrincipal() instanceof User) {
                    User user = (User) authentication.getPrincipal();
                    email = user.getEmail();
                    break;
                }
            }
        }
        return email;
    }
}

