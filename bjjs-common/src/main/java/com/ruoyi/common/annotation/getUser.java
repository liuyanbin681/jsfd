package com.ruoyi.common.annotation;

import com.ruoyi.common.core.controller.BaseController;
import org.apache.shiro.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface getUser{

String name() default "刘彦斌";//定义String类型
}

