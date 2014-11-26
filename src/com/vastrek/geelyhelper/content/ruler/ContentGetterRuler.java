package com.vastrek.geelyhelper.content.ruler;

/**
 * @author zhaoheng
 *
 */
public abstract class ContentGetterRuler<K, V> implements IContentRuler<K, V>{

	@Override
	public K transToShow(V value) {
		return null;
	}

}
