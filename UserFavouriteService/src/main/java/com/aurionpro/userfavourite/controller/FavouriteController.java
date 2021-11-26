package com.aurionpro.userfavourite.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.userfavourite.entity.BaseResponseMap;
import com.aurionpro.userfavourite.entity.FavouriteDetail;
import com.aurionpro.userfavourite.service.FavouriteService;


@RestController
@RequestMapping("/favouriteService")
public class FavouriteController {

	@Autowired
	private FavouriteService favouriteService;
	
	private final String ADD_FAVOURITE = "/private/addFavourite";
	private final String REMOVE_FAVOURITE = "/private/removeFavourite";
	private final String GET_ALL_FAVOURITES = "/private/getAllFavourites";
	
	@PostMapping(ADD_FAVOURITE)
	public BaseResponseMap addFavourite(
			@RequestBody FavouriteDetail favouriteDetail,
			HttpServletRequest request) throws Exception {
		
		//ValidatorUtils.validate(favouriteDetail, getClass().getCanonicalName(),"addFavourite");
		favouriteService.save(favouriteDetail);
		BaseResponseMap response = new BaseResponseMap();
		response.getResponseStatus().setMessage("Favourite has been saved successfully.");
		return response;
	}
	
	@PostMapping(REMOVE_FAVOURITE)
	public BaseResponseMap removeFavourite(@RequestBody FavouriteDetail favouriteDetail,
			HttpServletRequest httpRequest) throws Exception {
		//ValidatorUtils.validate(request, getClass().getCanonicalName(),"removeFavourite");
		 favouriteService.removeFavourite(favouriteDetail);
		 BaseResponseMap response = new BaseResponseMap();
		 response.getResponseStatus().setMessage("Favourite has been deleted successfully.");
		 return response;
	}
	
	
	@PostMapping(GET_ALL_FAVOURITES)
	public BaseResponseMap getAllFavourites(
			@RequestBody FavouriteDetail favouriteDetail, HttpServletRequest httpRequest)
			throws Exception {
		//	ValidatorUtils.validate(request, getClass().getCanonicalName(),"getAllFavourites");
		  List<FavouriteDetail> allFavourites = favouriteService.getAllFavourites();
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  BaseResponseMap response = new BaseResponseMap();
		  dataMap.put("favouriteDetails", allFavourites);
		  response.setDataMap(dataMap);
		  return response;
	}
	
}
