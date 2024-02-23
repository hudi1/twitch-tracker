package org.tomass.twitch.twitch.tracker.web.pages;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.RequestUtils;
import org.apache.wicket.request.http.flow.AbortWithHttpErrorCodeException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValueConversionException;
import org.springframework.http.HttpStatus;
import org.tomass.twitch.twitch.tracker.web.pages.channel.ChannelsPage;

public abstract class BasePage extends AbstractBasePage {

    private static final long serialVersionUID = 1L;

    private IModel<String> headingModel = new Model<String>();

    public final IModel<String> getHeadingModel() {
        return headingModel;
    }

    abstract protected IModel<String> newHeadingModel();

    protected FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel") {

        private static final long serialVersionUID = 1L;

        @Override
        public void renderHead(IHeaderResponse response) {
            // TODO nechat miznut aj chyby ?
            response.render(OnDomReadyHeaderItem
                    .forScript("$(\"#" + getMarkupId() + "\").fadeIn('slow').delay(6000).fadeOut('slow');"));
        }
    };

    public BasePage() {
        this(new PageParameters());
    }

    public BasePage(PageParameters parameters) {
        super(parameters);

        try {
            prepareData(parameters);
        } catch (StringValueConversionException e) {
            throw new AbortWithHttpErrorCodeException(HttpStatus.NOT_FOUND.value());
        }
        createPage();
    }

    protected void prepareData(PageParameters parameters) {

    }

    protected void createPage() {
        headingModel = newHeadingModel();
        add(new ExternalLink("heading",
                Model.of(RequestUtils.toAbsolutePath(urlFor(getApplication().getHomePage(), null).toString(),
                        urlFor(HomePage.class, null).toString().toString())),
                headingModel));

        add(new BookmarkablePageLink<Void>("channelsPage", ChannelsPage.class));

        add(feedbackPanel.setOutputMarkupId(true));
        add(new Label("pageTitle", "TwitchTracker"));
    }

    @Override
    protected void onRender() {
        logger.trace("Render start: " + getClass());
        long time = System.currentTimeMillis();
        super.onRender();
        time = System.currentTimeMillis() - time;
        logger.trace("Render end: " + time + " ms");
    };

}