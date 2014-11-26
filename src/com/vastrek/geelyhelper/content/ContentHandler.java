package com.vastrek.geelyhelper.content;

import java.util.ArrayList;

import com.vastrek.geelyhelper.content.ruler.ContentRuler;
import com.vastrek.geelyhelper.content.ruler.IContentRuler;

/**
 * @author zhaoheng
 * <p>1.ʵ�����ݵ����ݵ�ת��</p>
 * <p>2.ʵ�����ݶ���ʾ��Ӱ��</p>
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
	 * �������ת������
	 * ��Ϊ��ģ�͡�������ֻ����id����������ֻ�ܰ�id
	 * @param viewId 
	 * @param ruler
	 */
	public void addDataRuler(int viewId,IContentRuler<?,?> ruler){
		ContentRuler contentRuler = new ContentRuler(viewId, ruler);
		rulerList.add(contentRuler);
	}
}
