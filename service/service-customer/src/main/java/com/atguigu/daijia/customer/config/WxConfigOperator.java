package com.atguigu.daijia.customer.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Joey Zhuo
 * @Date: 2024/10/01/18:13
 */
@Component
public class WxConfigOperator {
    @Autowired
    private WxConfigProperties wxConfigProperties;

    /**
     * 创建微信工具包对象
     * @return
     */
    @Bean
    public WxMaService wxMaService() {
        //微信小程序id和秘钥
        WxMaDefaultConfigImpl wxMaConfig = new WxMaDefaultConfigImpl();
        wxMaConfig.setAppid(wxConfigProperties.getAppId());
        wxMaConfig.setSecret(wxConfigProperties.getSecret());
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(wxMaConfig);
        return service;
    }

}
