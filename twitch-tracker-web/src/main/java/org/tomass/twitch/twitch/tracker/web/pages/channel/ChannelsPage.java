package org.tomass.twitch.twitch.tracker.web.pages.channel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.tomass.twitch.model.TwitchUser;
import org.tomass.twitch.twitch.tracker.web.pages.BasePage;
import org.tomass.twitch.twitch.tracker.web.pages.HomePage;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("channel")
public class ChannelsPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public ChannelsPage() {
        super();
    }

    @Override
    protected void createPage() {
        super.createPage();
        addChannelListView();
    }

    private void addChannelListView() {
        add(new PropertyPageableListView<TwitchUser>("channels", twitchUserService.listTwitchUser(), 50) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(final ListItem<TwitchUser> listItem) {
                TwitchUser user = listItem.getModelObject();
                listItem.add(new Label("order", listItem.getIndex() + 1));
                listItem.add(new Label("displayName"));
                listItem.add(new Label("timeStreamed"));
                listItem.add(new Label("hoursWatched"));
                listItem.add(new Label("avgViewers"));
                Link link;
                listItem.add(link = new Link<Void>("enterUser") {

                    private static final long serialVersionUID = 1L;

                    public void onClick() {
                        setResponsePage(HomePage.class, new PageParameters().set("UID", user.getId()));
                    }
                });
                link.add(new DefaultExternalImage("profileImageUrl"));
            }
        });
    }

    @Override
    protected IModel<String> newHeadingModel() {
        return Model.of("Channels");
    }

}