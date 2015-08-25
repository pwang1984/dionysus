package temp.dionysus.log;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogService {
	@Inject
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

	@Pointcut("execution(* *(..)) "
			+ "&& !within(*..*Test) "
			+ "&& !execution(* *..domain..*.get*(..))"
			+ "&& !execution(* *..domain..*.set*(..))")
	public void allFunctions() {

	}

	@Pointcut("(execution(public * *(..)) || @annotation(Loggable)) "
			+ "&& !within(*..*Test)"
			+ "&& !@annotation(NoLogging) "
			+ "&& !execution( String *.toString()) "
			+ "&& !execution(* *..domain..*.get*(..))"
			+ "&& !execution(* *..domain..*.set*(..))")
	public void logableFunctions() {

	}

	@AfterThrowing(pointcut = "allFunctions() && cflowbelow(allFunctions())", throwing = "throwable")
	public void logThrowable(JoinPoint jp, Throwable throwable) throws Throwable {
		if (throwable instanceof Error) {
			logger.fatal("Error Detected. " + jp.toString(), throwable);
		} else {
			logger.error("Exception Detected. " + jp.toString(), throwable);
		}
		throwable.printStackTrace();
		throw throwable;
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