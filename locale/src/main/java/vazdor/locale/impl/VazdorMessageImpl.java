package vazdor.locale.impl;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import vazdor.locale.VazdorLocale;
import vazdor.locale.VazdorMessage;

@Component
public class VazdorMessageImpl implements VazdorMessage {
	
	private MessageSource messageSource;
	private VazdorLocale vazdorLocale;
	
	public String getMessage(String key) {
		try {
			return messageSource.getMessage(key, null, vazdorLocale.localeSelecionado());
		} catch (Exception e) {
			return "Unresolved key: " + key;
		}
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void setVazdorLocale(VazdorLocale vazdorLocale) {
		this.vazdorLocale = vazdorLocale;
	}
}