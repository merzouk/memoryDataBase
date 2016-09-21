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
 * Fichier 		:	UpdateCreatePersonImpl.java
 * Cree le 		: 	20 sept. 2016 à 22:57:12
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.PersonDao;
import com.org.model.PersonModel;
import com.org.usecases.UpdateCreatePerson;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases.impl
 * @date    : 20 sept. 2016 22:57:12
 */
@Service("updateCreatePerson")
public class UpdateCreatePersonImpl implements UpdateCreatePerson<PersonModel>
{
   
   @Autowired
   private PersonDao<PersonModel, Integer> personDao;
   
   /**
    * 
    * @see com.org.usecases.UpdateCreatePerson#update(java.lang.Object)
    */
   @Override
   public PersonModel update( PersonModel t )
   {
      return personDao.update( t );
   }
   
   /**
   * 
   * @see com.org.usecases.UpdateCreatePerson#create(java.lang.Object)
   */
   @Override
   public PersonModel create( PersonModel t )
   {
      return personDao.create( t );
   }
}
