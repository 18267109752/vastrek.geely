package com.vastrek.geelyhelper.content.ruler;

/**
 * @author zhaoheng
 * ����ת���Ĺ���
 */
public interface IContentRuler<K,V> {
	/**
	 * ����ת��������ʾ���ݵ�ģ������
	 * eg. "��" -> 1
	 * @param value
	 * @return
	 */
	V transToObject(K value);
	
	/**
	 * ����ת������ģ�����ݵ���ʾ����
	 * eg.  1  ->  "��"
	 * @param value
	 * @return
	 */
	K transToShow(V value);
}
