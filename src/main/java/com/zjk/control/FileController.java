package com.zjk.control;

import com.zjk.common.DefList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
@RequestMapping("/image")
public class FileController {

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public void getHeadImage(HttpServletRequest request, HttpServletResponse response,
	                         @RequestParam(DefList.IMAGE_DIR) String imageDir,
	                         @RequestParam(DefList.IMAGE_NAME) String imageName) throws Exception {
		System.out.println("getImage->" + imageName);
		ServletOutputStream sos = response.getOutputStream();
		InputStream in = null;
		try {
			response.reset();
			response.setHeader("Content-Type", DefList.FILE_IMAGE);
			response.setContentType("application/octet-stream;charset=UTF-8");
			String fileName = DefList.PHOTO_PATH + imageDir + "\\" + imageName;
			File file = new File(fileName);
			if (file.exists()) {
				in = new BufferedInputStream(new FileInputStream(new File(fileName)));
			}
			byte[] content = new byte[1024];
			int length;
			while ((length = in != null ? in.read(content, 0, content.length) : 0) != -1) {
				sos.write(content, 0, length);
			}
			sos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sos.close();
		}
	}
}
