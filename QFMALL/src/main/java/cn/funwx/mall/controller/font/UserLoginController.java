package cn.funwx.mall.controller.font;

import cn.funwx.mall.common.Constants;
import cn.funwx.mall.common.ResultGenerator;
import cn.funwx.mall.pojo.Category;
import cn.funwx.mall.pojo.User;
import cn.funwx.mall.service.CategoryService;
import cn.funwx.mall.service.RegisterService;
import cn.funwx.mall.service.UserLoginService;
import cn.funwx.mall.service.impl.MobileUserRegisterService;
import cn.funwx.mall.utils.AliyunSmsUtil;
import cn.funwx.mall.utils.EncryptUtil;
import cn.funwx.mall.utils.Result;
import cn.funwx.mall.utils.UUIDUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.io.File;
import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author liu66
 */
@RequestMapping("/")
@Controller
public class UserLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private MobileUserRegisterService proccesor;

    @Autowired
    private RegisterService registerService;
    
    @Autowired
	private CategoryService categoryService;

    /** 首页  */
    private static final String INDEX_PAGE = "/index";
    /** 登录页面  */
    private static final String LOGIN_PAGE = "/user/login";
    /** 注册页面   */
    private static final String REGISTER_PAGE = "/user/register";

    /** 我的资料   */
    private static final String MY_PAGE = "/user/my_information";
    /** 课程列表 */
    private static final String MYCOURSE_PAGE = "/course/course";
    /** 已购课程 */
    private static final String MYGOODS_PAGE = "/mygoods/myGoods";
    /** 课程列表 */
    private static final String QUESTION_PAGE = "/question/question";

    @RequestMapping("")
    public ModelAndView index() {
        return new ModelAndView(INDEX_PAGE);
    }

    @RequestMapping("/index")
    public ModelAndView indexPage() {
        return new ModelAndView(INDEX_PAGE);
    }
    
    @RequestMapping("/course")
    public ModelAndView course() {
        return new ModelAndView(MYCOURSE_PAGE);
    }
    
    @RequestMapping("/myGoods")
    public ModelAndView myGoods() {
        return new ModelAndView(MYGOODS_PAGE);
    }
    
    @RequestMapping("/question")
    public ModelAndView questionPage() {
        return new ModelAndView(QUESTION_PAGE);
    }

    /**
     * 登录页面
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        if (user == null) {
            return new ModelAndView(LOGIN_PAGE);
        }
        return new ModelAndView(INDEX_PAGE);
    }

    @RequestMapping("/register")
    public ModelAndView registerPage(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView(REGISTER_PAGE);
    }

    /**
     * 登录 暂时先写手机登录
     * @param request
     * @param loginName
     * @param password
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public Result doLogin(HttpServletRequest request, @RequestParam String loginName,
                          @RequestParam String password) {
        request.getSession().removeAttribute(Constants.SESSION_USER);
        User user = userLoginService.getUserByPhoneNum(loginName);
        if (user != null) {
            final String pwd = password != null ? EncryptUtil.MD5Encrypt(password.trim()) : "";
            if (user.getPassword() != null ) {//&& pwd.equals(user.getPassword())
                //记录操作时间等
                request.getSession().setAttribute(Constants.SESSION_USER, user);
               // List<Category>list=categoryService.findCategory();
        		//request.getSession().setAttribute("categoryList", list);
                return Result.suc();
            }
        }
        return Result.err("用户或密码错误!");
    }
    
    @RequestMapping("/doLogout")
    @ResponseBody
    public Result doLogout(HttpServletRequest request){
    	request.getSession().removeAttribute(Constants.SESSION_USER);
    	return Result.suc();
    }

    /**
     * 注册
     * @param request
     * @param loginName 登录名（微信 QQ 手机）
     * @param password 密码
     * @param verifyCode 验证码
     * @param regType 账号类型
     * @return
     */
    @RequestMapping("/doRegister")
    @ResponseBody
    public Result doRegister(HttpServletRequest request, @RequestParam String loginName
            , @RequestParam String password, @RequestParam String verifyCode, 
            	@RequestParam Integer regType) {
        String vcode=(String)request.getSession().getAttribute("vcode");
        if(vcode.equals(verifyCode)){
//        if(1==1){
        	try {
                User usr = new User();
                usr.setLoginName(loginName);
                //用户密码用MD5加密
                usr.setPassword(EncryptUtil.MD5Encrypt(password));
                usr.setAccountRegType(regType);
               int resultCode = registerService.registerUser(usr);
               System.out.println(resultCode);
            }catch (Exception e){
                LOGGER.error("用户注册失败！", e);
                return ResultGenerator.genFailResult("注册失败,服务器异常!");
            }
        }else{
        	 LOGGER.error("用户注册失败！");
             return ResultGenerator.genFailResult("验证码错误");
        	
        }

		return ResultGenerator.genSuccessResult();	
    }

    /**
     * 获取验证码
     * @param loginName
     * @return
     */
    @RequestMapping("/getVerifyCode")
    @ResponseBody
    public Result getVerifyCode(HttpServletRequest request,@RequestParam String loginName){
        final String key = Constants.MOBILE_REG_CACHE_PREFIX + loginName;
        Integer vCode = userLoginService.getVerifyCode(key);
        String scode=vCode+"";
        request.getSession().setAttribute("vcode", scode);
        String jcode="{\"code\":"+scode+"}";
        //发送短信
        String code=AliyunSmsUtil.SendMessage(loginName, jcode);
        System.out.println(vCode);
        if (vCode == null) {
            return Result.err("获取验证码失败！");
        }
        Result result = new Result(vCode);
        result.success();
        return result;
    }
    
    @RequestMapping("/mypage")
    public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        if (user == null) {
            return new ModelAndView(LOGIN_PAGE);
        }
        return new ModelAndView(MY_PAGE);
    }
    
    @RequestMapping(value = "/user/update", method = { RequestMethod.POST })
	public ModelAndView editUser(@RequestParam("photo") MultipartFile photo, 
								User user, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// 判断是否有文件
			if (photo != null) {
				// 设置上传路径
				String path = request.getSession().getServletContext().getRealPath("\\")+"\\img\\";
				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				// 转存文件
				// 获取文件名getOriginalFilename
//				String filename = UUIDUtil.getUUID()+photo.getOriginalFilename();
//				File file = new File(dir, filename );
				File file=new File(dir,photo.getOriginalFilename());
				photo.transferTo(file);
				user.setAvatarUrl("img/"+photo.getOriginalFilename());
				int result=userLoginService.update(user);
				System.out.println(result);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("转化图片异常:", e);
		}
		if(user.getPassword()!=null && !user.getPassword().isEmpty()){
			String pass=user.getPassword();
			user.setPassword(EncryptUtil.MD5Encrypt(pass));
		}
		user = userLoginService.getUserByUuId(user.getUuid());
		request.getSession().setAttribute(Constants.SESSION_USER, user);
		return new ModelAndView(MY_PAGE);
	}
}
