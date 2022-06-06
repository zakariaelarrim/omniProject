package manageClient2.config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectLogConfig {
	
	private static final Logger LOG = LogManager.getLogger();
	
	@Around("within(manageClient2.service.impl.*)")
	public Object logAround(MethodInvocationProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		LOG.debug("Hello");
		LOG.debug("{}({}): {} in {}msec(s)", 
				MethodSignature.class.cast(joinPoint.getSignature()).getMethod().getName(),
				joinPoint.getArgs(),
				result,
				System.currentTimeMillis() - start);
		return result;
	}
	

}
