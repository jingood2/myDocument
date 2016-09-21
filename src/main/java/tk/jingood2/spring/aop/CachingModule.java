package tk.jingood2.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.jingood2.java.model.Type;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KimJin-young on 2016. 9. 22..
 */
public class CachingModule implements MethodInterceptor {

    private static final Logger log =
            LoggerFactory.getLogger(CachingModule.class);
    private static final Map<String,Object> cache = new HashMap<String,Object>();

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
        Type documentType = null;

        log.debug("@@@(Cashing) review if this call is cachable...");

        if("findByType".equals(invocation.getMethod().getName())
                && invocation.getArguments().length == 1
                && invocation.getArguments()[0] instanceof Type) {

            documentType = (Type)invocation.getArguments()[0];

            log.debug("@@@(Caching) Is Cachable!!!");

            if(cache.containsKey(documentType.getName())){
                log.debug("@@@(Caching) Found in Cache!");
                return cache.get(documentType.getName());
            }

            log.debug("@@@(Caching) Not Found! but is cachable!");
            result = invocation.proceed();
            cache.put(documentType.getName(),result);

            return result;
        }

        return invocation.proceed() ;
    }
}
