package com.temp.dionysus.log;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LogService {
	@Autowired
	private Logger logger;

	public LogService() {
		logger = Logger.getLogger("dionysus");
	}

	public LogService(Logger logger) {
		this.logger = logger;
	}

	public LogService(String type) {
		logger = Logger.getLogger(type);
	}

	@Pointcut("execution(* *(..)) && !@annotation(org.junit.Test)")
	public void allFunctions() {

	}

	@Pointcut("(execution(public * *(..)) || @annotation(Loggable)) && !@annotation(org.junit.Test)&& !@annotation(NoLogging) && !execution( String *.toString()) && !execution(* *.domain.*.get*())")
	public void
	logableFunctions() {

	}

	@AfterThrowing(pointcut = "allFunctions() && cflowbelow(allFunctions()) && !within(LogService)", throwing = "throwable")
	public void logRunTimeException(JoinPoint jp, Throwable throwable) {
		if (throwable instanceof Error) {
			logger.fatal("Error Detected. " + jp.toString(), throwable);
		} else {
			logger.error("Exception Detected. " + jp.toString(), throwable);
		}
		throwable.printStackTrace();
	}

	@Before("logableFunctions()")
	public void logEnterFunction(final JoinPoint jp) {
		logger.debug(jp.getSignature() + " START: " + Arrays.toString(jp.getArgs()));
	}

	@AfterReturning(pointcut = "logableFunctions()", returning = "o")
	public void logReturningFunction(final JoinPoint jp, Object o) {
		logger.info(jp.getSignature() + " DONE: " + Arrays.toString(jp.getArgs()) + " Returning: " + o);
	}

}