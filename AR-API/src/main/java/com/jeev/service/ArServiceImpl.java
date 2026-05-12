package com.jeev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jeev.binding.App;
import com.jeev.entities.AppEntity;
import com.jeev.entities.UsersIES;
import com.jeev.exception.SsaWebException;
import com.jeev.repositories.AppRepo;
import com.jeev.repositories.UsersRepo;

@Service
public class ArServiceImpl implements ArService{

	@Autowired
	private AppRepo apprepo;
	
	@Autowired
	private UsersRepo userrepo;
	
	private static final String SSA_WEB_API_URL = "http://ssa.web.app";
	
	@Override
	public String createApplication(App app) {
		// TODO Auto-generated method stub
		try {
			WebClient webclient = WebClient.create();
			String statename = webclient.get().uri(SSA_WEB_API_URL, app.getSsn()).retrieve().bodyToMono(String.class).block();
			if("RI".equals(statename)) {
				UsersIES userentity = userrepo.findById(app.getUserid()).orElseThrow(() ->
				new RuntimeException("User Not Found"));
				AppEntity entity = new AppEntity();
				BeanUtils.copyProperties(app, entity);
				entity = apprepo.save(entity);
				entity.setUser(userentity);
				return "App Created with case num : "+ entity.getCaseNum();
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new SsaWebException(e.getMessage());
		}
		return "Invalid SSN";
	}

	@Override
	public List<App> fetchApps(Integer userid) {
		// TODO Auto-generated method stub
		UsersIES userentity = userrepo.findById(userid).orElseThrow(() ->
		new RuntimeException("User Not Found"));
		Long roleId = userentity.getRoleId();
		
		List<AppEntity> apps = null;
		
		if(1 == roleId) {
			apps = apprepo.findAll();
		}else {
			apps = apprepo.fetchCwApps(userid);
		}
		List<App> aps = new ArrayList<>();
		for(AppEntity entity : apps) {
			App app = new App();
			BeanUtils.copyProperties(entity, apps);
			aps.add(app);
		}
		return aps;
	}

}
