package com.vastrek.geelyhelper.test.model;

import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.content.ViewBridge;

/**
 * @author zhaoheng
 *
 */
public class TestModel {
	@ViewBridge({R.id.login_username})
	public String name;
	@ViewBridge(R.id.login_pwd)
	public String pwd;
	@ViewBridge(R.id.login_pwd1)
	public String pwd1;
	@ViewBridge(R.id.login_pwd2)
	public String pwd2;
	@ViewBridge(R.id.login_pwd3)
	public String pwd3;
	
}
