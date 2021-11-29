package com.aurionpro.userfavourite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aurionpro.userfavourite.valueobject.FavouriteDetailsBO;

@Repository
public interface FavouriteServiceRepository extends JpaRepository<FavouriteDetailsBO,Long>{
	
	  @Query("SELECT id FROM FavouriteDetailsBO fav WHERE fav.cashProProductId = :cashProProductId"
	  		+ " and fav.favouriteType = :favouriteType and fav.userId = :userId and fav.moduleName = :moduleName and fav.favouriteDetail = :favouriteDetail")
	  public Long findFavourite(@Param("cashProProductId") Long cashProProductId,@Param("favouriteType") String favouriteType,@Param("userId") Long userId,
			  @Param("moduleName") String moduleName, @Param("favouriteDetail") String favouriteDetail);
	  
	  @Query("SELECT id FROM UserDetailsBO usr WHERE usr.loginid = :loginid")
	  public Long findUserID(@Param("loginid") String loginid);
	  
	  @Query("SELECT paramVal FROM ParameterBO param WHERE param.paramKey = :paramKey")
	  public String findParamValue(@Param("paramKey") String paramKey);
	  
	  @Query("SELECT fav FROM FavouriteDetailsBO fav WHERE fav.cashProProductId = :cashProProductId"
		  		+ " and fav.favouriteType = :favouriteType and fav.userId = :userId and fav.moduleName = :moduleName")
	  public List<FavouriteDetailsBO> findFavouriteForUser(@Param("cashProProductId") Long cashProProductId,@Param("favouriteType") String favouriteType,@Param("userId") Long userId,
				  @Param("moduleName") String moduleName);
	
}
