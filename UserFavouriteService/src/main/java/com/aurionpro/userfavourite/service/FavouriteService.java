package com.aurionpro.userfavourite.service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.userfavourite.encryption.EncryptUtils;
import com.aurionpro.userfavourite.entity.FavouriteDetail;
import com.aurionpro.userfavourite.repository.FavouriteServiceRepository;
import com.aurionpro.userfavourite.utils.Constants;
import com.aurionpro.userfavourite.valueobject.FavouriteDetailsBO;



@Service
public class FavouriteService {

	@Autowired
	private FavouriteServiceRepository favouriteRepository;
	
/*	@Autowired
	private RestTemplate restTemplate;*/

	public void save(FavouriteDetail favouriteDetail) throws Exception{
			Integer paramValue = Constants.DEFAULTMAXQUICKLINKCOUNT;
			Integer count=0;
			
			Long findUserId = favouriteRepository.findUserID(favouriteDetail.getUserId());
			List<FavouriteDetailsBO> findUserFavourite = favouriteRepository.findFavouriteForUser(EncryptUtils.decryptId(favouriteDetail.getCashProProductId()), favouriteDetail.getFavouriteType(), 
					findUserId, favouriteDetail.getModuleName());
			
			if(findUserFavourite!=null)
				count=findUserFavourite.size();
			
			String findParamValue = favouriteRepository.findParamValue(Constants.FAV_PARAM_KEY);
			if(null!=findParamValue&& !findParamValue.equals("0")){
				paramValue = Integer.parseInt(findParamValue);
			}
			
			if(paramValue <= count) 
			{
				throw new Exception(Constants.MSGKEY_QUICK_LINK_COUNT_BE_IN_LIMIT + count);
			}
			else 
			{
				FavouriteDetailsBO detailBO=new FavouriteDetailsBO();
				detailBO.setCashProProductId(EncryptUtils.decryptId(favouriteDetail.getCashProProductId()));
				detailBO.setFavouriteDetail(favouriteDetail.getFavouriteDetail());
				detailBO.setFavouriteName(favouriteDetail.getFavouriteName());
				detailBO.setFavouriteType(favouriteDetail.getFavouriteType());
				detailBO.setModifiedOn(new Date());
				detailBO.setModuleName(favouriteDetail.getModuleName());
				detailBO.setModifiedBy(favouriteDetail.getUserId());
				detailBO.setUserId(findUserId);
				favouriteRepository.save(detailBO);
			}
		 
	}
	
	public void removeFavourite (FavouriteDetail favouriteDetail) throws Exception
	{
		Long findUserId = favouriteRepository.findUserID(favouriteDetail.getUserId());
		Long findFavourite = favouriteRepository.findFavourite(EncryptUtils.decryptId(favouriteDetail.getCashProProductId()), favouriteDetail.getFavouriteType(), 
				findUserId, favouriteDetail.getModuleName(), favouriteDetail.getFavouriteDetail());
		
		if(findFavourite!=null)
			favouriteRepository.deleteById(findFavourite);
		else
			throw new Exception(Constants.MSGKEY_NO_RECORDS);
	}
	
	
	public List<FavouriteDetail> getAllFavourites()
	{
		 List<FavouriteDetailsBO> findAll = favouriteRepository.findAll();
		 List<FavouriteDetail> favDetails = new LinkedList<>();
		 
		 for(FavouriteDetailsBO bo:findAll)
		 {
			 FavouriteDetail favouriteDetail=new FavouriteDetail();
			 favouriteDetail.setCashProProductId(EncryptUtils.encryptId(bo.getCashProProductId()));
			 favouriteDetail.setFavouriteDetail(bo.getFavouriteDetail());
			 favouriteDetail.setFavouriteName(bo.getFavouriteName());
			 favouriteDetail.setFavouriteType(bo.getFavouriteType());
			 favouriteDetail.setModifiedBy(bo.getModifiedBy());
			 favouriteDetail.setModifiedOn(bo.getModifiedOn());
			 favouriteDetail.setModuleName(bo.getModuleName());
			 favouriteDetail.setUserId(EncryptUtils.encryptId(bo.getUserId()));
			 favDetails.add(favouriteDetail);
		 }
		 return favDetails;
	}


}
