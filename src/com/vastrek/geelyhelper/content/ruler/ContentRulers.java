package com.vastrek.geelyhelper.content.ruler;

import java.util.ArrayList;

/**
 * @author zhaoheng
 *
 */
public class ContentRulers {

	private ArrayList<ContentRuler> rulerList;
	public ContentRulers(){
		rulerList = new ArrayList<ContentRuler>();
	}
	
	public ContentRulers bindRuler(int viewId,IContentRuler<?,?> ruler){
		ContentRuler contentRuler = new ContentRuler(viewId, ruler);
		rulerList.add(contentRuler);
		return this;
	}
	
	public ArrayList<ContentRuler> getRulerList(){
		return rulerList;
	}
	@SuppressWarnings("unused")
	private static class ContentRuler{
		int bindViewId;
		IContentRuler<?,?> ruler;
		public ContentRuler(int viewId,IContentRuler<?,?> ruler){
			this.bindViewId = viewId;
			this.ruler = ruler;
		}
	}
}
