package com.dragon.controller;

import java.io.BufferedReader;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.x500.X500Principal;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.cryptacular.util.CertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.model.CertUpload;
import com.dragon.model.User;
import com.dragon.services.CertDeleteServiceDao;
import com.dragon.services.CertViewServiceDao;
import com.dragon.services.LoginServiceDao;

@Controller
public class ViewController {
	
	@Autowired
	CertViewServiceDao certviewdao;
	
	@Autowired
	CertDeleteServiceDao certdelete;
	
	@Autowired
	LoginServiceDao login;
	
	
	@RequestMapping(value = {"/view-user-{userid}"})
	public String uploadPage(ModelMap model, @PathVariable ("userid") String userid) throws CertificateException, IOException{
		
		System.out.println(userid);
		
		
		
		
		System.out.println("In view");
		long uid = Integer.parseInt(userid);
		
			
		User u = (User) login.FindByKey(uid);
		if(uid == 1){
			model.addAttribute("username", "admin");
			
		}
		else
		{
			model.addAttribute("username", u.getUsername());
		}
		if(login.checkLogin(u.getUsername(), u.getPassword()) == uid){
			
		
			System.out.println(uid);
			List<CertUpload> cert = certviewdao.findAllByUserId(uid);
			
			if(cert.size()== 0){
				return "NoCert";
						
			}
			else
			{
				
				//model.addAttribute("user", cert.get(0).getUser().getUsername());
				
				
				
				for(CertUpload c : cert){
					System.out.println(c.getId()+ " " + c.getCertName()  );
				}

				List<Map> list = new ArrayList();

				for(CertUpload obj:cert)
					
				{
					
				    byte ptext[] = (byte [])obj.getData();
				    String value = new String(ptext);
		//		    byte[] decoded = Base64.getDecoder().decode(value);
		//		    
				    ByteArrayInputStream in = new ByteArrayInputStream(ptext);
		//		    String v = new String(decoded);
				    //System.out.println(value);
				  //  break;
		//		   // value.chars().
				    
				    
				    CertificateFactory fact = CertificateFactory.getInstance("X.509");
				    InputStream is =  new  ByteArrayInputStream(ptext);
				    
				    
				    X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
				    
				    //cer.checkValidity();
				    model.addAttribute("userid", userid);
				    Map m = new HashMap();
				    
				    m.put("certid", obj.getId());
				    
				    System.out.println(obj.getUser().getUsername());
				    String user = obj.getUser().getUsername();
				    m.put("user", user);
				    m.put("CN", CertUtil.subjectCN(cer));
				    int start =  cer.getIssuerX500Principal().getName().indexOf("CN", 0);
				    System.out.println(start);
				   int end = cer.getIssuerX500Principal().getName().indexOf(',', start);
				    String x = cer.getIssuerX500Principal().getName().substring(start+3,end);
				    m.put("issuer", x);
				    m.put("algo", cer.getSigAlgName());
				    try {
			               cer.checkValidity();
			               m.put("validity", "valid");
			               } catch(CertificateExpiredException cee) {
			            	   m.put("validity", "expired");
			            }
				    
				    
				    m.put("version", cer.getVersion());
				    

				    System.out.println(CertUtil.subjectCN(cer));
				    
				    
				    
				    System.out.println(cer.getIssuerX500Principal().getName());
				   // System.out.println(cer.getIssuerDN().getName());
				  //  System.out.println(cer.checkValidity());
				    
				    list.add(m);
				  //  System.out.println();
				}
				model.addAttribute("certid", "certid");
				model.addAttribute("user", "user");
				
				model.addAttribute("CN", "CN");
				model.addAttribute("issuer", "issuer");
				model.addAttribute("algo", "algo");
				model.addAttribute("validity", "validity");
				model.addAttribute("version", "version");
				
				
				
					model.addAttribute("lists", list);
				
				
			
				
				return "certs";
				
			}
		}
		else
		{
			return "login";
		}
		//cert.forEach(System.out::println);
		//System.out.println(Arrays.toString(cert.toArray()));
		
		//return "upload";
	}
	
	@RequestMapping(value = {"/delete-{userid}-{certid}"})
	public String DeleteCert(ModelMap model, @PathVariable ("userid") String userid,@PathVariable ("certid") String certid){
		
		long cid = Integer.parseInt(certid);

		
		
		certdelete.delete(cid);
		
		return "redirect:/view-user-{userid}";
		
		
	}
	
	@RequestMapping(value = {"/download-{userid}-{certid}"})
	public void DownloadCert(ModelMap model,HttpServletResponse response, @PathVariable ("userid") String userid,@PathVariable ("certid") String certid) throws SQLException{
		
		long cid = Integer.parseInt(certid);

		
		
		CertUpload c = certdelete.download(cid);
		
	//	System.out.println(responseString);		
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +c.getCertName()+ "\"");
			OutputStream out = response.getOutputStream();
			//System.out.println();
			//response.setContentType(c.);
			IOUtils.copy(new ByteArrayInputStream((byte[])c.getData()), out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//return "redirect:/view-user-{userid}";
		
		
	}
	
	

}
