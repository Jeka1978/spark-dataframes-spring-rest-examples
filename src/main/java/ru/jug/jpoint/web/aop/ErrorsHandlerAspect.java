package ru.jug.jpoint.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 21/04/2016.
 */
@Component
@Aspect
public class ErrorsHandlerAspect {
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public String handleControllerError(ProceedingJoinPoint pjp){
        try {
            return (String) pjp.proceed();
        } catch (Throwable throwable) {
           return "problem...";
        }
    }

}

