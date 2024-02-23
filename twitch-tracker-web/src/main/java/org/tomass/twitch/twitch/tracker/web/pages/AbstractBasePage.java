package org.tomass.twitch.twitch.tracker.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tomass.twitch.twitch.tracker.web.service.StreamService;
import org.tomass.twitch.twitch.tracker.web.service.TwitchUserService;

public class AbstractBasePage extends WebPage {

    private static final long serialVersionUID = 1L;

    @SpringBean(name = "streamService")
    protected StreamService streamService;

    @SpringBean(name = "twitchUserService")
    protected TwitchUserService twitchUserService;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public AbstractBasePage() {
        super();
    }

    public AbstractBasePage(IModel<?> model) {
        super(model);
    }

    public AbstractBasePage(PageParameters parameters) {
        super(parameters);
    }

}
