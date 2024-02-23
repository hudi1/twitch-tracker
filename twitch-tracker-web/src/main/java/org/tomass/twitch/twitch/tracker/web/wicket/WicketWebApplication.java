package org.tomass.twitch.twitch.tracker.web.wicket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;

@Component
public class WicketWebApplication extends WicketBootStandardWebApplication {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void init() {
        super.init();
        getCspSettings().blocking().disabled();
        
        /*
         * getApplicationSettings().setAccessDeniedPage(ErrorPage401.class); getCspSettings().blocking().disabled();
         * 
         * this.getRequestCycleListeners().add(new IRequestCycleListener() {
         * 
         * @Override public IRequestHandler onException(RequestCycle cycle, Exception e) { if (e instanceof
         * UnauthorizedActionException) { return null; }
         * 
         * if (e instanceof UnauthorizedInstantiationException) { return null; }
         * 
         * if (e instanceof AccessDeniedException) { return null; }
         * 
         * RuntimeException myE = Exceptions.findCause(e, RuntimeException.class); logger.error("Unexpected error: ",
         * e);
         * 
         * if (myE != null) { Optional<IPageRequestHandler> handler = cycle.find(IPageRequestHandler.class); if
         * (handler.isPresent()) { if (handler.get().isPageInstanceCreated()) { WebPage page = (WebPage)
         * (handler.get().getPage()); //page.error(page.getString(myE.getCode())); return new
         * RenderPageRequestHandler(new PageProvider(page)); } } }
         * 
         * return new RenderPageRequestHandler(new PageProvider(ErrorPage500.class)); }
         * 
         * });
         */
    }
    /*
     * @Override public Session newSession(Request request, Response response) { return new
     * RobAuthenticatedWebSession(request); }
     * 
     * @Bean public ErrorPageRegistrar errorPageRegistrar() { return new MyErrorPageRegistrar(); }
     */

}