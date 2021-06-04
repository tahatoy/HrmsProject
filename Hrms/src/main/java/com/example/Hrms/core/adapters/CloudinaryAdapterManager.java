package com.example.Hrms.core.adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.ErrorDataResult;
import com.example.Hrms.core.utilities.SuccessDataResult;

@Service
public class CloudinaryAdapterManager implements CloudinaryAdapterService {

	Cloudinary cloudinary;
	private Map<String,String> valuesMap= new HashMap<>();
	
	@Autowired
	public CloudinaryAdapterManager() {
		valuesMap.put("cloud_name", "erasmus");
		valuesMap.put("api_key", "162233975787225");
		valuesMap.put("api_secret", "f18M2R_yJcUCJefryoke-U6__d0");
		cloudinary = new Cloudinary(valuesMap);
	}
	
	private File fileConvert(MultipartFile multipartFile) throws IOException{
		File file= new File(multipartFile.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(multipartFile.getBytes());
		fileOutputStream.close();
		return file;
	}
	
	@Override
	public DataResult<Map> CvImageUpload(MultipartFile multipartFile) throws IOException {
		File file= fileConvert(multipartFile);
		Map resultMap=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return new SuccessDataResult<>(resultMap);
	}


}
