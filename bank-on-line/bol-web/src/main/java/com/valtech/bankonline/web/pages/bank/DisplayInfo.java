package com.valtech.bankonline.web.pages.bank;

public class DisplayInfo {
	private String clientName;
	private String externalAccountId;

	public DisplayInfo() {

	}

	public DisplayInfo clone() {
		DisplayInfo copy = new DisplayInfo();
		copy.setClientName(getClientName());
		copy.setExternalAccountId(getExternalAccountId());
		return copy;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getExternalAccountId() {
		return externalAccountId;
	}

	public void setExternalAccountId(String externalAccountId) {
		this.externalAccountId = externalAccountId;
	}
}
