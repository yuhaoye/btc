/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: yeyuhao[ye_yh@suixingpay.com] 
 * @date: 2018年4月22日 下午5:49:57   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.yyh.btc.model;

/**  
 * TODO
 * @author: yeyuhao[ye_yh@suixingpay.com]
 * @date: 2018年4月22日 下午5:49:57
 * @version: V1.0
 * @review: yeyuhao[ye_yh@suixingpay.com]/2018年4月22日 下午5:49:57
 */
public class FXHNoticeModel {
    
    private String title;
    
    private String content;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

}
