package com.conzen.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @Author: Less
 * @Date: 2018/6/15 下午10:52
 * @Description:
 **/
public class ConzenExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    /**
     * @param invalidSessionUrl
     */
    public ConzenExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    /* (non-Javadoc)
	 * @see org.springframework.security.web.session.SessionInformationExpiredStrategy#onExpiredSessionDetected(org.springframework.security.web.session.SessionInformationExpiredEvent)
	 */
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    /* (non-Javadoc)
     * @see com.imooc.security.browser.session.AbstractSessionStrategy#isConcurrency()
     */
    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
