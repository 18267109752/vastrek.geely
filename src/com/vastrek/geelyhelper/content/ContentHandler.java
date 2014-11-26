package com.vastrek.geelyhelper.content;

import java.util.ArrayList;

import com.vastrek.geelyhelper.content.ruler.ContentRuler;
import com.vastrek.geelyhelper.content.ruler.IContentRuler;

/**
 * @author zhaoheng
 * <p>1.实现数据到数据的转换</p>
 * <p>2.实现数据对显示的影响</p>
 */
public abstract class ContentHandler {

	private ArrayList<ContentRuler> rulerList;
	
	public ContentHandler(){
		rulerList = new ArrayList<ContentRuler>();
	}
	
	protected IContentRuler<?, ?> findRulerById(int viewId) {
		for (ContentRuler ruler : rulerList) {
			if (ruler.bindViewId == viewId) {
				return ruler.ruler;
			}
		}
		return null;
	}
	
	/**
	 * 添加数据转换规则
	 * 因为“模型”定义中只关联id，所以这里只能绑定id
	 * @param viewId 
	 * @param ruler
	 */
	public void addDataRuler(int viewId,IContentRuler<?,?> ruler){
		ContentRuler contentRuler = new ContentRuler(viewId, ruler);
		rulerList.add(contentRuler);
	}
}
