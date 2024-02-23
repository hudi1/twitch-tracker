package org.tomass.twitch.twitch.tracker.web.pages;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
public class HomePage extends BasePage {

    private static final long serialVersionUID = 1L;

    public HomePage(PageParameters pageParameters) {

    }

    @Override
    protected IModel<String> newHeadingModel() {
        return Model.of("Vítejte na stránce ");
    }

}
