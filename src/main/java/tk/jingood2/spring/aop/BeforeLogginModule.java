package tk.jingood2.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by KimJin-young on 2016. 9. 21..
 */
public class BeforeLogginModule implements MethodBeforeAdvice {

    private static final Logger log =
            LoggerFactory.getLogger(BeforeLogginModule.class);

    /**
     * Callback before a given method is invoked.
     *
     * @param method method being invoked
     * @param args   arguments to the method
     * @param target target of the method invocation. May be {@code null}.
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the caller if it's
     *                   allowed by the method signature. Otherwise the exception
     *                   will be wrapped as a runtime exception.
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if(log.isDebugEnabled())
            log.debug("@@@(BEFORE) Method called: " + method.getName() );

            if(args.length == 0)
                log.debug("@@@@(BEFORE) No arguments passed.");
            else {
                for(Object arg:args )
                    log.debug("@@@@(BEFORE) Argument passwd: " + arg);
            }

    }
}
