package com.vastrek.geelyhelper.frame.struct;

import java.io.Serializable;

import com.vastrek.geelyhelper.frame.ui.Page;

public final class ActValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -516026144091353236L;

	public Class<? extends Page> gotoPage;
	
	public Object value;
}
