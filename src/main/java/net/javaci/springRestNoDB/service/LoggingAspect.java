package net.javaci.springRestNoDB.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static net.javaci.springRestNoDB.util.PrintUtil.*;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* net.javaci..*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        printMemory("Entering method: " + joinPoint.getSignature().getName() + " in " + joinPoint.getTarget().getClass().getSimpleName());
        Object[] args = joinPoint.getArgs();
//        if (args.length > 0) {
//            printText("\tArguments: ");
//            for (Object arg : args) {
//                printText("\t\t" + arg);
//            }
//        }
    }

    @AfterReturning(pointcut = "execution(* net.javaci..*.*(..))", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        printTimer("Exiting method: " + joinPoint.getSignature().getName()+ " in " + joinPoint.getTarget().getClass().getSimpleName());
//        if (result != null) {
//            printTimer("Return value: " + result);
//        }
    }
}
