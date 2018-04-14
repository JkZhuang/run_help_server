package com.zjk.control;

import com.zjk.common.DefList;
import com.zjk.entity.UserInfo;
import com.zjk.param.ChangeUserInfoParam;
import com.zjk.param.LoginParam;
import com.zjk.param.RegisteredParam;
import com.zjk.result.ChangeUserInfoResult;
import com.zjk.result.LoginResult;
import com.zjk.result.RegisteredResult;
import com.zjk.service.UserService;
import com.zjk.util.GsonUtil;
import com.zjk.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserControl {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register")
	@ResponseBody
	public String register(@RequestParam(value = "file") MultipartFile file,
	                       HttpServletRequest request) {
		RegisteredParam param = GsonUtil.toObj(request.getParameter(DefList.JSON), RegisteredParam.class);
		param.userInfo.setHeadUrl(UploadFileUtil.upLoadFile(file, DefList.FILE_HEAD, param.userInfo.getPhone()));
		RegisteredResult result = new RegisteredResult();
		int status = userService.insert(param.userInfo);
		if (status == 1) {
			result.bool = true;
			result.status = 1;
		} else if (status == 2) {
			result.bool = false;
			result.status = 2;
			result.errMsg = "您输入的账号已注册，请直接登录";
		} else {
			result.bool = false;
			result.status = 0;
			result.errMsg = "注册失败，请稍后重试";
		}
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(@RequestBody LoginParam param) {
		LoginResult result = new LoginResult();
		UserInfo userInfo = userService.query(param.userInfo);
		if (userInfo == null) {
			result.status = 2;
			result.errMsg = "您输入的手机号暂未注册";
		} else {
			if (userInfo.getuId() == -1) {
				result.status = 0;
				result.errMsg = "您输入的密码有误";
			} else {
				result.status = 1;
				result.userInfo = userInfo;
			}
		}
		return GsonUtil.toJson(result);
	}

	@RequestMapping(value = "/changeUserInfo")
	@ResponseBody
	public String changeUserInfo(@RequestBody ChangeUserInfoParam param) {
		ChangeUserInfoResult result = new ChangeUserInfoResult();
		boolean status = userService.update(param.userInfo);
		if (status) {
			result.bool = true;
			result.status = 1;
		} else {
			result.bool = false;
			result.status = 0;
			result.errMsg = "修改信息失败，请稍后重试";
		}
		return GsonUtil.toJson(result);
	}
}
