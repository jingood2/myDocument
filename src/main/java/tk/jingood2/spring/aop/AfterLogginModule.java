package tk.jingood2.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by KimJin-young on 2016. 9. 21..
 */
public class AfterLogginModule implements AfterReturningAdvice {

    private static final Logger log =
            LoggerFactory.getLogger(AfterLogginModule.class);

    /**
     * Callback after a given method successfully returned.
     *
     * @param returnValue the value returned by the method, if any
     * @param method      method being invoked
     * @param args        arguments to the method
     * @param target      target of the method invocation. May be {@code null}.
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the caller if it's
     *                   allowed by the method signature. Otherwise the exception
     *                   will be wrapped as a runtime exception.
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        if(log.isDebugEnabled())
            log.debug("@@@(AFTER) Method called: " + method.getName() );

        if(args.length == 0)
            log.debug("@@@@(AFTER) No arguments passed.");
        else {
            for(Object arg:args )
                log.debug("@@@@(AFTER) Argument passwd: " + arg);
            log.debug("@@@@(AFTER) Result: " + returnValue);
        }

    }

}
