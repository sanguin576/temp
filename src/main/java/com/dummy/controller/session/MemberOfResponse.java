package com.dummy.controller.session;

import java.util.List;

public class MemberOfResponse {
	List<MemberOfResponseValue> value;
	
	public MemberOfResponse() {
	}

	public MemberOfResponse(List<MemberOfResponseValue> value) {
		super();
		this.value = value;
	}

	public List<MemberOfResponseValue> getValue() {
		return value;
	}

	public void setValue(List<MemberOfResponseValue> value) {
		this.value = value;
	}
	
	
}
