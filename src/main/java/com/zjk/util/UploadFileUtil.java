package com.zjk.util;

import com.zjk.common.DefList;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

public class UploadFileUtil {

	/**
	 * 保存文件到本地
	 *
	 * @param file
	 * @param targetPath 目标文件夹
	 * @param phone
	 * @return
	 */
	public static String upLoadFile(MultipartFile file, String targetPath, String phone) {
		String url;
		if (!file.isEmpty()) {
			try {
				File dir = new File(DefList.FILE_ROOT_DIR + File.separator + targetPath);
				if (!dir.exists() && !dir.mkdirs()) {
					System.out.println("空间不足");
					return DefList.EMPTY;
				}
				String imageName = getDisImageName(phone, file.getOriginalFilename());
				File serverFile = new File(dir.getAbsolutePath() + File.separator
						+ imageName);
				file.transferTo(serverFile);
				url = "imageDir=" + targetPath + "&imageName=" + imageName;
				System.out.println("写入文件" + file.getOriginalFilename() + "成功");
			} catch (Exception e) {
				url = DefList.EMPTY;
				System.out.println("写入文件" + file.getOriginalFilename() + " => " + e.getMessage());
			}
		} else {
			url = DefList.EMPTY;
			System.out.println(file.getOriginalFilename() + "文件不存在");
		}
		return url;
	}

	public static String getDisImageName(String phone, String originName) {
		return phone + DateUtil.dateToFileNameString(new Date()) + originName;
	}
}
