package learn.lhb.myshop.plus.business.controller;

import com.google.common.collect.Maps;
import learn.lhb.myshop.plus.business.dto.LoginInfo;
import learn.lhb.myshop.plus.business.dto.LoginParam;
import learn.lhb.myshop.plus.business.feign.ProfileFeign;
import learn.lhb.myshop.plus.commons.dto.BaseResult;
import learn.lhb.myshop.plus.commons.utils.MapperUtil;
import learn.lhb.myshop.plus.commons.utils.OkHttpClientUtil;
import learn.lhb.myshop.plus.provider.domain.UmsAdmin;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * @author 梁鸿斌
 * @date 2020/3/7.
 * @time 15:57
 */
@RestController
@RequestMapping("user")
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:9001/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Resource(name = "userDetailsServiceBean")
    private UserDetailsService userDetailsService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    public TokenStore tokenStore;

    @Resource
    private ProfileFeign profileFeign;

    /**
     * 登录业务
     * @param loginParam
     * @return 返回登录状态给前端
     */
    @RequestMapping("login")
    public BaseResult login(@RequestBody LoginParam loginParam) {
        // 封装返回结果集
        Map<String, Object> result = Maps.newHashMap();

        // 验证账号密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails == null || !passwordEncoder.matches(loginParam.getPassword(),userDetails.getPassword())) {
            return BaseResult.error(BaseResult.CodeStatus.ERROR,"账号或密码错误");
        }

        // 通过 HTTP客户端请求登录接口
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);
        try {
            // 解析响应结果封装并返回
            Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> jsonMap = MapperUtil.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("token", token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new BaseResult().put(BaseResult.CodeStatus.OK,"登录成功","data",result);
    }

    /**
     * 获取用户信息
     * @param authentication
     * @return
     */
    @GetMapping(value = "info")
    public BaseResult info(Authentication authentication) throws Exception {

        String jsonString = profileFeign.info(authentication.getName());
        UmsAdmin umsAdmin = MapperUtil.json2pojoByTree(jsonString, "data", UmsAdmin.class);

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(umsAdmin.getNote());
        loginInfo.setAvatar(umsAdmin.getIcon());
        return BaseResult.ok().put(BaseResult.CodeStatus.OK,"获取用户信息成功！","data",loginInfo);
    }

    /**
     * 用户退出/注销
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public BaseResult logout(HttpServletRequest request) {
        String token = request.getParameter("access_token");
        // readAccessToken读取token，removeAccessToken清除token
        tokenStore.removeAccessToken(tokenStore.readAccessToken(token));
        return BaseResult.ok(BaseResult.CodeStatus.OK,"用户退出成功!");
    }
}
