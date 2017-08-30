package com.dragon.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dragon.model.CertUpload;
import com.dragon.model.User;
import com.dragon.services.CertUploadServiceDao;
import com.dragon.services.LoginServiceDao;

@Controller
public class CertUploadController {
	
	@Autowired
	CertUploadServiceDao uploadservice;
	@Autowired
	LoginServiceDao logind;
	
	
	@RequestMapping(value = {"/upload-user-{userid}"})
	public String uploadPage(ModelMap model, @PathVariable ("userid") String userid){
		System.out.println(userid);
		model.addAttribute("userid", userid);
		System.out.println("In upload");
		
		return "upload";
	}
	
	@RequestMapping(value = {"/upload-user-{userid}-add"})
	public String Uploading(ModelMap model, @PathVariable  String userid, @RequestParam ("upload") CommonsMultipartFile upload) throws IOException{
		System.out.println("in here");
		
		//if (f != null && f.length > 0)
		System.out.println(upload);
		System.out.println(upload.getOriginalFilename());
		System.out.println(userid);
		
		
		CertUpload cert = new CertUpload();
		cert.setCertName(upload.getOriginalFilename());
		cert.setData(upload.getBytes());
		
		long uid = Integer.parseInt(userid);
		
		
		User u = logind.FindByKey(uid);
		System.out.println(uid + "   here");
		
		cert.setUser(u);
		
		System.out.println("Uploading");
		
		
		System.out.println(cert);
		uploadservice.upload(cert);
		 return "success";
		
		
		
		
		
	}

}
