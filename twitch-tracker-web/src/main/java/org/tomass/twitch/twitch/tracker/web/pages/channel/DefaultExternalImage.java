package org.tomass.twitch.twitch.tracker.web.pages.channel;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.image.ExternalImage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.UrlUtils;
import org.apache.wicket.request.cycle.RequestCycle;

public class DefaultExternalImage extends ExternalImage {

    private static final long serialVersionUID = 1L;

    public DefaultExternalImage(String id) {
        super(id);
    }

    @Override
    protected void buildSrcAttribute(ComponentTag tag, IModel<?> srcModel) {

        String src = String.valueOf(srcModel.getObject());
        if (src != null && !src.equals("null")) {
            super.buildSrcAttribute(tag, srcModel);
        } else {
            final String rewritten = UrlUtils.rewriteToContextRelative("/img/defaultLogo.png", RequestCycle.get());
            tag.put("src", rewritten);
        }
    }

}
