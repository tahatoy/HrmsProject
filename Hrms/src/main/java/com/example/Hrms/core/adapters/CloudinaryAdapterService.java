package com.example.Hrms.core.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.Hrms.core.utilities.DataResult;

public interface CloudinaryAdapterService {
	DataResult<Map> CvImageUpload(MultipartFile multipartFile) throws IOException;

}
