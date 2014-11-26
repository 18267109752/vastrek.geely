package com.vastrek.geelyhelper.content.ruler;

/**
 * 
 * @author zhaoheng
 * 
 */
public class ContentRuler {
	public int bindViewId;
	public IContentRuler<?, ?> ruler;

	public ContentRuler(int viewId, IContentRuler<?, ?> ruler) {
		this.bindViewId = viewId;
		this.ruler = ruler;
	}
}