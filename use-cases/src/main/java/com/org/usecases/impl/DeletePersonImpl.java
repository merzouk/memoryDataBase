/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : use-cases
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	DeletePersonImpl.java
 * Cree le 		: 	20 sept. 2016 à 22:55:14
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.usecases.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.ContratDao;
import com.org.model.PersonModel;
import com.org.usecases.DeletePerson;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases.impl
 * @date    : 20 sept. 2016 22:55:14
 */
@Service("deletePerson")
public class DeletePersonImpl implements DeletePerson<PersonModel, Integer>
{
   private static final Logger              logger = LoggerFactory.getLogger( DeletePersonImpl.class );
   
   @Autowired
   private ContratDao<PersonModel, Integer> personDao;
   
   /**
    * 
    * @see com.org.usecases.DeletePerson#deleteById(java.io.Serializable)
    */
   @Override
   public void deleteById( Integer primaryKey )
   {
      logger.info( "deleteById" );
      personDao.deleteById( primaryKey );
   }
   
   /**
    * 
    * @see com.org.usecases.DeletePerson#delete(java.lang.Object)
    */
   @Override
   public void delete( PersonModel t )
   {
      logger.info( "delete" );
      personDao.delete( t );
   }
}
