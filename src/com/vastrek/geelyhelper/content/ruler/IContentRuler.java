package com.vastrek.geelyhelper.content.ruler;

/**
 * @author zhaoheng
 * 内容转换的规则
 */
public interface IContentRuler<K,V> {
	/**
	 * 正向转换，从显示数据到模型数据
	 * eg. "男" -> 1
	 * @param value
	 * @return
	 */
	V transToObject(K value);
	
	/**
	 * 反向转换，从模型数据到显示数据
	 * eg.  1  ->  "男"
	 * @param value
	 * @return
	 */
	K transToShow(V value);
}
