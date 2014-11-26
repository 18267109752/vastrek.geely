package com.vastrek.geelyhelper.content.ruler;

/**
 * @author zhaoheng
 * 内容规则工厂，用来生成常用规则
 */
public final class ContentRulerFactory {
	
	/**
	 * 生成测试规则
	 * @return
	 */
	public static IContentRuler<String,String> getTestRuler(){
		return new IContentRuler<String,String>() {
			
			@Override
			public String transToObject(String value) {
				return "testrule";
			}

			@Override
			public String transToShow(String value) {
				return null;
			}
		};
	}
}
