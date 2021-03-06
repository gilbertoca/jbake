package org.jbake.render;

import java.io.File;

import org.apache.commons.configuration.CompositeConfiguration;
import org.jbake.app.ConfigUtil.Keys;
import org.jbake.app.ContentStore;
import org.jbake.app.Renderer;
import org.jbake.template.RenderingException;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

public class FeedRenderer implements RenderingTool {

	@Override
	public int render(Renderer renderer, ContentStore db, File destination, File templatesPath, CompositeConfiguration config) throws RenderingException {
		if (config.getBoolean(Keys.RENDER_FEED)) {
			try {
				renderer.renderFeed(config.getString(Keys.FEED_FILE));
				return 1;
			} catch (Exception e) {
				throw new RenderingException(e);
			}
		} else {
			return 0;
		}
	}

}