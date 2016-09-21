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
 * Fichier 		:	LoadPersonImpl.java
 * Cree le 		: 	20 sept. 2016 à 22:56:28
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.usecases.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.ContratDao;
import com.org.model.PersonModel;
import com.org.usecases.LoadPerson;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases.impl
 * @date    : 20 sept. 2016 22:56:28
 */
@Service("loadPerson")
public class LoadPersonImpl implements LoadPerson<PersonModel, Integer>
{
   
   @Autowired
   private ContratDao<PersonModel, Integer> personDao;
   
   /**
    * 
    * @see com.org.usecases.LoadPerson#getAll()
    */
   @Override
   public List<PersonModel> getAll()
   {
      return personDao.getAll();
   }
   
   /**
    * 
    * @see com.org.usecases.LoadPerson#getById(java.io.Serializable)
    */
   @Override
   public PersonModel getById( Integer primaryKey )
   {
      return personDao.read( primaryKey );
   }
}
