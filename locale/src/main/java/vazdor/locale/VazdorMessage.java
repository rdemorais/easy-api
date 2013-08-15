package vazdor.locale;

import org.springframework.context.MessageSource;

public interface VazdorMessage {
	public String getMessage(String key);
	public void setMessageSource(MessageSource messageSource);
	public void setVazdorLocale(VazdorLocale vazdorLocale);
}
