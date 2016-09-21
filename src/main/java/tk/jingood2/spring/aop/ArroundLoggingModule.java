package tk.jingood2.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.jingood2.java.model.Document;

/**
 * Created by KimJin-young on 2016. 9. 22..
 */
public class ArroundLoggingModule implements MethodInterceptor {

    private static final Logger log =
            LoggerFactory.getLogger(ArroundLoggingModule.class);

    /**
     * Implement this method to perform extra treatments before and
     * after the invocation. Polite implementations would certainly
     * like to invoke {@link Joinpoint#proceed()}.
     *
     * @param invocation the method invocation joinpoint
     * @return the result of the call to {@link
     * Joinpoint#proceed()}, might be intercepted by the
     * interceptor.
     * @throws Throwable if the interceptors or the
     *                   target-object throws an exception.
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object result = null;
        if(log.isDebugEnabled()) {
            log.debug("@@@@(AROUND-BEFORE) Method called: " + invocation.getMethod().getName());

            if(invocation.getArguments().length == 0)
                log.debug("@@@@(AROUND-BEFORE) No Argument passed.");
            for(Object arg:invocation.getArguments())
                log.debug("@@@@(AROUND-BEFORE) Argument passed:" + arg);
        }

        try {
            if(log.isDebugEnabled())
                log.debug("@@@(AROUND) Processing...");

            result = invocation.proceed();

            if(log.isDebugEnabled())
                log.debug("@@@(AROUND-AFTER) Result: " + result);
        } catch(IllegalAccessException ex) {
            log.error("@@@(AROUND) Throws an exception: " + ex.getMessage());
            throw ex;
        }

        return result;
    }
}
